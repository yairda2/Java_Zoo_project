package zoo;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import food.IEdible;
import mobility.Point;
import utilities.MessageUtility;
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
public class ZooActions
{
    public static boolean eat(Object animal, IEdible food)
    {
        if (animal instanceof Bear)
        {
            if (((Bear) animal).eat(food))
            {
                return true;
            }
            return false;
        }

        if (animal instanceof Elephant)
        {
            if (((Elephant) animal).eat(food))
            {
                return true;
            }
            return false;
        }

        if (animal instanceof Giraffe)
        {
            if (((Giraffe) animal).eat(food))
            {
                return true;
            }
            return false;
        }
        if (animal instanceof Lion)
        {
            if (((Lion) animal).eat(food))
            {
                return true;
            }
            return false;
        }
        if (animal instanceof Turtle)
        {
            if (((Turtle) animal).eat(food))
            {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean move(Object animal, Point point)
    {
        double distance = 0;
        double animalWeight;
        double finalWeight = 0;
        if (point.get_x() <= point.get_max_x() && point.get_x() >= point.get_min_x() && point.get_y() <= point.get_max_y() && point.get_y() >= point.get_min_y())
        {
            if (animal instanceof Turtle)
            {
                distance = ((Turtle) animal).getMobile().move(point);
                animalWeight = ((Turtle) animal).getWeight();
                finalWeight = (distance * animalWeight * 0.00025);
                ((Turtle) animal).getMobile().setLocation(point);
                ((Turtle) animal).setChanges(true);
                MessageUtility.logBooleanFunction(((Turtle) animal).getName(), "move", point.toString(), true);
                return ((Turtle) animal).setWeight(finalWeight);
            }
            if (animal instanceof Lion)
            {
                distance = ((Lion) animal).getMobile().move(point);
                animalWeight = ((Lion) animal).getWeight();
                finalWeight = (distance * animalWeight * 0.00025);
                ((Lion) animal).getMobile().setLocation(point);
                ((Lion) animal).setChanges(true);
                MessageUtility.logBooleanFunction(((Lion) animal).getName(), "move", point.toString(), true);
                return ((Lion) animal).setWeight(finalWeight);
            }
            if (animal instanceof Giraffe)
            {
                distance = ((Giraffe) animal).getMobile().move(point);
                animalWeight = ((Giraffe) animal).getWeight();
                finalWeight = (distance * animalWeight * 0.00025);
                ((Giraffe) animal).getMobile().setLocation(point);
                ((Giraffe) animal).setChanges(true);
                MessageUtility.logBooleanFunction(((Giraffe) animal).getName(), "move", point.toString(), true);
                return ((Giraffe) animal).setWeight(finalWeight);
            }
            if (animal instanceof Elephant)
            {
                distance = ((Elephant) animal).getMobile().move(point);
                animalWeight = ((Elephant) animal).getWeight();
                finalWeight = (distance * animalWeight * 0.00025);
                ((Elephant) animal).getMobile().setLocation(point);
                ((Elephant) animal).setChanges(true);
                MessageUtility.logBooleanFunction(((Elephant) animal).getName(), "move", point.toString(), true);
                return ((Elephant) animal).setWeight(finalWeight);
            }
            if (animal instanceof Bear)
            {
                distance = ((Bear) animal).getMobile().move(point);
                animalWeight = ((Bear) animal).getWeight();
                finalWeight = (distance * animalWeight * 0.00025);
                ((Bear) animal).getMobile().setLocation(point);
                ((Bear) animal).setChanges(true);
                MessageUtility.logBooleanFunction(((Bear) animal).getName(), "move", point.toString(), true);
                return ((Bear) animal).setWeight(finalWeight);
            }
            return false;
        }

        MessageUtility.logBooleanFunction("animal didn't move", "move", point.toString(), false);
        return false;
    }
}
