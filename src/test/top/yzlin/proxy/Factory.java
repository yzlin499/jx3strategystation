package top.yzlin.proxy;

import java.io.IOException;

public class Factory implements BuySth {

    @Override
    public void buy() throws Exception {
        System.out.println("test");
        int a = 0;
        if (a == 1) {
            throw new Exception();
        } else if (a == 2) {
            throw new IOException();
        } else if (a == 3) {
            throw new RuntimeException();
        }
    }
}
