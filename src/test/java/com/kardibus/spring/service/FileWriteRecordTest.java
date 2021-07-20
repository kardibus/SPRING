package com.kardibus.spring.service;

import com.kardibus.spring.component.FileComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileWriteRecordTest {

    @Autowired
    private FileComponent fileComponent;

    @Test
    public void isCreatedFile() {
        assertFalse(fileComponent.getFileWR().isCreateFile());
    }

    @Test
    public void createFile(){
        assertTrue(fileComponent.getFileWR().createFile());
    }

    @Test
    public void deleteFile(){
        assertTrue(fileComponent.getFileWR().deleteFile());
    }
}
