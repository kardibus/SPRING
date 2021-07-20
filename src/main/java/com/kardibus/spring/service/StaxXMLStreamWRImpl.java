package com.kardibus.spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

@Component
@AllArgsConstructor
public class StaxXMLStreamWRImpl implements StaxXML {

    private XMLStreamWriter xmlStreamWriter;

    @Override
    public void writeXML() {
        String rootElement = "Employee";
        //start writing xml file
        try {
            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeStartElement(rootElement);

            //write other elements
            xmlStreamWriter.writeCharacters("\n\t");
            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters( "Kardibus");

            xmlStreamWriter.writeEndElement();
            //write end document
            xmlStreamWriter.writeCharacters("\n");
            xmlStreamWriter.writeEndDocument();

            //flush data to file and close writer
            xmlStreamWriter.flush();
            xmlStreamWriter.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
