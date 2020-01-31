package xyz.guqing.app.model.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author guqing
 * @date 2020-01-31 16:02
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "env.strategy")
public class EnvironmentAlias {
    private HashMap<String, String> aliasMap;

    public static final String DEFAULT_STRATEGY_NAME = "defaultStrategy";

    public HashMap<String, String> getAliasMap() {
        return aliasMap;
    }

    public void setAliasMap(HashMap<String, String > aliasMap) {
        this.aliasMap = aliasMap;
    }

    public String of(String entNum) {
        return aliasMap.get(entNum);
    }
}
