package xyz.guqing.app.service.strategy.environment;

import xyz.guqing.app.service.EnvironmentStrategy;

/**
 * Ubuntu系统下的环境安装及配置策略
 * @author guqing
 * @date 2020-01-31 15:21
 */
public class UbuntuStrategy implements EnvironmentStrategy {
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
