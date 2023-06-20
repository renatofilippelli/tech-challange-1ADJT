package filippelli.renato.techchallange1adjt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Swagger OpenApi", version = "1", description = "TechChallange-1ADJT"))
public class TechChallange1AdjtApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechChallange1AdjtApplication.class, args);
    }

}
