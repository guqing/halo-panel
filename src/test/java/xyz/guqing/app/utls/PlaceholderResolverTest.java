package xyz.guqing.app.utls;

import org.junit.jupiter.api.Test;
import xyz.guqing.app.utils.PlaceholderResolver;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guqing
 * @date 2020-01-31 17:54
 */
public class PlaceholderResolverTest {
    @Test
    public void testResolverByMap() {
        String content = "server:\n" +
                "  port: 8090\n" +
                "spring:\n" +
                "  datasource:\n" +
                "    type: com.zaxxer.hikari.HikariDataSource\n" +
                "\n" +
                "    # H2 Database 配置\n" +
                "    driver-class-name: org.h2.Driver\n" +
                "    url: jdbc:h2:file:~/.halo/db/halo\n" +
                "    username: ${username}\n" +
                "    password: ${password}\n" +
                "  h2:\n" +
                "    console:\n" +
                "      settings:\n" +
                "        web-allow-others: false\n" +
                "      path: /h2-console\n" +
                "      enabled: false";

        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "12345567889");
        PlaceholderResolver placeholderResolver = PlaceholderResolver.getDefaultResolver();
        String resolveResult = placeholderResolver.resolveByMap(content, map);
        System.out.println(resolveResult);
    }

    @Test
    public void testResolveFromFile() throws IOException {
        StringBuilder sb = new StringBuilder();

        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("static/applicationTemplate.yaml");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while((bytesRead = bufferedInputStream.read(buffer)) != -1){

            String s = new String(buffer, 0, bytesRead);
            sb.append(s);
        }
        System.out.println("原始字符串: " + sb.toString());
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "12345567889");
        PlaceholderResolver placeholderResolver = PlaceholderResolver.getDefaultResolver();
        String resolveResult = placeholderResolver.resolveByMap(sb.toString(), map);
        System.out.println("---------------解析后的字符串----------------");
        System.out.println(resolveResult);

        bufferedInputStream.close();
        inputStream.close();
    }
}
