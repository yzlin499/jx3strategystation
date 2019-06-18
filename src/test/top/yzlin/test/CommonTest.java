package top.yzlin.test;

import org.junit.Test;

import java.io.IOException;
import java.util.Optional;
import java.util.regex.Pattern;

public class CommonTest {

    @Test
    public void skilltest() throws IOException {
        String a = null;
        Pattern pattern = Pattern.compile("\\d+");
        System.out.println(pattern.matcher(Optional.ofNullable(a).orElse("")));
    }

}
