package xyz.guqing.app;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author guqing
 * @date 2020-01-31 13:21
 */
public class JschUtilTest {

    @Test
    public void test() {
        //新建会话
        Session session = JschUtil.getSession("182.61.13.201", 22, "root", "");
        String result = JschUtil.exec(session, "uname -r", StandardCharsets.UTF_8);
        System.out.println(result);
    }
}
