package com.kardibus.spring.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfigExample {
    @Bean
    public String str1(){
        return "string1";
    }
    @Bean
    public String str2(){
        return "string2";
    }
    @Bean
    public String str3(){
        return "string3";
    }
}
