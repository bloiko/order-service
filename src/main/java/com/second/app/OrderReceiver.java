package com.second.app;

import com.order.pojos.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    @Autowired
    private OrderHandler orderHandler;

//    @JmsListener(destination = "order")
//    public void receiveOrderMessage(Order order) {
//        System.out.println("Order was taken into handling: " + order);
//        orderHandler.handle(order);
//    }

    @JmsListener(destination = "order", selector = "type = 'LIQUIDS'")
    public void receiveLiquidsMessage(Order order) {
        System.out.println("Order with LIQUIDS was taken into handling: " + order);
        orderHandler.handle(order);
    }

    @JmsListener(destination = "order", selector = "type = 'COUNTABLE_ITEM'")
    public void receiveCountableItemMessage(Order order) {
        System.out.println("Order with COUNTABLE_ITEM was taken into handling: " + order);
        orderHandler.handle(order);
    }
}
