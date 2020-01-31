package xyz.guqing.app.model.vo;

import lombok.Data;
import xyz.guqing.app.model.entity.AuthInfo;
import xyz.guqing.app.model.entity.Environment;
import xyz.guqing.app.model.entity.HaloDataBase;

/**
 * @author guqing
 * @date 2020-01-31 16:38
 */
@Data
public class InstallVo {
    private AuthInfo authInfo;
    private HaloDataBase haloDataBase;
    private Environment environment;
}
