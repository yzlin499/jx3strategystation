package top.yzlin.proxy;

public class People {


    public static void main(String[] args) throws Exception {
        BuySth buySth = new Factory();
        buySth = new BussProxy(buySth);
        buySth = new BussProxy(buySth);
        buySth = new BussProxy(buySth);
        buySth = new BussProxy(buySth);
        buySth.buy();
    }
}
