package xyz.guqing.app.model.entity;

import lombok.Data;
import xyz.guqing.app.model.support.DataBaseType;

/**
 * @author guqing
 * @date 2020-01-31 14:52
 */
@Data
public class HaloDataBase {
    private String username;
    private String password;
    private DataBaseType type = DataBaseType.H2;
}
