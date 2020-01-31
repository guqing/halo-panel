package xyz.guqing.app.service;

import com.jcraft.jsch.Session;

/**
 * @author guqing
 * @date 2020-01-31 15:04
 */
public interface EnvironmentStrategy {
    /**
     * 安装并配置java环境
     *
     * @return 返回执行日志
     */
    String installAndConfigJava(Session session);

    /**
     * 安装并配置docker
     *
     * @return 返回安装docker的执行日志
     */
    String installAndConfigDocker(Session session);

    /**
     * 安装并配置mysql
     *
     * @return 返回安装mysql的执行日志
     */
    String installAndConfigMysql(Session session);

    /**
     * 安装并配置nginx
     *
     * @return 返回nginx安装日志
     */
    String installAndConfigNginx(Session session);

    /**
     * 安装并配置caddy
     *
     * @return 返回caddy安装日志
     */
    String installAndConfigCaddy(Session session);
}
