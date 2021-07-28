package com.kardibus.spring.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class SrviceExampleForTestConfig {
    @Autowired
    private List<String> list;
}
