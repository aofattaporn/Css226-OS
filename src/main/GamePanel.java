package main;

import entity.Player;
import tile.Tile;
import tile.TileManangger;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    // screen setting -> tile size by 1 box
    final int originalTitleSize = 16;
    final int scale = 2;

    public final int titleSize = originalTitleSize * scale; // 48 px
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 16;
    public final int screenWidth = titleSize * maxScreenRow;  // 760 px
    public final int screenHeight = titleSize * maxScreenCol; // 576 px

    // WORLD SETTING
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = titleSize * maxWorldCol;
    public final int worldHeight = titleSize * maxWorldRow;

    //FPS
    public int FPS = 60;

    // declare object
    public TileManangger tileManangger = new TileManangger(this);
    public KeyHandler keyHandler = new KeyHandler();
    public Player player = new Player(this, keyHandler);
    public Thread gameThread;

    public int playerX = 100;
    public int playerY = 100;
    public int playerSpeed = 4;

    // constructor method
    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);

    }

    // command start to game
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run(){

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        //  setTimer of Thread
        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000){
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }

    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        tileManangger.draw(graphics2D);
        player.draw(graphics2D);


        graphics2D.dispose();
    }

}
