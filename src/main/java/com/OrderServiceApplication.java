package com;

import com.order.orderservice.OrderService;
import com.order.pojos.Item;
import com.order.pojos.Order;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class OrderServiceApplication {
    public static final String LIQUIDS = "LIQUIDS";
    public static final String COUNTABLE_ITEM = "COUNTABLE_ITEM";


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(OrderServiceApplication.class, args);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Write your username:");
            String username = reader.readLine();
            System.out.println("What do you want to buy? (choose a number)");
            System.out.println("1. " + LIQUIDS);
            System.out.println("2. " + COUNTABLE_ITEM);

            String option = reader.readLine();
            String choosedElement = null;
            String volumeOrNumber = null;
            if (option.equals("1")) {
                choosedElement = LIQUIDS;
                System.out.println("Write the volume of order for liquids:");
                volumeOrNumber = reader.readLine();
            } else if (option.equals("2")) {
                choosedElement = COUNTABLE_ITEM;
                System.out.println("Write the number of items for countable items:");
                volumeOrNumber = reader.readLine();
            }
            System.out.println("Write total order:");
            Integer totalOrder = Integer.parseInt(reader.readLine());
            OrderService orderService = context.getBean(OrderService.class);
            orderService.send(new Order(username, new Item(choosedElement, volumeOrNumber), totalOrder));
        }
    }
}
