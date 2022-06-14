package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/*
 * Herbivore class
 * implements from IDiet interface
 */
public class Herbivore implements IDiet {

    public boolean canEat(EFoodType food) {
        if (food == EFoodType.VEGETABLE) {
            return true;
        }
        return false;
    }
    /*
     * eat method
     * @params; animal,IEdible food
     * @return the updated weight if the activation of canEat method succeses
     * @see canEat method in IDiet interface
     * @see EFoodType enum
     */
    public double eat(Animal animal, IEdible food) {
        double w = 0;
        if(this.canEat(food.getFoodtype())) {
            w = animal.getWeight() * 0.07;
        }
        return w;
    }



}