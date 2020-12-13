package Jsoupdemo01;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupDemo03Xpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
       //获取student.xml的path
        String student = JsoupDemo03Xpath.class.getClassLoader().getResource("student.xml").getPath();
        //解析xml文档，加载文档进内存，获取dom树
        Document document = Jsoup.parse(new File(student), "utf-8");
        //获取元素对象
        JXDocument jxDocument = new JXDocument(document);
        //查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            System.out.println(jxNode);
        }
        //查询所有student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode1 : jxNodes1) {
            System.out.println(jxNode1);
        }
        //查询所有student标签下name带id属性的标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name[@id=]");
        for (JXNode jxNode2 : jxNodes2) {
            System.out.println(jxNode2);
        }

    }
}
