package com.kardibus.spring.component;

import com.kardibus.spring.service.stax.StaxXML;
import com.kardibus.spring.service.stax.StaxXMLStreamWRImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Configuration
public class StaxXMLComponent {

    @Value("${pathFile}")
    private String path;

    @Bean
    public StaxXML staxXML(XMLStreamWriter xmlStreamWriter) {
        return new StaxXMLStreamWRImpl(xmlStreamWriter);
    }

    @Bean
    public XMLOutputFactory xmlOutputFactory() {
        return XMLOutputFactory.newInstance();
    }

    @Bean
    public FileOutputStream fileOutputStream() {
        try {
            return new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public XMLStreamWriter xmlStreamWriter(XMLOutputFactory xmlOutputFactory, FileOutputStream fileOutputStream) {
        try {
            return xmlOutputFactory.createXMLStreamWriter(fileOutputStream, "UTF-8");
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return null;
    }
}
