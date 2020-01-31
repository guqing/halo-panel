package xyz.guqing.app.model.entity;

import lombok.Data;

/**
 * @author guqing
 * @date 2020-01-31 16:48
 */
@Data
public class Environment {
    private String systemType = "centos";
    private String databaseType = "h2";
    private String proxyTool = "caddy";
}
