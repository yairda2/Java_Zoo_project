
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package animals;

import diet.Carnivore;
import diet.Herbivore;
import diet.IDiet;
import diet.Omnivore;
import food.EFoodType;
import food.IEdible;
import graphics.AnimalsInterface;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import javax.imageio.ImageIO;

import mobility.Ilocatable;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

public abstract class Animal extends  Observable implements IEdible, IAnimalBehavior, IDrawable, Runnable, AnimalsInterface
{
    Mobile mobile;
    private static boolean runtime=true;

    private String name;
    private static boolean meat;
    private static boolean plant;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private int LastHorSpeed;
    private int LastVerSpeed;
    private boolean coordChanged;
    //private Thread thread;
    private int x_dir = 1;
    private int y_dir = 1;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1;
    private BufferedImage img2;
    private boolean threadSuspended = false;
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(),"foodtype", EFoodType.MEAT);
        return EFoodType.MEAT;
    }
    public synchronized void setSuspended()
    {
        this.threadSuspended = true;
    }
    public Animal breathe(){
        return this;
    }

    public synchronized void setResumed()
    {
        this.threadSuspended = false;
    }
    public static  void setRuntime(boolean bool)
    {
        synchronized(Animal.class)
        {
            Animal.runtime=bool;

        }
    }
      public static  boolean getRuntime()
      {
          return  Animal.runtime;
      }



    public static void changesmeat(boolean p)
    {
        meat = p;
    }

    public static void changesplant(boolean p)
    {
        plant = p;
    }

    /**public void start()
    {
        this.thread.start();
    }
     **/

    public static boolean getboolmeat(boolean p)
    {
        return meat;
    }

    public static boolean getboolplant(boolean p)
    {
        return plant;
    }

    public void setXdir(int i)
    {
        this.x_dir = i;
    }

    public void setYdir(int i)
    {
        this.y_dir = i;
    }

    public Animal(String name, Point location, String col, ZooPanel zoopanel)
    {


        mobile = new Mobile(location);
        this.name = name;
        this.col = col;
        MessageUtility.logConstractor("Animal", name);
        this.eatCount = 0;
        this.img1 = null;
        this.img2 = null;
        this.pan = zoopanel;
       // this.thread = new Thread(this);
    }

    public abstract void makeSound();

    public abstract boolean eat(IEdible var1);

    public String getName()
    {
        MessageUtility.logGetter(this.name, "getname", this.name);
        return this.name;
    }

    public boolean setWeight(double weight)
    {
        if (weight > 0.0D)
        {
            this.weight = weight;
            MessageUtility.logSetter(this.name, "setWeight", this.weight, true);
            return true;
        } else
        {
            MessageUtility.logSetter(this.name, "setWeight", this.weight, false);
            return false;
        }
    }

    public double getWeight()
    {
        return this.weight;
    }

    public boolean setDiet(IDiet diet)
    {
        this.diet = diet;
        MessageUtility.logSetter(this.name, "setDiet", this.diet.getClass().getSimpleName(), true);
        return true;
    }

    public void loadImages(String nm)
    {
        if (this.col == "Natural")
        {
            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_2.png"));
            } catch (IOException var5)
            {
                var5.printStackTrace();
            }
        }

        if (this.col == "Blue")
        {
            try
            {
                this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
                this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));
            } catch (IOException var4)
            {
                var4.printStackTrace();
            }

            if (this.col == "Red")
            {
                try
                {
                    this.img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
                    System.out.println(PICTURE_PATH + nm + "_r_1.png");
                    this.img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));
                } catch (IOException var3)
                {
                    var3.printStackTrace();
                }
            }
        }

    }

    public int getsize()
    {
        return this.size;
    }

    public void setsize(int size)
    {
        this.size = size;
    }

    public int getXdir()
    {
        return this.x_dir;
    }

    public int getYdir()
    {
        return this.y_dir;
    }

    public BufferedImage getImage1()
    {
        return this.img1;
    }

    public BufferedImage getImage2()
    {
        return this.img2;
    }

    public void drawObject(Graphics g)
    {
        if (this.getXdir() == 1)
        {
            g.drawImage(this.getImage1(), mobile.getLocation().get_x() - this.getsize() / 2, mobile.getLocation().get_y() - this.getsize() / 10, this.size, this.size, this.pan);
        } else
        {
            g.drawImage(this.getImage2(), mobile.getLocation().get_x(), mobile.getLocation().get_y() - this.size / 10, this.size, this.size, this.pan);
        }

    }
    public Mobile getMobile()
    {
        return mobile;
    }

    public String getColor()
    {
        return this.col;
    }

    public void eatInc()
    {
        ++this.eatCount;
    }

    public int getEatCount()
    {
        return this.eatCount;
    }

    public boolean getChanges()
    {
        return this.coordChanged;
    }

    public void setChanges(boolean state)
    {
        setChanged();
        notifyObservers("is back" );

    }

    public String getAnimalName()
    {
        return this.name;
    }

    public void setHorSpeed(int horSpeed)
    {
        this.horSpeed = horSpeed;
    }

    public void setVerSpeed(int verSpeed)
    {
        this.verSpeed = verSpeed;
    }

    public int getHorSpeed()
    {
        return this.horSpeed;
    }

    public int getVerSpeed()
    {
        return this.verSpeed;
    }

    public int getLastHorSpeed()
    {
        return this.LastHorSpeed;
    }

    public int getLastVerSpeed()
    {
        return this.LastVerSpeed;
    }

    public void setLastHorSpeed(int horSpeed)
    {
        this.LastHorSpeed = horSpeed;
    }

    public void setLastVerSpeed(int verSpeed)
    {
        this.LastVerSpeed = verSpeed;
    }

    public IDiet getDiet()
    {
        return this.diet;
    }

    public int getEatDistance()
    {
        return 10;
    }


    public void run()
    {
        while (true)

        {

            if(runtime) {


                if (meat || plant) {
                    if (meat && (diet instanceof Omnivore || diet instanceof Carnivore)) {
                        mobile.change_direction(EFoodType.MEAT,this);
                        if (mobile.getLocation().get_x() >= 380 && mobile.getLocation().get_x() <= 420 && mobile.getLocation().get_y() >= 280 && mobile.getLocation().get_y() <= 320) {
                            if (diet.canEat(EFoodType.VEGETABLE)) plant = false;
                            meat = false;
                        }

                    }
                    if (plant && (diet instanceof Omnivore || diet instanceof Herbivore)) {
                        mobile.change_direction(EFoodType.VEGETABLE,this);
                        if (mobile.getLocation().get_x() >= 380 && mobile.getLocation().get_x() <= 420 && mobile.getLocation().get_y() >= 280 && mobile.getLocation().get_y() <= 320) {
                            if (diet.canEat(EFoodType.MEAT)) meat = false;
                            plant = false;
                        }
                    }
                }
                while (this.threadSuspended) {
                    synchronized (this) {
                        try {
                            this.wait();
                        } catch (Exception r) {
                        }
                    }
                }
                try {

                    int x = mobile.getLocation().get_x() + this.getHorSpeed() * getXdir();
                    if (x >= 750 || x <= 0) {
                        x_dir = x_dir * (-1);
                        x = mobile.getLocation().get_x() + this.getHorSpeed() * getXdir();
                    }
                    int y = mobile.getLocation().get_y() + this.getVerSpeed() * getYdir();
                    if (y >= 550 || y <= 0) {
                        y_dir = y_dir * (-1);
                        y = mobile.getLocation().get_y() + this.getVerSpeed() * getYdir();
                    }
                    mobile.setLocation(new Point(x, y));
                    setChanged();
                    notifyObservers("is back" );
                    if (!(this.threadSuspended)) {
                        try {
                            Thread.sleep(65);
                        } catch (InterruptedException s) {
                            System.out.println("end of thread " + getName());
                            return;

                        }
                    }
                } catch (Exception e) {
                    System.out.println("throw exception 1!");

                }
            }
        }
    }



    //public void interrupt()
    //{
       // this.thread.interrupt();
   // }
    public void change_direction(IEdible f)
    {
        synchronized (this)
        {
            Point food_loc = ((Ilocatable) f).getLocation();
            if (mobile.getLocation().get_x() < food_loc.get_x() && this.x_dir == -1 || mobile.getLocation().get_x() > food_loc.get_x() && this.x_dir == 1)
            {
                this.x_dir *= -1;
            }

            if (mobile.getLocation().get_y() < food_loc.get_y() && this.y_dir == -1 || mobile.getLocation().get_y() > food_loc.get_y() && this.y_dir == 1)
            {
                this.y_dir *= -1;
            }
        }
    }
}
