package com.code.help.spider.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.LinkedList;
import java.util.List;

public class ParseUtils {
    private static final XPathFactory xpathFactory = XPathFactory.newInstance();

    public static XPath getXpath() {
        return xpathFactory.newXPath();
    }

    public static List<String> parseNode(String root, String exp) throws XPathExpressionException {
        List<String> nodes = new LinkedList<>();
        Object result = getXpath().evaluate(exp, root, XPathConstants.NODESET);

        if (result instanceof NodeList) {
            NodeList nodeList = (NodeList) result;
            for (int i = 0; i < nodeList.getLength(); i++) {
                nodes.add(nodeList.item(i).getNodeValue());
            }
        }
        return nodes;
    }

    public static List<String> parseNodeByJsoup(String content, String exp) throws XPathExpressionException {
        List<String> values = new LinkedList<>();
        byte flag = 1;
        int index = 0;
        String[] attrs = null;
        if (exp.contains("text()")) {
            flag = 2;
            index = exp.indexOf("/text");
        }
        if (exp.contains("html()")) {
            flag = 3;
            index = exp.indexOf("/html");
        }
        if (exp.contains("/[:")) {
            flag = 4;
            index = exp.indexOf("/[:");
            String attrsStr = exp.substring(index + 3, exp.lastIndexOf("]"));
            attrs = attrsStr.split(",");
        }
        if (index > 0) {
            exp = exp.substring(0, index);
        }


        Document document = Jsoup.parse(content);
        Elements elements = document.select(exp);

        for (Element element : elements) {
            switch (flag) {
                case 1:
                    values.add(element.val());
                    break;
                case 2:
                    values.add(element.text());
                    break;
                case 3:
                    values.add(element.outerHtml());
                    break;
                case 4:
                    values.add(dealAttrs(element, attrs));
            }
        }
        return values;
    }

    private static String dealAttrs(Element element, String[] attrs) {
        StringBuffer sb = new StringBuffer();
        for (String attr : attrs) {
            sb.append(element.attr(attr) + ";");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) throws XPathExpressionException {
        String s = " <table id=\"ip_list\">\n" +
                "    <tr>\n" +
                "      <th class=\"country\">国家</th>\n" +
                "      <th>IP地址</th>\n" +
                "      <th>端口</th>\n" +
                "      <th>服务器地址</th>\n" +
                "      <th class=\"country\">是否匿名</th>\n" +
                "      <th>类型</th>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>27.42.168.46</td>\n" +
                "      <td>48919</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-11-14/guangdong\">广东中山</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>110.72.36.95</td>\n" +
                "      <td>8123</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-12-08/guangxi\">广西贵港</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>101.251.255.50</td>\n" +
                "      <td>38187</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-09-28/beijing\">北京</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTP</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>218.76.253.201</td>\n" +
                "      <td>61408</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-09-25/hunan\">湖南永州</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTPS</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"odd\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>58.218.201.188</td>\n" +
                "      <td>58093</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-10-09/jiangsu\">江苏徐州</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTPS</td>\n" +
                "    </tr>\n" +
                "  \n" +
                "    <tr class=\"\">\n" +
                "      <td class=\"country\"><img src=\"http://fs.xicidaili.com/images/flag/cn.png\" alt=\"Cn\" /></td>\n" +
                "      <td>113.128.148.34</td>\n" +
                "      <td>8118</td>\n" +
                "      <td>\n" +
                "        <a href=\"/2018-12-09/shandong\">山东济南</a>\n" +
                "      </td>\n" +
                "      <td class=\"country\">高匿</td>\n" +
                "      <td>HTTPS</td>\n" +
                "    </tr>\n" +
                "  </table>";
        List<String> texts = ParseUtils.parseNodeByJsoup(s, "table#ip_list tr td:eq(0) img/[:src,alt]");
        for (String ss : texts) {
            System.out.println(ss);
        }
    }
}
