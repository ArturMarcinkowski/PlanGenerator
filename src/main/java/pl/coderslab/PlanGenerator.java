package pl.coderslab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan({"com.pl.coderslab.controller"})
public class PlanGenerator {

    public static void main(String[] args) {
        SpringApplication.run(PlanGenerator.class, args);
    }

}
