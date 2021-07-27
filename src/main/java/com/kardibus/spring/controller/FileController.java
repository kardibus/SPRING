package com.kardibus.spring.controller;

import com.kardibus.spring.component.ExampleTestConfig;
import com.kardibus.spring.component.FileComponent;
import com.kardibus.spring.service.StreamWrite;
import com.kardibus.spring.util.AnnotationExampleTest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FileController {

    private FileComponent fileComponent;
    private StreamWrite streamWrite;
    private ExampleTestConfig exampleTestConfig;

    @GetMapping("/create")
    public String getCreate() {
        fileComponent.getFileWR().createFile();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }

    @GetMapping("/delete")
    public String getDelete() {
        exampleTestConfig.test().setMessage("Method delete in controller");
        exampleTestConfig.test().say();
        fileComponent.getFileWR().deleteFile();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }

    @GetMapping("/write")
    public String getWriteXML() {
        streamWrite.write();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }
}
