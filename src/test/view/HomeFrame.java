package test.view;


import test.model.model;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JPanel {

    public HomeFrame() {

        model model = new model();

        JFrame frame = new JFrame("Single Player Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocation(500, 200);


        frame.setLayout(new BorderLayout());
        frame.setResizable(false);


        // top panel

        frame.add(TopPanel());
        frame.setVisible(true);

        Scrollbar scrollbar = new Scrollbar();
        scrollbar.getAccessibleContext();
        add(scrollbar);

        Tile(model);

    }

    public JLabel TopPanel() {
        setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel jLabel = new JLabel("This is the game board ");
        return jLabel;
    }

    public void Tile(model model) {

        setPreferredSize(new Dimension(model.getSquareSize(), model.getSquareSize()));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}

