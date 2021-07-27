package com.kardibus.spring.service.stax;

import com.kardibus.spring.component.StaxXMLComponent;
import com.kardibus.spring.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class StaxXMLStreamWRImpl implements StaxXML {

    private XMLStreamWriter xmlStreamWriter;

    @Override
    public void writeXML(Stream<User> users) {

        try {
            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement(User.class.getName());

            users.forEach(user -> {
                try {
                    xmlStreamWriter.writeCharacters("\n\t");
                    xmlStreamWriter.writeStartElement("name");
                    xmlStreamWriter.writeCharacters(user.getName());

                    xmlStreamWriter.writeEndElement();

                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            });
            //write end document
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeEndDocument();
            //flush data to file and close writer
            xmlStreamWriter.flush();
         //  xmlStreamWriter.close();

        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
