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
 * Turtle class(an animal)
 */
public class Turtle extends Chew {

    private static final Point start_location = new Point(80,0);
    private static final Herbivore diet  = new Herbivore();
    private int age;
    /*
     * Turtle consturctor
     * @param: name
     */
    public Turtle(String name,float weight,String color,ZooPanel panel){
        super(name,start_location,color,panel);
        super.setWeight(1);
        super.setDiet(diet);
        this.age = 1;
        this.loadImages("trt");
        MessageUtility.logConstractor("Turtle", name);
    }
    /*
     * Turtle consturctor
     * @params: name,Point location
     */
    //public Turtle(String name,Point location) {
    //super(name,location);
    //super.setWeight(1);
    //super.setDiet(diet);
    //this.age = 1;
    //MessageUtility.logConstractor("Turtle", name);

    //}
    /*
     * Set Turtle trunk length(boolean)
     * @param: turtle age
     * @return true if the age valid
     */
    public boolean setAge(int age) {
        if(age>=0 && age<=500) {
            this.age = age;
            MessageUtility.logSetter(super.getName(),"age set", age, true);
            return true;

        }
        MessageUtility.logSetter(super.getName(),"age not set", age, false);
        return false;
    }
    /*
     * Chewing operation method
     * @see chew class
     */
    public void chew() {

        MessageUtility.logSound(this.getName(),"Retracts its head in then eats quietly");

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