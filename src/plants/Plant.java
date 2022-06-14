/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package plants;

import food.EFoodType;
import food.IEdible;
import graphics.ZooPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

import static graphics.IDrawable.PICTURE_PATH;

public abstract class Plant implements IEdible, Ilocatable {
    private double height;
    private Point location;
    private double weight;
    private ZooPanel zoopanel;
    private BufferedImage plantImage = null;

    public Plant(ZooPanel zoopanel) {
        Random rand = new Random();
        this.location = new Point(400, 300);
        this.height = (double)rand.nextInt(30);
        this.weight = (double)rand.nextInt(12);
        MessageUtility.logConstractor("Plant", "Plant");
        this.zoopanel = zoopanel;
    }
    public Plant getPlant()
    {
        return this;
    }
    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.VEGETABLE);
        return EFoodType.VEGETABLE;
    }

    public double getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }

    public Point getLocation() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }

    public double getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return this.weight;
    }

    public boolean setHeight(double height) {
        boolean isSuccess = height >= 0.0D;
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0.0D;
        }

        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }

    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.chackBoundaris(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }

        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }

    public boolean setWeight(double weight) {
        boolean isSuccess = weight >= 0.0D;
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0.0D;
        }

        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);
        return isSuccess;
    }

    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

    public void loadImages(String nm) {
        try {
            this.plantImage = ImageIO.read(new File(PICTURE_PATH + nm));
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public void drawObject(Graphics g) {
        if (this.plantImage != null) {
            g.drawImage(this.plantImage, 400, 300, 40, 40, this.zoopanel);
        }

        this.zoopanel.manageZoo();
    }
}
