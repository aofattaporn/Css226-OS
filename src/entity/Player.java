package entity;

import robot.GamePanel;
import robot.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();

    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        direction = "up";

        speed = 4;

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/download.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }

    }

    public void draw(Graphics2D graphics2D) {

//        graphics2D.setColor(Color.white);
//        graphics2D.fillRect(x, y, gp.titleSize, gp.titleSize);

        BufferedImage image = null;

        switch (direction){
            case "up":
                image = up1;
                break;
            case "down" :
                image = up1;
                break;
            case "left" :
                image = up1;
                break;
            case "right" :
                image = up1;
                break;

        }

        graphics2D.drawImage(image, x, y, gp.titleSize, gp.titleSize, null);

    }

}
