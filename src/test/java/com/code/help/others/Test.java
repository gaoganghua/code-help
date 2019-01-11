package com.code.help.others;

import com.alibaba.fastjson.JSON;
import com.code.help.spider.util.IOUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Test {
    @org.junit.Test
    public void test() throws IOException {
        String s = "JDBID=72559C25-D4E6-40B4-A853-8941E39F7FC5&RNVersion=2&accessToken=ACCESS_TOKEN8674463648107274271543241868710&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.2.0&containerTag=3&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=RsTkeLZ2uVk0XbIUmmAdxzvpK7xVfXOx6O7YR7Sf9ZpjKvxNmyiKdnQVLh4WLCI24kKiqt_Yeto236VqVjB2lfHvYMXVGLRf5Ii7kLh9Vad-CtX8gp1JXT_ZUP4p0dJdHs2KqpFzyjyj6J0PQZBolcqLFypDfFbA&friendID=586106121159555226&fullRouter=jdbclient%3A//user/guest/index?memberID%3D586106121159555226%26hideNavigation%3D1%26thumbnailUrl%3D%26searchType%3D0%26isShownFullPhoneNumber%3Dtrue%26avatarUrl%3D%26fromSearchToken%3D55aa130d538bf9f898aa8d1a56adbf9ec2d3d1c42a572a5c1753fecb64d4de01e505dd27433452658e4a27401318aa2beae875fdae9f36e749d174436032f82abefa30d96858de3cd65e800ad832c3744fdac7393f6fec50%26fromScene%3D3%26userType%3D0%26name%3D%2A%E4%BF%8A%26sourceType%3D3&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=867446364810727427&network=5&packageName=6CFC76EBF375F494E5A83AF889BFE72F&phoneVen=3&platform=iOS&proxyType=https&referer=jdbclient%3A//tab/contactInstance/index&requestTimeout=0&sessionMode=1&showName=0&showPhone=1&sysLaunchTimeInterval=82241&systemVersion=12.1&traceID=8E7B7E1FE6224357BDCCA3F26536BE6C&udid=449de86377ab5be21acd0f04fa77a04ae03fce6d&w=750";

        s = "traceID=BC4B29BE7D5F430F9E88DC3193F3EC26&bizType=3&channel=appstore&fp=&clientVersion=3.0.2.0&systemVersion=12.0.1&platform=iOS&network=4&manufacturer=Xiaomi&isRelease=1&JDBID=871c0dc06eb04df59c648f8763dc82c3&appKey=fb371c48e9a9b2a1174ed729ae888513&udid=871c0dc06eb04df59c648f8763dc82c3&deviceType=iPhone%206S&sysLaunchTimeInterval=686196&phoneVen=3&jdbId=872776017008095237&h=1334&proxyType=none&accessToken=ACCESS_TOKEN8727760170080952371546421771458&deviceID=C167821B-34FB-4C72-A023-6B890C5A65FF&w=750&sessionMode=1&isForeground=1&memberID=872776017008095237";
        //s  ="traceID=c91fd039b86945a98157693e8afeba6f&JDBID=000000006786d1f8ffffffffe32195ad&proxyType=https&appKey=fb371c48e9a9b2a1174ed729ae888513&keyword=18100178365&udid=000000006786d1f8ffffffffe32195ad&accessToken=ACCESS_TOKEN9384855754830848011544498772192&deviceID=866899022633679&memberID=938485575483084801";
        s = "traceID=BC4B29BE7D5F430F9E88DC3193F3EC26&bizType=3&channel=appstore&fp=&clientVersion=3.0.2.0&systemVersion=12.0.1&platform=iOS&network=4&manufacturer=Xiaomi&isRelease=1&JDBID=871c0dc06eb04df59c648f8763dc82c3&appKey=fb371c48e9a9b2a1174ed729ae888513&udid=871c0dc06eb04df59c648f8763dc82c3&deviceType=iPhone%206S&sysLaunchTimeInterval=686196&phoneVen=3&jdbId=872776017008095237&h=1334&proxyType=none&accessToken=ACCESS_TOKEN8727760170080952371546421771458&deviceID=C167821B-34FB-4C72-A023-6B890C5A65FF&w=750&sessionMode=1&isForeground=1&memberID=872776017008095237";
//s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=47&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&endTime=&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//user/myTrade/lend&h=1334&isForeground=1&isRelease=1&jailbreak=0&lastProductID=-1&loadType=1&maxAmount=&memberID=498592203850007902&minAmount=&monica=1546435863&network=5&onlyIou=0&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=13dd945a746507ea242ae540f4acf98c&referer=jdbclient%3A//trade/crowdfunding/index&requestTimeout=0&sessionMode=1&sortType=1&startTime=&sysLaunchTimeInterval=58850&systemVersion=12.1.2&traceID=01C8DF80BE214A78AC046C6737F90330&tradeType=&type=1&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";

        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=49&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&endTime=&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//user/myTrade/borrow?tradeType%3D0&h=1334&isForeground=1&isRelease=1&jailbreak=0&lastProductID=-1&loadType=1&maxAmount=&memberID=498592203850007902&minAmount=&monica=1546436834&network=5&onlyIou=0&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=0d85e4dbc74fbad1a79222a490a02f77&referer=jdbclient%3A//trade/crowdfunding/index&requestTimeout=0&sessionMode=1&sortType=1&startTime=&sysLaunchTimeInterval=59175&systemVersion=12.1.2&traceID=77BF612DA3D1413C880D51D5DF322265&tradeType=0&type=0&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=52&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//trade/transaction/borrowNew?productID%3D8605450437509283860001&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=498592203850007902&monica=1546437447&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&productID=8605450437509283860001&proxyType=https&rachel=9d4850f7e27e83de656f092b2c1be434&referer=jdbclient%3A//user/myTrade/borrow&requestTimeout=0&sessionMode=1&sysLaunchTimeInterval=59616&systemVersion=12.1.2&traceID=A9F15D8433C84B1788CE8360315EAB57&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=60&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&endTime=&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//user/myTrade/lend&h=1334&isForeground=1&isRelease=1&jailbreak=0&lastProductID=-1&loadType=1&maxAmount=&memberID=498592203850007902&minAmount=&monica=1546438502&network=5&onlyIou=0&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=90a8bde082d132ef0383bfbf981b3f5e&referer=jdbclient%3A//trade/crowdfunding/index&requestTimeout=0&sessionMode=1&sortType=1&startTime=&sysLaunchTimeInterval=60255&systemVersion=12.1.2&traceID=84EDB77D4C7D45EEBE9D92479EA9DBF3&tradeType=&type=1&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";

        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN8674463648107274271546491026712&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=6&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=ibuclient%3A//IBU/business/sentIbuInfo?productID%3D947113952616071176&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=867446364810727427&monica=1546500587&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&productID=947113952616071176&proxyType=https&rachel=86707a8710a2d823a2b5d1d518e0300f&referer=ibuclient%3A//IBU/business/sentIbuList&requestTimeout=0&sessionMode=1&sysLaunchTimeInterval=94167&systemVersion=12.1.2&traceID=D08E23385C53410D988CB755315B15F5&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546503517248&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=13&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//trade/crowdfunding/index&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=498592203850007902&messageID=0&monica=1546503639&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=30daeb5e9912ca485fdd59a565ce5085&referer=jdbclient%3A//tab/homeInstance/index&requestTimeout=0&sessionMode=1&sysLaunchTimeInterval=96789&systemVersion=12.1.2&traceID=425D7A64338440C49D5AD8F86E5DE31B&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        s = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&accessToken=ACCESS_TOKEN8674463648107274271546530247862&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&dataID=app_config_all&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&h=1334&isForeground=1&isRelease=1&jailbreak=0&memberID=867446364810727427&monica=1546594388&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=76e08427ef8cc3145c7dcd9295cdef21&sessionMode=1&sysLaunchTimeInterval=140801&systemVersion=12.1.2&traceID=C6D8589E9A784E658E7C302D5FDEC54F&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        for (String ss : s.split("&")) {
            if (ss.contains("=")) {
                String[] sss = ss.split("=");
                if (sss.length == 1) {
                    System.out.println(sss[0] + "=" + "");
                } else {
                    System.out.println(sss[0] + "=" + sss[1]);
                }
            } else {
                System.out.println(ss);
            }
        }
    }

    @org.junit.Test
    public void testtt() throws IOException {
        String s1 = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=9&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=ibuclient%3A//IBU/business/index&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=498592203850007902&monica=1546419693&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=18c26b30d5e9fe6ad0adc224db311dda&referer=jdbclient%3A//tab/homeInstance/index&requestTimeout=0&sessionMode=1&sysLaunchTimeInterval=48638&systemVersion=12.1.2&traceID=1CA9036AD250487588E1BFA639652D5B&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        String s2 = "JDBID=8FA41520-A6DA-4932-9DB7-7C4E4AD0FF14&RNVersion=2&accessToken=ACCESS_TOKEN4985922038500079021546408032541&appKey=fb371c48e9a9b2a1174ed729ae888513&channel=appstore&clientVersion=3.0.5.0&containerTag=10&deviceID=84B05269-B93F-41D2-8D00-0173CA1E9D47&deviceType=iPhone%206S&fp=Iu1ft00c-60tEFdqBQ7aDeVnWWpC9rgyKRgH3IJa-ImkT1WX4vblO7qr1XH_1aLwJusA1_0odafF2nT6Z6zV3mEEzkL8AWBl23GBZFYP80NrcpyYF0pmYL40YbDXQimjxzZn3QlMKtAjr4FEp1UhqcpWohex0Ieq&fullRouter=jdbclient%3A//trade/crowdfunding/index&h=1334&isForeground=1&isRelease=1&jailbreak=0&loadType=1&memberID=498592203850007902&messageID=0&monica=1546419717&network=5&packageName=F6B086B48BD426A0CE8D5FCC05837D64&phoneVen=3&platform=iOS&proxyType=https&rachel=c5512d93ef7521831bf915fa5aadc60e&referer=jdbclient%3A//tab/homeInstance/index&requestTimeout=0&sessionMode=1&sysLaunchTimeInterval=48662&systemVersion=12.1.2&traceID=7A4AB352C37742BC9DF0E7BC64C2C3AF&udid=3a8440d182028d6f7719e29b1a8b1a30dd24177b&w=750";
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        for (String ss : s1.split("&")) {
            if (ss.contains("=")) {
                String[] sss = ss.split("=");
                if (sss.length == 1) {
                    map1.put(sss[0], "");
                } else {
                    map1.put(sss[0], sss[1]);
                }
            }
        }

        for (String ss : s2.split("&")) {
            if (ss.contains("=")) {
                String[] sss = ss.split("=");
                if (sss.length == 1) {
                    map2.put(sss[0], "");
                } else {
                    map2.put(sss[0], sss[1]);
                }
            }
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey()) && map2.get(entry.getKey()).equals(entry.getValue())) {
                map2.remove(entry.getKey());
            } else {
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
        }
        System.out.println("----------");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @org.junit.Test
    public void test2() throws IOException {
        String filepath = "/Users/chancelee/Desktop/DEFAULT/aa.txt";
        Map<String, String> maps = new HashMap<>();
        BufferedReader stream = new BufferedReader(new InputStreamReader(new FileInputStream(filepath)));
        StringBuffer result = new StringBuffer();

        String l = null;
        while ((l = stream.readLine()) != null && !l.trim().equals("\n")) {
            if ("".equals(l)) {
                continue;
            }
            String[] ars = l.split("=");
            if (ars.length == 1) {
                maps.put(ars[0], "");
            } else {
                maps.put(ars[0], ars[1]);
            }
        }
        stream.close();

        for (Map.Entry<String, String> en : maps.entrySet()) {
            result.append(en.getKey() + "=" + en.getValue() + "&");
        }
        result.deleteCharAt(result.length() - 1);
        System.out.println(result.toString());
    }

    @org.junit.Test
    public void testt() {

//       String ss  = IOUtils.toJsonByFile("/Users/chancelee/Desktop/以前的文件/借条/debit_json/ypz.json", "UTF-8");
        String ss = "{\"appType\":\"jdb\",\"data\":{\"authList\":[{\"authName\":\"实名认证\",\"authStatus\":0,\"authType\":1},{\"authName\":\"肖像认证\",\"authStatus\":0,\"authType\":2},{\"authName\":\"银行卡认证\",\"authStatus\":0,\"authType\":3},{\"authName\":\"信用认证\",\"authStatus\":1,\"authType\":35},{\"authName\":\"乘机认证\",\"authStatus\":1,\"authType\":4},{\"authName\":\"社保认证\",\"authStatus\":1,\"authType\":36},{\"authName\":\"运营商实名认证\",\"authStatus\":1,\"authType\":5},{\"authName\":\"教育背景\",\"authStatus\":1,\"authType\":8},{\"authName\":\"上传通讯录\",\"authStatus\":0,\"authType\":9},{\"authName\":\"获取位置\",\"authStatus\":0,\"authType\":10},{\"authName\":\"绑定备用号\",\"authStatus\":1,\"authType\":11},{\"authName\":\"亲密联系人\",\"authStatus\":1,\"authType\":12},{\"authName\":\"上传身份证\",\"authStatus\":0,\"authType\":13},{\"authName\":\"脉脉认证\",\"authStatus\":1,\"authType\":14},{\"authName\":\"微博认证\",\"authStatus\":1,\"authType\":16},{\"authName\":\"文书送达地址\",\"authStatus\":0,\"authType\":17},{\"authName\":\"运营商报告\",\"authStatus\":1,\"authType\":18},{\"authName\":\"京东认证\",\"authStatus\":1,\"authType\":19},{\"authName\":\"在读认证\",\"authStatus\":1,\"authType\":54},{\"authName\":\"公积金认证\",\"authStatus\":1,\"authType\":27},{\"authName\":\"银联交易认证\",\"authStatus\":1,\"authType\":59}],\"baseInfo\":{\"bindStatus\":1,\"faceStatus\":1,\"gender\":1,\"headImg\":\"\",\"identNum\":2,\"jdbId\":\"888888888888888888\",\"level\":\"见习生\",\"name\":\"公信宝\",\"overdueTips\":\"最近两年内，该用户无逾期超过7天的应还款\",\"phone\":\"12300001010\",\"realNameStatus\":1,\"registerTime\":\"2018-07-26 00:00:00\"},\"contactList\":[{\"contactType\":3,\"jdbId\":\"666666666666666666\",\"name\":\"张三\",\"phone\":\"13211110000\",\"remarkName\":\"\",\"sourceType\":0},{\"contactType\":1,\"jdbId\":\"555555555555555555\",\"name\":\"李四\",\"phone\":\"13100000101\",\"remarkName\":\"\",\"sourceType\":4}],\"iouList\":[{\"appType\":\"jdb\",\"baseAmt\":3000.00,\"borrowerTime\":\"2018-12-30 00:00:00\",\"interestAmt\":9.86,\"interestRate\":24.00,\"iouCrtTime\":\"2018-12-30 00:00:00\",\"iouStatus\":2,\"iouType\":0,\"iouWayType\":1,\"landerName\":\"张三\",\"purpose\":\"线下借款\",\"repaidAmt\":0.00,\"repayTime\":\"2019-01-04 23:59:59\",\"repayType\":0,\"toRepaidAmt\":3009.86},{\"appType\":\"jdb\",\"baseAmt\":3000.00,\"borrowerTime\":\"2018-12-27 00:00:00\",\"interestAmt\":13.80,\"interestRate\":24.00,\"iouCrtTime\":\"2018-12-27 00:00:00\",\"iouStatus\":2,\"iouType\":0,\"iouWayType\":1,\"landerName\":\"李四\",\"purpose\":\"线下借款\",\"repaidAmt\":0.00,\"repayTime\":\"2019-01-03 23:59:59\",\"repayType\":0,\"toRepaidAmt\":3013.80},{\"appType\":\"jdb\",\"baseAmt\":300.00,\"borrowerTime\":\"2018-11-04 00:00:00\",\"interestAmt\":0.00,\"interestRate\":0.00,\"iouCrtTime\":\"2018-11-04 00:00:00\",\"iouStatus\":3,\"iouType\":0,\"iouWayType\":1,\"landerName\":\"王五\",\"purpose\":\"赊账\",\"repaidAmt\":300.00,\"repayTime\":\"2018-11-10 23:59:59\",\"repayType\":0,\"toRepaidAmt\":0.00},{\"appType\":\"jdb\",\"baseAmt\":1000.00,\"borrowerTime\":\"2018-12-17 00:00:00\",\"interestAmt\":3.28,\"interestRate\":24.00,\"iouCrtTime\":\"2018-12-17 00:00:00\",\"iouStatus\":3,\"iouType\":0,\"iouWayType\":1,\"landerName\":\"张三\",\"purpose\":\"其他\",\"repaidAmt\":1003.28,\"repayTime\":\"2018-12-22 23:59:59\",\"repayType\":0,\"toRepaidAmt\":0.00},{\"appType\":\"jdb\",\"baseAmt\":2150.00,\"borrowerTime\":\"2018-12-25 00:00:00\",\"interestAmt\":7.06,\"interestRate\":24.00,\"iouCrtTime\":\"2018-12-25 00:00:00\",\"iouStatus\":3,\"iouType\":0,\"iouWayType\":1,\"landerName\":\"张三\",\"purpose\":\"其他\",\"repaidAmt\":2157.06,\"repayTime\":\"2018-12-30 23:59:59\",\"repayType\":0,\"toRepaidAmt\":0.00}],\"jdbCreditInfo\":{\"currentBorrowAmount\":8600.00,\"currentLendAmount\":0.00,\"historicalBorrowAmount\":15500.00,\"historicalBorrowCount\":20,\"historicalLendAmount\":0.00,\"historicalLendCount\":0}}}";

        ss = ss.replaceAll("\n", "");
        ss = ss.replaceAll("\t", "");
        Object o = JSON.parse(ss);

        System.out.println(JSON.toJSONString(o));


    }

    public void tet() {
        String s = "{\"data\":{\"baseInfo\":{\"faceStatus\":1,\"gender\":1,\"headImg\":\"https://www.gxb.io/images/GXS-logo.png\",\"level\":\"见习生\",\"phone\":\"12312344321\",\"registerTime\":\"2018-05-28 00:00:00\",\"name\":\"公信宝\",\"realNameStatus\":1,\"bindStatus\":1,\"identNum\":5,\"overdueTips\":\"最近两年内，该用户无逾期超过7天的应还款\"},\"iouList\":[{\"interestRate\":12,\"interestAmt\":0.09,\"repayTime\":\"2018-12-03 23:59:59\",\"purpose\":\"买卖\",\"borrowerTime\":\"2018-11-30 00:00:00\",\"borrowerName\":\"张三\",\"repayType\":0,\"iouWayType\":1,\"appType\":\"jdb\",\"iouType\":1,\"baseAmt\":100,\"landerName\":\"公信宝\",\"iouStatus\":0},{\"interestRate\":24,\"interestAmt\":0.19,\"repayTime\":\"2018-12-28 23:59:59\",\"purpose\":\"赊账\",\"borrowerTime\":\"2018-11-27 00:00:00\",\"borrowerName\":\"李四\",\"repayType\":0,\"iouWayType\":1,\"appType\":\"jdb\",\"iouType\":1,\"baseAmt\":100,\"landerName\":\"公信宝\",\"iouStatus\":3}],\"contactList\":[{\"phone\":\"15512344321\",\"sourceType\":4,\"jdbId\":\"123321199001111234\",\"name\":\"张三\",\"contactType\":3,\"remarkName\":\"\"},{\"phone\":\"16812344321\",\"sourceType\":2,\"jdbId\":\"321123199007011234\",\"name\":\"李四\",\"contactType\":3,\"remarkName\":\"\"}],\"jdbCreditInfo\":{\"currentLendTop5Percent\":0,\"alreadyDoneSuretyAmount\":0,\"currentZhuanlichaTop5Percent\":0,\"currentBorrowTop5Percent\":0,\"historicalBorrowFriendCount\":0,\"historicalBorrowCount\":0,\"currentSuretyTop5Percent\":0,\"alreadyDoneZhuanlichaAmount\":0,\"alreadyDoneBorrowAmount\":0,\"historicalBorrowAmount\":0,\"historicalLendAmount\":300,\"historicalLendFriendCount\":1,\"historicalSuretyCount\":0,\"historicalZhuanlichaAmount\":0,\"historicalSuretyAmount\":0,\"currentBorrowAmount\":0,\"historicalSuretyFriendCount\":0,\"historicalZhuanlichaCount\":0,\"currentLendAmount\":200,\"currentSuretyAmount\":0,\"currentZhuanlichaAmount\":0,\"historicalLendCount\":3,\"historicalZhuanlichaFriendCount\":0,\"alreadyDoneLendAmount\":100},\"authList\":[{\"authStatus\":0,\"authName\":\"实名认证\",\"authType\":1},{\"authStatus\":0,\"authName\":\"肖像认证\",\"authType\":2},{\"authStatus\":0,\"authName\":\"银行卡认证\",\"authType\":3},{\"authStatus\":1,\"authName\":\"信用认证\",\"authType\":35},{\"authStatus\":0,\"authName\":\"上传通讯录\",\"authType\":9},{\"authStatus\":1,\"authName\":\"获取位置\",\"authType\":10},{\"authStatus\":1,\"authName\":\"绑定备用号\",\"authType\":11},{\"authStatus\":1,\"authName\":\"亲密联系人\",\"authType\":12},{\"authStatus\":1,\"authName\":\"上传身份证\",\"authType\":13},{\"authStatus\":1,\"authName\":\"运营商报告\",\"authType\":18},{\"authStatus\":1,\"authName\":\"京东认证\",\"authType\":19},{\"authStatus\":1,\"authName\":\"在读认证\",\"authType\":54},{\"authStatus\":1,\"authName\":\"公积金认证\",\"authType\":27},{\"authStatus\":1,\"authName\":\"银联交易认证\",\"authType\":59}]},\"appType\":\"jdb\"}";
    }
}
