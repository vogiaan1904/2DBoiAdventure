package main.object;

import entity.Entity;
import main.GamePanel;

public class Object_Potion_Red  extends Entity {
    GamePanel gp;
    int value = 5;
    public Object_Potion_Red(GamePanel gp) {
        super(gp);
        this.gp = gp;
        type = type_fireBall;
        name = "Red Potion";
        down1 = setup("/objects/potion_red",gp.tileSize,gp.tileSize);
    }
    public void use(Entity entity){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the = " + name + "! \n";
    }
}
