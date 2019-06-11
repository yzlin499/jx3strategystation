package top.yzlin.test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class CommonTest {

    @Test
    public void skilltest() throws IOException {

        File file = new File("c:/yzlin");
        System.out.println(new File(file, "/upload/js/yzlin"));
    }

}
