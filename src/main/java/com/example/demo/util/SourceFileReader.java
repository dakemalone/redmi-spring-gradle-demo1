package com.example.demo.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;


@Component
public class SourceFileReader {
//    private final static String homeUrl = "C:/Users/dake/Downloads/resource/P000S001003528031B001627/P000S001003528031B001627.bzmd";
    private static LinkedList list = new LinkedList<>();
    private static HashMap<String,String> map = null;
    public static LinkedList PathIterator(InputStream filePath) {
        map = new HashMap<String,String>();
        // 创建 reader对象
        SAXReader reader = new SAXReader();
        try {
            // 加载xml文件
            Document document = reader.read(filePath);
            reader.setEncoding("uft-8");
            // 获得根节点
            Element element = document.getRootElement();
            Iterator<Element> iterator = element.elementIterator();

            while (iterator.hasNext()) {
                Element stu = iterator.next();
                List<Attribute> attributes = stu.attributes();
//                System.out.println("======get attributes======");
                list.add(putAttributesMap(attributes));
//                System.out.println("======iterator node point======");
                Iterator<Element> iterator1 = stu.elementIterator();
                while (iterator1.hasNext()){
                    Element stuChild = iterator1.next();
//                    System.out.println("node point name:"+stuChild.getName()+"node point value:"+stuChild.getStringValue());
                    List<Attribute> attributes_Child = stuChild.attributes();
                    list.add(putAttributesMap(attributes_Child));
                }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return list;
    }

    private static HashMap<String, String> putAttributesMap(List<Attribute> attributes_Child) {
        for (Attribute attribute : attributes_Child) {
            if (!attribute.getValue().trim().isEmpty()) {
//                System.out.println("attributes name:"+attribute.getName()+"attributes value:"+attribute.getValue());
                map.put(attribute.getName(),attribute.getValue());
            } else {
//                System.out.println("attributes name:"+attribute.getName());
                map.put(attribute.getName(),"");
            }
        }
        return map;
    }

}
