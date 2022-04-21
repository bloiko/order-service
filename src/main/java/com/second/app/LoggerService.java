package com.second.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoggerService {
    private static final String LOGGER_QUEUE = "logger";

    @Autowired
    @Qualifier("jmsTemplateCustom")
    private JmsTemplate jmsTemplate;

    @Transactional
    public void send(String message){
        jmsTemplate.convertAndSend(LOGGER_QUEUE, message);
    }
}
