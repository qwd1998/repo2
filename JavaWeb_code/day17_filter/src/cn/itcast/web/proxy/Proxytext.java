package cn.itcast.web.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Proxytext {
    public static void main(String[] args) {
        //1.创建真实对象
        lenovo le = new lenovo();

        // 动态代理，增强Lenovo对象
        /*
        三个参数：真实对象.class.getClassLoader(),
                真实对象.class.getInterfaces(),
                new InvocationHandler()
         */
        SaleComputer proxy_len = (SaleComputer) Proxy.newProxyInstance(lenovo.class.getClassLoader(), lenovo.class.getInterfaces(), new InvocationHandler() {
           /*
           代理逻辑编写的方法，代理对象调用的方法都会触发该方法执行
                参数 ：1.proxy  代理对象
                      2.method：代理对象调用的方法，被封装为的对象
                      3.代理对象调用方发师，传递的实际参数

            */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               /* System.out.println("方法执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);*/

                if (method.getName().equals("sale")){
                    //增强参数
                    double money = (double) args[0];
                    money = money *0.8;
                    //使用真实对象调用方法
                    Object obj = method.invoke(le,money);
                    //增强返回值
                    return obj+"和专用鼠标";
                }else{
                    Object obj = method.invoke(le,args);
                    return obj;
                }

            }
        });
        //2.调用方法
        String sale = proxy_len.sale(5000);
        System.out.println(sale);
  /*      proxy_len.show();*/
    }
}
