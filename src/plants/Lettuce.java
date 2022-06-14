package plants;

import food.Meat;
import graphics.ZooFrame;
import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
public class Lettuce extends Plant {
    static  private  volatile Lettuce single_instance = null;

    private Lettuce(ZooPanel zoopanel) {
        super(zoopanel);
        MessageUtility.logConstractor("Lettuce", "Lettuce");
    }
    public static Lettuce getInstance(ZooPanel zoopanel,ZooFrame OB)
    {
        if (single_instance == null)
            synchronized(Lettuce.class){
                if (single_instance == null)
                    single_instance = new  Lettuce(ZooPanel.getInstance(OB));
            }
        return single_instance;
    }
}