package com.kardibus.spring.util;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
@Component
@ProFiling
public class AnnotationExampleTest {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

   public AnnotationExampleTest(){
       System.out.println("Phase 1");
    }

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println(repeat);
    }
    public void say(){
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
