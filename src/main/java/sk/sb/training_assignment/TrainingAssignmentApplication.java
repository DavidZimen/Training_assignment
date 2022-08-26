package sk.sb.training_assignment;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingAssignmentApplication {

    public static void main(String[] args) {
        org.springframework.context.ApplicationContext context = (org.springframework.context.ApplicationContext) SpringApplication.run(TrainingAssignmentApplication.class, args);

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }
    }

}
