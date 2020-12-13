package cn.itcast.test;

import cn.itcast.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    //Java对象转为JSON字符串
    @Test
    public void test1() throws Exception {
        //1.创建person对象,导入相应的jar包
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBrithday(new Date());

        //2.创建Jackson的核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

      /*  注解：
        1. @JsonIgnore：排除属性。
        2. @JsonFormat：属性值得格式化
                * @JsonFormat(pattern = "yyyy-MM-dd")


       */
        //3.转换
         /*转换方法：1.writeValue(参数1，obj)
                      参数1：
                           File：将obj对象转换为JSON字符串，并保存到指定文件
                           Writer:将obj对象转换为JSON字符串，并将JSON数据填充到字符输出流中
                           OutputStream：将obj对象转换为JSON字符串，并将JSON数据填充到字节输出流中
                 2.writeValueAsString(obj):将对象转换为JSON字符串*/
        String s = mapper.writeValueAsString(p);
        System.out.println(s);//{"name":"张三","age":18,"gender":"男"}

/*        //writeValue(),将JSON数据写到F：//a.txt文件中
        mapper.writeValue(new File("f://a.txt"),p);

        //writeValue(),将JSON数据关联到Writer中
        mapper.writeValue(new FileWriter(new File("f://b.txt")),p);*/
    }

    @Test
    public void test2() throws Exception {
        //1.创建person对象,导入相应的jar包
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);
        p.setGender("男");
        p.setBrithday(new Date());

        Person p1 = new Person();
        p1.setName("张三");
        p1.setAge(18);
        p1.setGender("男");
        p1.setBrithday(new Date());

        Person p2 = new Person();
        p2.setName("张三");
        p2.setAge(18);
        p2.setGender("男");
        p2.setBrithday(new Date());

        List<Person> list = new ArrayList<Person>();
        list.add(p);
        list.add(p1);
        list.add(p2);

        //2.创建Jackson的核心对象，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        //[{"name":"张三","age":18,"gender":"男","brithday":"2020-10-13"},{"name":"张三","age":18,"gender":"男","brithday":"2020-10-13"},{"name":"张三","age":18,"gender":"男","brithday":"2020-10-13"}]
        System.out.println(s);
    }
    @Test
    public void test3() throws Exception {
        //1.创建JSON字符串,导入相应的jar包
        String json = "{\"name\":\"张三\",\"age\":18,\"gender\":\"男\",\"brithday\":\"2020-10-13\"}";

        //2.创建转换对象
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);
        System.out.println(person);
    }
}
