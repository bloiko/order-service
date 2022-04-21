package com.third.app;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class LoggerReceiver {

    @JmsListener(destination = "logger")
    public void receiveOrderMessage(String message) throws IOException {
        System.out.println("Order was taken into handling: " + message);

        // In order to append text to a file, you need to open
        // file into append mode, you do it by using
        // FileReader and passing append = true
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("src/main/resources/out.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);

            pw.println(message);

            pw.flush();

        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything }
            }

        }

    }
}
