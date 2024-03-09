package characters;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Characters{
    
    GamePanel gp;
    KeyHandler keyH;
    
    public final int screenX;
    public final int screenY;
    
    public Player(GamePanel gp, KeyHandler keyH){
        
        this.gp = gp;
        this.keyH = keyH;
        
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);
        
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        
        worldX = gp.tileSize * 23;
        worldY=gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        
        try {
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/slime_up1.PNG"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/slime_up2.PNG"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/slime_down1.PNG"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/slime_down2.PNG"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/slime_left1.PNG"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/slime_left2.PNG"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/slime_right1.PNG"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/slime_right2.PNG"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(keyH.upPressed == true || keyH.downPressed == true || 
                keyH.leftPressed == true || keyH.rightPressed == true){
            if(keyH.upPressed ==true){
            direction = "up";
            worldY -= speed;
            }
            else if(keyH.downPressed == true){
                direction = "down";
                worldY += speed;
            }
            else if(keyH.leftPressed == true){
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.rightPressed == true){
                direction = "right";
                worldX += speed;
            }

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        
        
    }
    public void draw(Graphics2D g2){

          
        BufferedImage image = null;
          
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
