package com.kardibus.spring.component;

import com.kardibus.spring.util.AnnotationExampleTest;
import com.kardibus.spring.util.InjectRandomIntAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleTestConfig {

    @Bean
    public AnnotationExampleTest test(){
      return new AnnotationExampleTest();
    }

    @Bean
    public InjectRandomIntAnnotationBeanPostProcessor test2(){
        return new InjectRandomIntAnnotationBeanPostProcessor();
    }
}
