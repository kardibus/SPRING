package com.kardibus.spring.component;

import com.kardibus.spring.service.FileWR;
import com.kardibus.spring.service.FileWriteRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileComponent {

    @Bean
    public FileWR getFileWR() {
        return new FileWriteRecord();
    }
}
