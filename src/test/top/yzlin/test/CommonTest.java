package top.yzlin.test;

import org.junit.Test;

import java.io.IOException;

public class CommonTest {

    @Test
    public void skilltest() throws IOException {
        System.out.println(a());
    }

    int a() {
        int a = 0;
        try {
            a = 1;
            return a++ + --a;
        } catch (Exception e) {
            a = 2;
        } finally {
            return ++a + --a + a;
        }

    }
}
