package com.kardibus.spring.controller;

import com.kardibus.spring.component.FileComponent;
import com.kardibus.spring.component.StaxXMLComponent;
import com.kardibus.spring.service.StaxXMLStreamWRImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FileController {

    private FileComponent fileComponent;
    private StaxXMLStreamWRImpl staxXMLStreamWR;

    @GetMapping("/create")
    public String getCreate() {
        fileComponent.getFileWR().createFile();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }

    @GetMapping("/delete")
    public String getDelete() {
        fileComponent.getFileWR().deleteFile();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }

    @GetMapping("/write")
    public String getWriteXML() {
        staxXMLStreamWR.writeXML();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }
}
