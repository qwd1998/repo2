package Jsoupdemo01;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
       //获取student.xml的path
        String student = JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(student), "utf-8");
        //获取元素对象
        Elements name = document.select("name");
        //System.out.println(name);
        Elements student1 = document.select("student[number=\"heima_0001\"]>age");
        System.out.println(student1);


    }
}
