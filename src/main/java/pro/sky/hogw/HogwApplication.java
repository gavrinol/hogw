package pro.sky.hogw;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition

public class HogwApplication {

    public static void main(String[] args) {
        SpringApplication.run(HogwApplication.class, args);
    }

}
