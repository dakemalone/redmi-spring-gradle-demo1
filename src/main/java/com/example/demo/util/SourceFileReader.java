package com.example.demo.util;

import java.io.InputStream;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SourceFileReader {
    private static ArrayList list = new ArrayList<>();
    public static ArrayList PathIterator(InputStream filePath) {
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
                list.add(putAttributesMap(attributes));
                Iterator<Element> iterator1 = stu.elementIterator();
                while (iterator1.hasNext()){
                    Element stuChild = iterator1.next();
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
        HashMap map = new HashMap<>();
        for (Attribute attribute : attributes_Child) {
            if (!attribute.getValue().trim().isEmpty()) {
                map.put(attribute.getName(),attribute.getValue());
            } else {
                map.put(attribute.getName(),"");
            }
        }
        return map;
    }

}
