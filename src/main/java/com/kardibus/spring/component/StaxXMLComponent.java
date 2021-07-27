package com.kardibus.spring.component;

import com.kardibus.spring.service.stax.StaxXML;
import com.kardibus.spring.service.stax.StaxXMLStreamWRImpl;
import lombok.SneakyThrows;
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

    @SneakyThrows
    @Bean
    public StaxXML staxXML(XMLStreamWriter xmlStreamWriter) {
        return new StaxXMLStreamWRImpl(xmlStreamWriter);
    }

    @Bean
    public XMLOutputFactory xmlOutputFactory() {
        return XMLOutputFactory.newInstance();
    }

    @Bean
    public FileOutputStream fileOutputStream() throws FileNotFoundException {
            return new FileOutputStream(path);
    }

    @Bean
    public XMLStreamWriter xmlStreamWriter(XMLOutputFactory xmlOutputFactory, FileOutputStream fileOutputStream) throws XMLStreamException {
            return xmlOutputFactory.createXMLStreamWriter(fileOutputStream, "UTF-8");
    }
}
