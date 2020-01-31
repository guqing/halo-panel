package xyz.guqing.app.service;

/**
 * @author guqing
 * @date 2020-01-31 15:04
 */
public interface EnvironmentStrategy {
    /**
     * 安装并配置java环境
     * @return 返回执行日志
     */
    String installAndConfigJava();

    /**
     * 安装并配置docker
     * @return 返回安装docker的执行日志
     */
    String installAndConfigDocker();

    /**
     * 安装并配置mysql
     * @return 返回安装mysql的执行日志
     */
    String installAndConfigMysql();

    /**
     * 安装并配置nginx
     * @return 返回nginx安装日志
     */
    String installAndConfigNginx();

    /**
     * 安装并配置caddy
     * @return 返回caddy安装日志
     */
    String installAndConfigCaddy();
}
