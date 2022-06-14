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
 * Giraffe class(an animal)
 */
public class Giraffe extends Chew {

    private static final Point start_location = new Point(50,0);
    private static final Herbivore diet = new Herbivore();
    private double neckLength;
    private ZooPanel panel;
    /*
     * Giraffe consturctor
     * @param: name
     */
    public Giraffe(String name,float weight,String color,ZooPanel panel) {
        super(name,start_location,color,panel);
        super.setWeight(450);
        super.setDiet(diet);
        this.neckLength = 1.5;
        this.loadImages("grf");
        MessageUtility.logConstractor("Giraffe", name);
    }
    /*
     * Giraffe constructor
     * @params: name,Point location
     */
    //public Giraffe(String name,Point location) {
    //super(name,location);
    //super.setWeight(450);
    //super.setDiet(diet);
    //this.neckLength = 1.5;
    //MessageUtility.logConstractor("Giraffe", name);
    //}
    /*
     * Set Giraffe neck length(boolean)
     * @param: neck length
     * @return true if neck legth valid
     */
    public boolean setNeckLength(double neckLength) {
        if(1<=neckLength && neckLength<=2.5) {
            this.neckLength = neckLength;
            MessageUtility.logSetter(super.getName(),"neck length set", neckLength, true);
            return true;
        }
        MessageUtility.logSetter(super.getName(),"neck length not set", neckLength, false);
        return false;
    }
    /*
     * Chewing operation method
     * @see chew class
     */
    public void chew() {

        MessageUtility.logSound(this.getName(),"Bleats and Stomps its legs, then chews");

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