package xyz.guqing.app.service.strategy.environment;

import org.springframework.stereotype.Component;
import xyz.guqing.app.service.EnvironmentStrategy;

/**
 * CentOS系统下的环境策略,作为默认环境策略
 * @author guqing
 * @date 2020-01-31 15:17
 */
@Component
public class DefaultStrategy implements EnvironmentStrategy {
    @Override
    public String installAndConfigJava() {
        return null;
    }

    @Override
    public String installAndConfigDocker() {
        return null;
    }

    @Override
    public String installAndConfigMysql() {
        return null;
    }

    @Override
    public String installAndConfigNginx() {
        return null;
    }

    @Override
    public String installAndConfigCaddy() {
        return null;
    }
}
