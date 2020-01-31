package xyz.guqing.app.service;

import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.guqing.app.model.entity.Environment;
import xyz.guqing.app.model.vo.InstallVo;
import xyz.guqing.app.service.strategy.environment.EnvironmentStrategyHolder;

import java.util.Objects;

/**
 * @author guqing
 * @date 2020-01-31 16:35
 */
@Service
public class ConfigService {
    private final EnvironmentStrategyHolder environmentStrategyHolder;

    @Autowired
    public ConfigService(EnvironmentStrategyHolder environmentStrategyHolder) {
        this.environmentStrategyHolder = environmentStrategyHolder;
    }

    public String install(Session session, InstallVo installVo) {
        Environment environment = installVo.getEnvironment();
        EnvironmentStrategy holder = environmentStrategyHolder.getBy(environment.getSystemType());
        String java = holder.installAndConfigJava(session);

        if (Objects.equals("nginx", environment.getProxyTool())) {
            String nginx = holder.installAndConfigNginx(session);
        }

        if (Objects.equals("caddy", environment.getProxyTool())) {
            String caddy = holder.installAndConfigCaddy(session);
        }

        return java;
    }
}
