package xyz.guqing.app.service;

import xyz.guqing.app.model.entity.ApplicationConfig;

/**
 * @author ryanwang
 * @date 2020-01-31
 */
public interface TemplateService {

    /**
     * Render application.yaml.
     *
     * @param config config
     * @return application.yaml content.
     * @throws Exception throw Exception.
     */
    String renderApplication(ApplicationConfig config) throws Exception;

    /**
     * Render halo.service.
     *
     * @return halo.service content.
     * @throws Exception throw Exception.
     */
    String renderSystemd() throws Exception;

    /**
     * Render nginx.conf.
     *
     * @param serverName server_name
     * @param port       server port
     * @return nginx.conf content
     * @throws Exception throw Exception.
     */
    String renderNginxConf(String serverName, Integer port) throws Exception;

    /**
     * Render Caddyfile content.
     *
     * @param domain domain
     * @param email  email
     * @param port   server port
     * @return Caddyfile content
     * @throws Exception throw Exception.
     */
    String renderCaddyfile(String domain, String email, Integer port) throws Exception;

    /**
     * Render docker-compose.yaml
     *
     * @param host  host
     * @param email email
     * @return docker-compose.yaml content
     * @throws Exception throw Exception.
     */
    String renderDockerCompose(String host, String email) throws Exception;
}
