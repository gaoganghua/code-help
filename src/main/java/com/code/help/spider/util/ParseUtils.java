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
        boolean flag = false;
        if (exp.contains("text()")) {
            flag = true;
        }
        exp = exp.substring(0, exp.indexOf("/text"));
        Document document = Jsoup.parse(content);
        Elements elements = document.select(exp);

        for (Element element : elements) {
            if (flag) {
                values.add(element.text());
            } else {
                values.add(element.val());
            }
        }
        return values;
    }
}
