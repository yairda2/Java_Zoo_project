package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/*
 * Carnivore class
 * implements from IDiet interface
 */
public class Carnivore implements IDiet {
    public boolean canEat(EFoodType food) {
        if (food == EFoodType.MEAT) {
            return true;
        }
        return false;

    }
    /*
     * eat method
     * @params: animal,IEdible food
     * @return the updated weight if the activation of canEat method succeses
     * @see canEat method in IDiet interface
     * @see EFoodType enum
     */
    public double eat(Animal animal, IEdible food) {
        double w = 0;
        EFoodType food_type = food.getFoodtype();
        if(this.canEat(food_type)) {
            w = animal.getWeight()/10;

        }
        return w;

    }

}
