package com.kardibus.spring;

import com.kardibus.spring.component.ExampleTestConfig;
import com.kardibus.spring.util.AnnotationExampleTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext cfx = new AnnotationConfigApplicationContext();
        cfx.register(ExampleTestConfig.class);
        cfx.refresh();
        AnnotationExampleTest annotationExampleTest = cfx.getBean(AnnotationExampleTest.class);
        annotationExampleTest.setMessage("starting my app");
        annotationExampleTest.say();
    }
}
