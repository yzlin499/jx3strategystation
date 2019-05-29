package top.yzlin.proxy;

public class BussProxy implements BuySth {
    private BuySth buySth;

    public BussProxy(BuySth buySth) {
        this.buySth = buySth;
    }

    @Override
    public void buy() throws Exception {
        try {
            System.out.println("buy");
            buySth.buy();
            System.out.println("over");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
