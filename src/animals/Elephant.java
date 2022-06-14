package animals;
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
import diet.Herbivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/*
 * Elephant class(an animal)
 */
public class Elephant extends Chew {

    private static final Point start_location = new Point(50,90);
    private static final Herbivore diet = new Herbivore();
    private double trunkLength;
    private ZooPanel panel;
    /*
     * Elephant constructor
     * @param: name
     */
    public Elephant(String name,float weight,String color,ZooPanel panel) {
        super(name, start_location,color,panel);
        super.setWeight(500);
        super.setDiet(diet);
        this.trunkLength = 1;
        this.loadImages("elf");
        MessageUtility.logConstractor("Elephant", name);

    }
    /*
     * Elephant constructor
     * @params: name,Point location
     */
    //public Elephant(String name,Point location) {
    //super(name,location);
    //super.setWeight(500);
    //super.setDiet(diet);
    //this.trunkLength = 1;
    //MessageUtility.logConstractor("Elephant", name);
    //}
    /*
     * Set elephant trunk length(boolean)
     * @param: trunk length
     * @return true if trunk legth valid
     */
    public boolean settrunkLength(double trunkLength) {

        if(0.5<=trunkLength && trunkLength<=3) {
            this.trunkLength = trunkLength;
            MessageUtility.logSetter(super.getName(),"trunk length set", trunkLength, true);
            return true;
        }
        MessageUtility.logSetter(super.getName(), "trunk length not set",trunkLength, false);
        return false;

    }

    /*
     * Chewing operation method
     * @see chew class
     */
    public void chew() {

        MessageUtility.logSound(this.getName(),"Trumpets with joy while flapping its ears, then chews");
    }
    /*
     * Eat method(boolean)
     * if diet allows eating
     * @see eat method in animal class
     * @return true
     */
    public boolean eat(IEdible food) {
        double w = diet.eat(this, food);
        if (w>0) {
            super.setWeight(super.getWeight()+w);
            super.makeSound();
            return true;
        }
        return false;
    }
    /*
     * get food type method
     * @return food type
     * @see getfoodtype method in food packege
     */






}