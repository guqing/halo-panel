package xyz.guqing.app.service.strategy.environment;

import com.jcraft.jsch.Session;
import org.springframework.stereotype.Component;
import xyz.guqing.app.service.EnvironmentStrategy;

/**
 * Ubuntu系统下的环境安装及配置策略
 * @author guqing
 * @date 2020-01-31 15:21
 */
@Component
public class UbuntuStrategy implements EnvironmentStrategy {
    @Override
    public String installAndConfigJava(Session session) {
        return null;
    }

    @Override
    public String installAndConfigDocker(Session session) {
        return null;
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
}
