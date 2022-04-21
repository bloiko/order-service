package com.second.app;

import com.order.pojos.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHandler {
    private static final Integer TOTAL_ORDER_LIMIT = 100;

    private static final Integer LIQUID_VOLUME_LIMIT = 20;

    @Autowired
    private LoggerService loggerService;

    public void handle(Order order) {
        String message = String.format("Order was received and handled: %s", order);

        if (isLiquid(order) && Integer.parseInt(order.getItem().getVolumeOrNumber()) > LIQUID_VOLUME_LIMIT) {
            message = String.format("Liquid volume greater than %s – the order is rejected; %s", LIQUID_VOLUME_LIMIT, order);
            loggerService.send(message);
            throw new RuntimeException("Liquid volume cannot be greater than " + LIQUID_VOLUME_LIMIT);
        } else if (order.getOrderTotal() > TOTAL_ORDER_LIMIT) {
            message = String.format("Order total greater than %s – the order is rejected; %s", TOTAL_ORDER_LIMIT, order);
            loggerService.send(message);
            throw new RuntimeException("Order total cannot be greater than " + TOTAL_ORDER_LIMIT);
        } else {
            loggerService.send(message);
        }
    }

    public boolean isLiquid(Order order) {
        return order.getItem().getType().equals("LIQUIDS");
    }

}
