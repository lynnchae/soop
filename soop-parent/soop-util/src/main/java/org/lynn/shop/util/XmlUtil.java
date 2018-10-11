package org.lynn.soop.util;

/**
 * Created with IntelliJ IDEA.
 * User         : ethan
 * Date         : 5/11/16
 * Time         : 6:26 PM
 * Description  : describe your class here
 */

import org.apache.commons.lang3.StringUtils;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

/**
 * xml工具类
 */
public class XmlUtil {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    public static Map<String, Object> parseXml(String strXml) {
        return parseXml(strXml, DEFAULT_CHARSET);
    }

    public static Map<String, Object> parseXml(String strXml, Charset charset) {
        return parseXml(strXml, charset, Arrays.asList("list"));
    }

    public static Map<String, Object> parseXml(String strXml, Charset charset, List<String> listNodeNames) {
        Map<String, Object> xmlMap = new LinkedHashMap<String, Object>();
        if (StringUtils.isBlank(strXml)) {
            return xmlMap;
        }
        try {
            SAXBuilder builder = new SAXBuilder();
            Document doc = builder.build(new ByteArrayInputStream(strXml.getBytes(charset)));
            Element root = doc.getRootElement();

            parseNode(xmlMap, root, listNodeNames);

        } catch (JDOMException e) {
            throw new IllegalArgumentException("parseXml() error because some dom exception", e);
        } catch (IOException e) {
            throw new RuntimeException("parseXml() error because some io exception.", e);
        }

        return xmlMap;
    }

    /**
     * parse node to map
     */
    private static Map parseNode(Map<String, Object> nodeMap, Element node, List<String> listNodeNames) {

        String key = node.getName();
        List<Element> children = node.getChildren();
        List<Attribute> attributes = node.getAttributes();

        Map<String, Object> eMap = new LinkedHashMap<String, Object>();
        if (attributes != null) {
            for (Attribute attr : attributes) {
                eMap.put(attr.getName(), attr.getValue());
            }
        }
        if (children.isEmpty()) {
            nodeMap.put(key, node.getTextTrim());
        } else {
            for (Element e : children) {
                parseNode(eMap, e, listNodeNames);
            }
            putElementToMap(nodeMap, key, eMap, listNodeNames);
        }

        return nodeMap;
    }

    /**
     * put key-value to map,if contains,then translate to list
     *
     * @param m map
     * @param k key
     * @param v value
     */
    private static void putElementToMap(Map m, String k, Object v, List<String> listNodeNames) {
        if (listNodeNames == null) listNodeNames = Collections.emptyList();
        if (m.containsKey(k)) {
            Object vo = m.get(k);
            if (vo instanceof List) {
                ((List) vo).add(v);
            } else {
                throw new RuntimeException(String.format("class type translate fail when parse xml to map.\n expect key(%s) class type list,but actual is %s", k, vo.getClass().getSimpleName()), null);
            }
        } else if (listNodeNames.contains(k)) {
            List<Object> listObject = new LinkedList<Object>();
            listObject.add(v);
            m.put(k, listObject);
        } else {
            m.put(k, v);
        }
    }


    public static String buildListXmlNode(String nodeName, List<Map<String, String>> list) {
        StringBuilder xml = new StringBuilder();
        for (Map<String, String> map : list) {
            xml.append(buildXmlNode(nodeName, map));
        }
        return xml.toString();
    }

    public static String buildXmlNode(String nodeName, Map<String, String> map) {
        return buildXmlNode(nodeName, buildXmlNodes(map));
    }

    public static String buildXmlNodes(Map<String, String> map) {
        StringBuilder xml = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String xmlNode = buildXmlNode(entry.getKey(), entry.getValue());
            xml.append(xmlNode);
        }
        return xml.toString();
    }

    public static String buildXmlNode(String name, String value) {
        return buildXmlNode(name, value, null);
    }

    public static String buildXmlNode(String name, String value, Map<String, String> attributes) {
        StringBuilder xmlNode = new StringBuilder();
        xmlNode.append("<").append(name);
        if (attributes != null) {
            for (Map.Entry<String, String> kv : attributes.entrySet()) {
                xmlNode.append(' ').append(kv.getKey()).append("=\"").append(kv.getValue()).append('"');
            }
        }
        xmlNode.append(">");
        xmlNode.append(value == null ? "" : value);
        xmlNode.append("</").append(name).append(">");
        return xmlNode.toString();
    }

}