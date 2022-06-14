/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package graphics;

import food.Meat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import plants.Plant;

public class ZooFrame extends JFrame implements ActionListener
{
    private JMenuBar menu;
    private JMenu fileMenu;
    private JMenu backGroundMenu;
    private JMenu helpMenu;
    private JMenuItem image;
    private JMenuItem exit;
    private JMenuItem green;
    private JMenuItem none;
    private JMenuItem help;
    private ImageIcon image1 = new ImageIcon("savanna.png");
    private JLabel label;
    private JLabel L1;
    ImageIcon savanna = new ImageIcon("savanna.jpg");
    JLabel savannaBackground;
    private ZooPanel zoopanel;
    private Plant plant;
    private Meat meat;

    public ZooFrame getthis(){
        return this;
    }

    public ZooFrame()
    {
        super("Our Zoo");
        this.L1 = new JLabel(this.image1);
        this.setDefaultCloseOperation(3);
        this.setSize(800, 600);
        this.menu = new JMenuBar();
        this.setJMenuBar(this.menu);
        this.zoopanel =  ZooPanel.getInstance(getthis()); //get_instance_of
        this.add(this.zoopanel);
        this.fileMenu = new JMenu("FILE");
        this.backGroundMenu = new JMenu("BACKGROUND");
        this.helpMenu = new JMenu("HELP");
        this.menu.add(this.fileMenu);
        this.menu.add(this.backGroundMenu);
        this.menu.add(this.helpMenu);
        this.image = new JMenuItem("IMAGE");
        this.backGroundMenu.add(this.image);
        this.add(this.zoopanel);
        this.exit = new JMenuItem("EXIT");
        this.fileMenu.add(this.exit);
        this.green = new JMenuItem("GREEN");
        this.backGroundMenu.add(this.green);
        this.none = new JMenuItem("NONE");
        this.backGroundMenu.add(this.none);
        this.help = new JMenuItem("HELP");
        this.helpMenu.add(this.help);
        this.exit.addActionListener(this);
        this.image.addActionListener(this);
        this.green.addActionListener(this);
        this.none.addActionListener(this);
        this.help.addActionListener(this);
        BorderLayout myBorderLayout = new BorderLayout();
        myBorderLayout.setHgap(2);
        myBorderLayout.setVgap(5);
        this.setLayout(myBorderLayout);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.exit)
        {
            System.exit(0);
        }

        if (e.getSource() == this.image)
        {
            try
            {
                if (this.label != null)
                {
                    this.remove(this.label);
                }

                this.getContentPane().setBackground((Color) null);
                BufferedImage img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png"));
                this.label = new JLabel();
                this.label.setBounds(0, 0, 800, 600);
                Image dimg = img.getScaledInstance(this.label.getWidth(), this.label.getHeight(), 4);
                ImageIcon imageIcon = new ImageIcon(dimg);
                this.label.setIcon(imageIcon);
                this.getContentPane().add(this.label);
            } catch (IOException var5)
            {
                System.out.println("Cannot load image");
                System.out.println(var5.toString());
            }
        }

        if (e.getSource() == this.green)
        {
            try
            {
                if (this.label != null)
                {
                    this.getContentPane().remove(this.label);
                }
                this.getContentPane().setBackground(Color.GREEN);
            } catch (Exception var5)
            {
                System.out.println("Cannot load image");
                System.out.println(var5.toString());
            }
        }

        if (e.getSource() == this.none)
        {
            try
            {
                if (this.label != null)
                {
                    this.getContentPane().remove(this.label);
                }
                this.getContentPane().setBackground(Color.WHITE);
            } catch (Exception var5)
            {
                System.out.println("Cannot load image");
                System.out.println(var5.toString());
            }
        }

        if (e.getSource() == this.help)
        {
            JOptionPane.showMessageDialog((Component) null, "####HW2 GUI####", "MESSAGE", 1);
        }
    }

    public static void main(String[] args)
    {
        new ZooFrame();

    }
}
