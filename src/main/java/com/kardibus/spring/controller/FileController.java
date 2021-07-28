package com.kardibus.spring.controller;

import com.kardibus.spring.component.ExampleTestConfig;
import com.kardibus.spring.component.FileComponent;
import com.kardibus.spring.service.SrviceExampleForTestConfig;
import com.kardibus.spring.service.StreamWrite;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FileController {

    private SrviceExampleForTestConfig srv;
    private FileComponent fileComponent;
    private StreamWrite streamWrite;

    @GetMapping("/create")
    public String getCreate() {
        fileComponent.getFileWR().createFile();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }

    @GetMapping("/delete")
    public List<String> getDelete() {

        fileComponent.getFileWR().deleteFile();
        return srv.getList();
    }

    @GetMapping("/write")
    public String getWriteXML() {
        streamWrite.write();
        return fileComponent.getFileWR().isCreateFile() == true ? "true" : "false";
    }
}
