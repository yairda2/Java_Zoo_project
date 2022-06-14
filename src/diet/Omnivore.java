package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/*
 * Homnivore class
 * implements from IDiet interface
 */
public class Omnivore implements IDiet {

    public boolean canEat(EFoodType food) {
        if (food == EFoodType.MEAT || food == EFoodType.VEGETABLE) {
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
            if(food.getFoodtype() == EFoodType.MEAT) {
                w = (animal.getWeight()/10);
            }
            if(food.getFoodtype() == EFoodType.VEGETABLE) {
                w = (animal.getWeight() * 0.07);
            }
        }
        return w;



    }
}