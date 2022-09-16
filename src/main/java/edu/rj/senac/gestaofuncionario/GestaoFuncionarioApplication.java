package edu.rj.senac.gestaofuncionario;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestaoFuncionarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestaoFuncionarioApplication.class, args);
    }

    @Bean
    public OpenAPI openApiConfig() {
        return new OpenAPI().info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Gestão de funcionários")
                .description("Sistema que gere o cadastro de funcionários")
                .version("1.0.0");
    }
}
