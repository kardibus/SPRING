package com.kardibus.spring.service;

import com.kardibus.spring.domain.User;
import com.kardibus.spring.repository.UserRepository;
import com.kardibus.spring.service.stax.StaxXMLStreamWRImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@Transactional
public class StreamWrite {

    private UserRepository userRepository;
    private StaxXMLStreamWRImpl staxXMLStreamWR;

    public void write() {
        Stream<User> userStream = userRepository.streamAll();
        staxXMLStreamWR.writeXML(userStream);
    }
}
