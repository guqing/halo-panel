package xyz.guqing.app.controller;

import cn.hutool.extra.ssh.JschUtil;
import com.jcraft.jsch.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyz.guqing.app.model.entity.AuthInfo;

import java.nio.charset.StandardCharsets;

/**
 * @author guqing
 * @date 2020-01-31 13:57
 */
@Controller
@RequestMapping("/config")
public class ConfigController {

    @PostMapping("/install")
    public ModelAndView install(AuthInfo userInfo) {
        //新建会话
        Session session = JschUtil.getSession(userInfo.getIp(), 22, userInfo.getUsername(), userInfo.getPassword());
        String result = JschUtil.exec(session, installJava(), StandardCharsets.UTF_8);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("log", result);
        System.out.println(result);
        return modelAndView;
    }

    private String installJava() {
        return "yum install java -y";
    }
}
