package top.yzlin.jx3strategystation.tools;

import java.io.IOException;
import java.io.InputStream;

public class CmdUtils {


    public static String getGitUserName() {
        return execCode(new String[]{"git", "config", "user.name"});
    }

    public static String execCode(String[] code) {
        try {
            Process p = Runtime.getRuntime().exec(code);
            InputStream is = p.getInputStream();
            StringBuilder sb = new StringBuilder();
            int tmp;
            while ((tmp = is.read()) != -1) {
                sb.append((char) tmp);
            }
            p.waitFor();
            is.close();
            p.destroy();
            return sb.toString().trim();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
