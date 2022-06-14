package animals;
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
import graphics.ZooPanel;
import mobility.Point;
/*
 * chew class
 * extends from animal class
 */
public abstract class Chew extends Animal {


    /*
     * chew consturctor
     */

    public Chew(String name, Point Location,String color,ZooPanel panel) {
        super(name, Location,color,panel);
    }
    /*
     * make sound method
     * @see chew
     */
    public void makeSound() {
        this.chew();
    }

    public abstract void chew();

}