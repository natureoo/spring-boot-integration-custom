package demo.chenj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * @author chenj
 * @date 2019-10-20 14:44
 * @email 924943578@qq.com
 */

@SpringBootApplication
@ImportResource(locations = {"classpath:int-custom-config.xml"})
public class SpringbootIntApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootIntApplication.class, args);
    }

}
