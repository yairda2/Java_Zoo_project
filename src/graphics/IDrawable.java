package graphics;

import java.awt.Graphics;

/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738

 * IDrawable constructor
 **/
public interface IDrawable {

    public final static String PICTURE_PATH ="C:\\Users\\neora\\Desktop\\AOPP\\ZOO_YAIR_EDIT\\assignment2_pictures\\";
    void loadImages(String var1);
    public void drawObject(Graphics g);
    public String getColor();




}
