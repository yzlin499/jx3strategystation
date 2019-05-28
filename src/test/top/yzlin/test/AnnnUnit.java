package top.yzlin.test;

import java.lang.reflect.Proxy;

public class AnnnUnit {

    private static <T> T createDAO(Class<T> daoInterface) {
        return (T) Proxy.newProxyInstance(
                daoInterface.getClassLoader(),
                new Class[]{daoInterface},
                new IntI());
    }

    public static void main(String[] args) throws NoSuchMethodException {
        TestInt dao = createDAO(TestInt.class);
        System.out.println(dao.pai());
    }
}
