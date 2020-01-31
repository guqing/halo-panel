package xyz.guqing.app.model.support;

/**
 * @author guqing
 * @date 2020-01-31 14:54
 */
public enum DataBaseType {
    /**
     * h2数据库
     */
    H2("h2"),

    /**
     * mysql数据库
     */
    MYSQL("mysql");

    private String name;

    DataBaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
