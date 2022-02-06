package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

//    constructor
    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.titleSize / 2 ) ;
        screenY = gp.screenHeight / 2 - (gp.titleSize / 2 );

        setDefaultValues();
        getPlayerImage();

    }

//    setDefaulttValues
    public void setDefaultValues() {

//        center in the map
         worldX =  gp.titleSize * 23;
        worldY = gp.titleSize * 21;

        direction = "up";
        speed = 4;

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/up2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/down1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/down2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/left2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/rigth1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("../res/player/rigth2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {

            if (keyH.upPressed) {
                direction = "up";
                worldY -= speed;
            } else if (keyH.downPressed) {
                direction = "down";
                worldY += speed;
            } else if (keyH.leftPressed) {
                direction = "left";
                worldX -= speed;
            } else if (keyH.rightPressed) {
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }

                spriteCounter = 0;
            }
        }
    }

    public void draw(Graphics2D graphics2D) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        // draw character by image
        graphics2D.drawImage(image, screenX, screenY, gp.titleSize, gp.titleSize, null);

    }

}
