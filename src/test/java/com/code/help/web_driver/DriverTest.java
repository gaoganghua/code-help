package com.code.help.web_driver;

import com.code.help.util.PatternUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverTest {
    @Test
    public void test() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/opt/soft/chromedriver");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--test-type", "--ignore-certificate-errors");
//        options.addArguments("user-data-dir=/opt/soft/chrome_options");
//        options.addArguments("--args", "--disable-web-security");
//
//        DesiredCapabilities cap=DesiredCapabilities.chrome();
//
//        // 设置变量ACCEPT_SSL_CERTS的值为True
//        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//        WebDriver driver = new ChromeDriver(options);

        System.setProperty("webdriver.gecko.driver", "/opt/soft/geckodriver");
        WebDriver driver = new FirefoxDriver();
//        driver.get("http://www.baidu.com");
        driver.get("https://hhd.mifang86.com/#/home_phone?phone_login=true");

        Point point = new Point(150, 150);
//声明dimension对象,两个500表示浏览器窗口的长度和宽度
        Dimension dimension = new Dimension(100, 100);
//设定浏览器窗口的大小为长500 宽500
        driver.manage().window().setSize(dimension);
//最大化浏览器
        driver.manage().window().maximize();


        while (true) {
            try {
                new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[starts-with(@id, 'l-captcha_')]"))));
                break;
            }catch (Exception e){

            }

        }
        driver.findElement(By.xpath("//div[starts-with(@id, 'l-captcha_')]")).click();
//        TimeUnit.SECONDS.sleep(2);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@id, 'captcha_widget_')]")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//返回搜索按钮上的文字
        String text = (String) js.executeScript("var divs = document.getElementById(\"l_captcha_widget\");\n" +
                "                     var buttons = divs.getElementsByTagName('span')\n" +
                "                      var btn;\n" +
                "                     for(var i =0; i<buttons.length; i++){\n" +
                "                           if(buttons[i].className == 'captcha-widget-text'){\n" +
                "                               btn = buttons[i]\n" +
                "                           }\n" +
                "                     };\n" +
                "return btn.innerHTML");
        System.out.println("btn name:" + text);


        String page = driver.getPageSource();
        System.out.println(page);
//        driver.

        driver.switchTo().defaultContent();

//        WebElement element = driver.findElement(By.id("kw"));
//        element.sendKeys("gaoganghua");
//
//        element.submit();
//
//        Alert alert = driver.switchTo().alert();
//        driver.switchTo().defaultContent();

//        TimeUnit.SECONDS.sleep(5);
        driver.quit();

    }

    private BufferedImage recoverImg(String iframePage, String referer) throws Exception {
        List<String> itemlist = (List<String>) XPathFactory.newInstance().newXPath().compile("//div[@class='item']").evaluate(iframePage, XPathConstants.STRING);
        List<Point> picPoints = new ArrayList<>();

        String pattern = "([-\\d]+)px ([-\\d]+)px;";
        Pattern r = Pattern.compile(pattern);
        for (String item : itemlist) {
            Matcher matcher = r.matcher(item);
            matcher.find();
            picPoints.add(new Point(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2))));
        }

        String style = itemlist.get(0);
        String url = Pattern.compile("style.+(http.*png)").matcher(style).group(1);

//        ProtocolInput input = new ProtocolInput();
//        Map<String, String> headers = new HashMap<String, String>();
//        headers.put("Referer", referer);
//        input.setUrl(url).addHeaders(headers);
//        ProtocolOutput output = WebClientUtil.getWebClient().getProtocolOutput(input);
//
//        byte[] bytes = output.getContent().getContent();
        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(url).build();
        Response resp = client.newCall(req).execute();
        byte[] bytes = resp.body().bytes();


        byte[] newImg = new byte[bytes.length];
        System.arraycopy(bytes, 0, newImg, 0, bytes.length);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        BufferedImage imgSrc = ImageIO.read(bais);
        BufferedImage targetImg = ImageIO.read(new ByteArrayInputStream(newImg));
        //绘制上半区
        int cursorX = 0;
        for (int a = 0; a < picPoints.size() / 2; a++) {
            Point point = picPoints.get(a);
            int startX = -point.getX();
            int startY = -point.getY();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 80; j++) {
                    int color = imgSrc.getRGB(i + startX, j + startY);
                    targetImg.setRGB(cursorX + i, j, color);

                }
            }
            cursorX += 20;
        }
        //绘制下半区
        cursorX = 0;
        for (int a = picPoints.size() / 2; a < picPoints.size(); a++) {
            Point point = picPoints.get(a);
            int startX = -point.getX();
            int startY = -point.getY();
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 80; j++) {
                    int color = imgSrc.getRGB(i + startX, j + startY);
                    targetImg.setRGB(cursorX + i, j + 80, color);
                }
            }
            cursorX += 20;
        }

//        ImageIO.write(targetImg, "png", new File("./newImg.png"));
        return targetImg;
    }

}
