package xyz.guqing.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.guqing.app.service.EnvironmentStrategy;
import xyz.guqing.app.service.strategy.environment.EnvironmentStrategyHolder;

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
