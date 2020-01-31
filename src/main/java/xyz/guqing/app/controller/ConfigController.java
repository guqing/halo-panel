package xyz.guqing.app.controller;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.guqing.app.model.entity.AuthInfo;
import xyz.guqing.app.model.vo.InstallVo;
import xyz.guqing.app.service.ConfigService;

/**
 * @author guqing
 * @date 2020-01-31 13:57
 */
@RestController
@CrossOrigin
@RequestMapping("/config")
public class ConfigController {
    private final ConfigService configService;

    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @PostMapping("/install")
    public String install(InstallVo installVo) {
        AuthInfo authInfo = installVo.getAuthInfo();
        //新建会话
        Session session = JschUtil.getSession(authInfo.getIp(), 22, authInfo.getUsername(), authInfo.getPassword());
        String result = configService.install(session, installVo);

        System.out.println(result);
        return result;
    }

    private String installJava() {
        return "yum install java -y";
    }
}
