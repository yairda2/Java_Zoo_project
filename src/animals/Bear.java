package animals;
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import mobility.Point;
import utilities.MessageUtility;
/*
 * Bear class(an animal)
 */
public class Bear extends Roar {

    public static final Point start_location = new Point(100,5);
    public static final Omnivore diet = new Omnivore();
    private String furColor;
    private ZooPanel panel;
    BufferedImage img1= null;
    BufferedImage img2 = null;
    Graphics g;
    /*
     * Animal constructor
     * @param: name
     */
    public Bear(String name,float weight,String color, ZooPanel panel) {
        super(name,start_location,color,panel);
        super.setWeight(weight);
        super.setDiet(diet);
        this.furColor = "GRAY";
        MessageUtility.logConstractor("Bear", name);
        this.loadImages("bea");

    }

    public void roar() {
        MessageUtility.logSound(super.getName(),"Stands on its hind legs, roars and scratches its belly");

    }
    /*
     * Set fur color(boolean)
     * @param: bear fur color
     * @return true if fur color valid
     */
    public boolean setFurColor(String furColor) {
        if(furColor.equals("black") ||furColor.equals("white")|| furColor.equals("gray")){
            this.furColor = furColor;
            MessageUtility.logSetter(super.getName(), "fur set", furColor, true);
            return true;
        }
        MessageUtility.logSetter(super.getName(), "fur not set", furColor, false);
        return false;
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
     * get animal food type method
     * @return food type
     * @see getfoodtype method in food packege
     */







}