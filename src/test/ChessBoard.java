package test;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame();



        Color blackColor = Color.LIGHT_GRAY;

        JLabel text = new JLabel("Hello world");
        text.setBackground(Color.PINK);
        text.setBounds(10, 10, 700, 100);
        text.setOpaque(true);
        frame.add(text);


        JLabel block = null;

        JPanel gridLayout = new JPanel(new GridLayout(25, 20));
        gridLayout.setBounds(10, 700, 700 , 100);
        frame.add(gridLayout);



        for (int i = 1; i <= 500; i++) {

            block = new JLabel();
            block.setBackground(blackColor);
            block.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            block.setOpaque(true);
            gridLayout.add(block);

        }

        frame.setSize(700, 700); // Size of the chess board
        frame.setVisible(true);




    }
}