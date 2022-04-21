package com.order.orderservice;

import com.order.pojos.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private static final String ORDER_QUEUE = "order";

    @Autowired
    @Qualifier("jmsTemplateCustom")
    private JmsTemplate jmsTemplate;

    @Transactional
    public void send(Order order){
        jmsTemplate.convertAndSend(ORDER_QUEUE, order,
                messagePostProcessor -> {
                    messagePostProcessor.setStringProperty("type",
                            order.getItem().getType());
                    return messagePostProcessor;
                });
    }
}
