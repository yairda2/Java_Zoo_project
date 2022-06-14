
package plants;
import graphics.ZooFrame;
import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
public class Cabbage extends Plant {
    static  private  volatile Cabbage single_instance = null;

    private Cabbage(ZooPanel zoopanel) {

        super(zoopanel);
        MessageUtility.logConstractor("Cabbage", "Cabbage");
    }

    public static Cabbage getInstance(ZooPanel zoopanel,ZooFrame OB)
    { if (single_instance == null)
        synchronized(Cabbage.class){
            if (single_instance == null)
                single_instance = new  Cabbage(ZooPanel.getInstance(OB));
        }
        return single_instance;
    }

}