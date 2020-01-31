package xyz.guqing.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.Yaml;
import xyz.guqing.app.service.EnvironmentStrategy;
import xyz.guqing.app.service.strategy.environment.EnvironmentStrategyHolder;
import xyz.guqing.app.utils.PlaceholderResolver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HaloPanelApplicationTests {

    @Autowired
    private EnvironmentStrategyHolder environmentStrategyHolder;

    @Test
    void contextLoads() {
        EnvironmentStrategy centos = environmentStrategyHolder.getBy("centos");
        System.out.println(centos);
    }
}
