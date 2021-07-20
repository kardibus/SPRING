package com.kardibus.spring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class FileWriteRecordImpl implements FileWR {


    @Value("${pathFile}")
    private String path;


    public boolean isCreateFile() {
        return Files.exists(Paths.get(path));
    }

    public boolean createFile() {
        File file = new File(path);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteFile() {
        try {
            return Files.deleteIfExists(Path.of(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
