package animals;
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
import graphics.ZooPanel;
import mobility.Point;
/*
 * roar class
 * extends from animal class
 */
public abstract class Roar extends Animal {
    /*
     * roar consturctor
     * @params:name(animal),Point location
     */

    public Roar(String name,Point location,String color,ZooPanel panel) {
        super(name,location,color,panel);
    }

    public abstract void roar();
    /*
     * make sound method
     * @see chew
     */
    public void makeSound() {
        this.roar();
    }

}