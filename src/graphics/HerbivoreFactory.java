package graphics;
 import animals.*;
 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

public class HerbivoreFactory implements AnimalFactory {


    static private String[] animalsNames = new String[]{"Elephant", "Giraffe", "Turtle"};
    private ZooPanel zoopanel;
    private myDeligeitor myeligeitor;


    public HerbivoreFactory(final ZooPanel zoopanel,ZooFrame zooframe ) {
        this.zoopanel=zoopanel;
        myeligeitor = new myDeligeitor(animalsNames,zoopanel,zooframe);
    }


    public AnimalsInterface createAnimal() {




        return myeligeitor.getanimal();



    }

    // static  void main (String []args) {
      ///  new HerbivoreFactory(ZooPanel.gettheInstance());
    //}
}
