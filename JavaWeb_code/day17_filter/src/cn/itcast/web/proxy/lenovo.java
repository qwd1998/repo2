package cn.itcast.web.proxy;

/**
 * 真实类
 */
public class lenovo implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("花了"+money+"钱，买了一台联想电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
