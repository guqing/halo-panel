package xyz.guqing.app.service.impl;

import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.guqing.app.model.entity.ApplicationConfig;
import xyz.guqing.app.model.support.DataBaseType;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
class TemplateServiceImplTest {

    @Autowired
    private TemplateServiceImpl templateService;

    @Test
    void renderApplication() throws Exception {
        ApplicationConfig config = new ApplicationConfig();
        config.setPort(9000);
        config.setType(DataBaseType.H2);
        config.setUsername("admin");
        config.setPassword("admin");
        String application = templateService.renderApplication(config);
        System.out.println(application);
    }

    @Test
    void renderSystemd() throws IOException, TemplateException {
        System.out.println(templateService.renderSystemd());
    }

    @Test
    void renderNginxConf() throws IOException, TemplateException {
        String nginxConf = templateService.renderNginxConf("ryanc.cc", 9000);
        System.out.println(nginxConf);
    }

    @Test
    void renderCaddyfile() throws IOException, TemplateException {
        String caddyfile = templateService.renderCaddyfile("ryanc.cc", "i@ryanc.cc", 9000);
        System.out.println(caddyfile);
    }

    @Test
    void renderDockerCompose() throws IOException, TemplateException {
        String dockerCompose = templateService.renderDockerCompose("ryanc.cc", "i@ryanc.cc");
        System.out.println(dockerCompose);
    }
}