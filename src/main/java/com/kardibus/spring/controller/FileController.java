package com.kardibus.spring.controller;

import com.kardibus.spring.component.FileComponent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FileController {

    private FileComponent fileComponent;

    @GetMapping("/create")
    public String getCreate() {
        fileComponent.getFileWR().createFile();
        return fileComponent.getFileWR().isCreateFile()==true?"true":"false";
    }

    @GetMapping("/delete")
    public String getDelete() {
        fileComponent.getFileWR().deleteFile();
        return fileComponent.getFileWR().isCreateFile()==true?"true":"false";
    }
}
