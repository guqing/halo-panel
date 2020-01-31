package xyz.guqing.app.model.entity;

import lombok.Data;

/**
 * @author guqing
 * @date 2020-01-31 14:00
 */
@Data
public class AuthInfo {
    private String ip;
    private String username;
    private String password;
}
