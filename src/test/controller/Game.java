package test.controller;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(750, 750));

        // output for topPanel
        JPanel topPanel = new JPanel(new GridLayout(1, 1));
        topPanel.add(new JLabel("Hello1"), BorderLayout.CENTER);

        // output for boardLayout
        JPanel boardLayout = new JPanel(new GridLayout(20, 25));
        for (int i = 1; i <= 20; i++){
            for (int j = 1; j <= 25; j++) {
                JLabel block = new JLabel();
                block.setName(String.valueOf(i).concat(String.valueOf(j)));
                block.setBackground(Color.pink);
                block.setText(String.valueOf(block.getName()));
                block.setBorder(BorderFactory.createLineBorder(Color.white, 1));
                block.setOpaque(true);
                boardLayout.add(block);
            }
        }

        // set layout
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(boardLayout, BorderLayout.CENTER);

        frame.setVisible(true);

    }
}