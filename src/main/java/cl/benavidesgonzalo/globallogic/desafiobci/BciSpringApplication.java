package cl.benavidesgonzalo.globallogic.desafiobci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class BciSpringApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BciSpringApplication.class, args);
    }
}