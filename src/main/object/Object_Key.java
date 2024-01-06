package main.object;
import entity.Entity;
import main.GamePanel;

public class Object_Key extends Entity {
    public Object_Key(GamePanel gp){
        super(gp);
        type = type_consumable;
        name = "Key";
        down1 = setup("/objects/key",gp.tileSize,gp.tileSize);
    }
}
