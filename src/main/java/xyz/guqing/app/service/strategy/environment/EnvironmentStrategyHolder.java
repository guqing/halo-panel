package xyz.guqing.app.service.strategy.environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.guqing.app.model.property.EnvironmentAlias;
import xyz.guqing.app.service.EnvironmentStrategy;

import java.util.Map;

/**
 * @author guqing
 * @date 2020-01-31 15:55
 */
@Component
public class EnvironmentStrategyHolder {

    private final EnvironmentAlias environmentAlias;
    /**
     * Spring 会自动将 EnvironmentStrategy 接口的类注入到这个Map中
     */
    private final Map<String, EnvironmentStrategy> envStrategyMap;

    @Autowired
    public EnvironmentStrategyHolder(EnvironmentAlias environmentAlias, Map<String, EnvironmentStrategy> envStrategyMap) {
        this.environmentAlias = environmentAlias;
        this.envStrategyMap = envStrategyMap;
    }

    /**
     * 找不到对应的策略类，使用默认的
     */
    public EnvironmentStrategy getBy(String envName) {
        String name = environmentAlias.of(envName);
        if (name == null) {
            return envStrategyMap.get(EnvironmentAlias.DEFAULT_STRATEGY_NAME);
        }
        EnvironmentStrategy entStrategy = envStrategyMap.get(name);
        if (entStrategy == null) {
            return envStrategyMap.get(EnvironmentAlias.DEFAULT_STRATEGY_NAME);
        }
        return entStrategy;
    }
}
