/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */

public class test {
    private static String [] temp_animals;
    private static String op []= {"1","2","3","4","5","6","7","8","9","10"};

    public static void main(String args[])
    {
        temp_animals = new String[1];
        temp_animals[0] = "";
        for (int i = 0; i < 10; ++i)
        {
            temp_animals[0] = temp_animals[0]+" "+op[i];
        }
        System.out.print(temp_animals[0]);

        System.out.println("work");
    }
}
