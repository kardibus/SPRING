package com.kardibus.spring.service.stax;

import com.kardibus.spring.domain.User;

import java.util.stream.Stream;

public interface StaxXML {
    void writeXML(Stream<User> users);
}
