package main;

import com.sun.source.tree.BreakTree;

import java.awt.*;

public class EventHandler {
    GamePanel gp;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    public EventHandler(GamePanel gp){
        this.gp = gp;
        eventRect = new Rectangle();
        eventRect.x = 23; // in the middle of the tile
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }
    public void checkEvent(){
        if(hit(24,16,"right")){
            //event happens
            damagePit(gp.playState);
        }
        if(hit(23,12,"any")){
            healingPool(gp.playState);
        }
    }
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;

        //update the position of player's rectangle
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;
        eventRect.x = eventCol*gp.tileSize + eventRect.x;
        eventRect.y = eventRow*gp.tileSize + eventRect.y;

        if(gp.player.solidArea.intersects(eventRect)){
            if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
            }
        }

        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }
    public void damagePit(int gameState){
        gp.gameState = gameState;
        gp.player.life -= 1;
    }
    public void healingPool(int gameState){
        System.out.println("healing...");
        if(gp.keyH.enterPressed){
            gp.gameState = gameState;
            gp.player.life+=1;
        }
    }
}
