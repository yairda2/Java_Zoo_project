package food;

import graphics.ZooFrame;
import graphics.ZooPanel;
import plants.Plant;

public class Meat extends Plant {
    private static Meat single_instance = null;

    public Meat(ZooPanel zoopanel) {
        super(zoopanel);
    }

    public static Meat getInstance(ZooPanel zoopanel)
    {
        if (single_instance == null)
            single_instance = new Meat(zoopanel);

        return single_instance;
    }
}
