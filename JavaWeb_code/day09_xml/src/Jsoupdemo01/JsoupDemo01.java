package Jsoupdemo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class JsoupDemo01 {
    public static void main(String[] args) throws IOException {
       //获取student.xml的path
        String student = JsoupDemo01.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(student), "utf-8");
        //获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        System.out.println(elements);
       //获取第一个name的对象
        Element name = elements.get(0);
        //获取对象的内容
        String text = name.text();
        System.out.println(text);
    }
}
