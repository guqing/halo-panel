package xyz.guqing.app.service.strategy.environment;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Component;
import xyz.guqing.app.service.EnvironmentStrategy;

import java.nio.charset.StandardCharsets;

/**
 * CentOS系统下的环境策略,作为默认环境策略
 * @author guqing
 * @date 2020-01-31 15:17
 */
@Component
public class DefaultStrategy implements EnvironmentStrategy {

    @Override
    public String installAndConfigJava(Session session) {
        return exec(session, "yum install java -y");
    }

    @Override
    public String installAndConfigDocker(Session session) {
        String result = exec(session,"yum install docker-ce docker-ce-cli containerd.io") +
                "<br/>" +
                exec(session, "systemctl start docker") +
                "<br/>" +
                exec(session, "mkdir -p /etc/docker") +
                "<br/>" +
                exec(session, "tee /etc/docker/daemon.json <<-'EOF'\n" +
                        "{\n" +
                        "  \"registry-mirrors\": [\"http://hub-mirror.c.163.com\"]\n" +
                        "}\n" +
                        "EOF") +
                "<br/>" +
                exec(session, "systemctl daemon-reload") +
                "<br/>" +
                exec(session, "systemctl restart docker");
        return result;
    }

    @Override
    public String installAndConfigMysql(Session session) {
        return null;
    }

    @Override
    public String installAndConfigNginx(Session session) {
        return null;
    }

    @Override
    public String installAndConfigCaddy(Session session) {
        return null;
    }

    private String exec(Session session, String cmd) {
        return JschUtil.exec(session, cmd, StandardCharsets.UTF_8);
    }
}
