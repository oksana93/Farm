package farm.dairy.cow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
@ConfigurationProperties("application.properties")
public class FarmApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmApplication.class, args);
    }
}
