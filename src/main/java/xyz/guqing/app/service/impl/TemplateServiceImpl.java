package xyz.guqing.app.service.impl;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import xyz.guqing.app.model.entity.ApplicationConfig;
import xyz.guqing.app.service.TemplateService;

import java.io.IOException;

/**
 * @author ryanwang
 * @date 2020-01-31
 */
@Service
public class TemplateServiceImpl implements TemplateService {

    private final FreeMarkerConfigurer freeMarker;

    public TemplateServiceImpl(FreeMarkerConfigurer freeMarker) {
        this.freeMarker = freeMarker;
    }

    @Override
    public String renderApplication(ApplicationConfig config) throws IOException, TemplateException {
        Template template = freeMarker.getConfiguration().getTemplate("application-template.ftl");
        ModelMap model = new ModelMap();
        model.addAttribute("config", config);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }

    @Override
    public String renderSystemd() throws IOException, TemplateException {
        Template template = freeMarker.getConfiguration().getTemplate("halo.service.ftl");
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, new ModelMap());
    }

    @Override
    public String renderNginxConf(String serverName, Integer port) throws IOException, TemplateException {
        Template template = freeMarker.getConfiguration().getTemplate("nginx.conf.ftl");
        ModelMap model = new ModelMap();
        model.addAttribute("serverName", serverName);
        model.addAttribute("port", port);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }

    @Override
    public String renderCaddyfile(String domain, String email, Integer port) throws IOException, TemplateException {
        Template template = freeMarker.getConfiguration().getTemplate("Caddyfile.ftl");
        ModelMap model = new ModelMap();
        model.addAttribute("domain", domain);
        model.addAttribute("email", email);
        model.addAttribute("port", port);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }

    @Override
    public String renderDockerCompose(String host, String email) throws IOException, TemplateException {
        Template template = freeMarker.getConfiguration().getTemplate("docker-compose.ftl");
        ModelMap model = new ModelMap();
        model.addAttribute("host", host);
        model.addAttribute("email", email);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
    }
}
