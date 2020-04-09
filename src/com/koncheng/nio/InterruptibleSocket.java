package com.koncheng.nio;


import javax.swing.*;
import java.awt.*;

public class InterruptibleSocket {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setTitle("Interruptible Socket");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
