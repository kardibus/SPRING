package com.kardibus.spring.util;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AnnotationExampleTest {
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;
    private String message;

    public void say(){
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }
}
