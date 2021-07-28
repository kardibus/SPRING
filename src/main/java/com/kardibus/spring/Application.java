package com.kardibus.spring;

import com.kardibus.spring.component.ExampleTestConfig;
import com.kardibus.spring.util.AnnotationExampleTest;
import com.kardibus.spring.util.ProfilerController;
import com.kardibus.spring.util.ProfilingControllerMXBean;
import com.kardibus.spring.util.ProfilingHandlerBeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);

        AnnotationConfigApplicationContext cfx = new AnnotationConfigApplicationContext();
        cfx.register(ExampleTestConfig.class);
       // cfx.register(ProfilingHandlerBeanPostProcessor.class);
        cfx.refresh();
        AnnotationExampleTest annotationExampleTest = cfx.getBean(AnnotationExampleTest.class);
        annotationExampleTest.setMessage("starting my app");

        while (true){
            Thread.sleep(1000);
            annotationExampleTest.say();
        }
    }
}
