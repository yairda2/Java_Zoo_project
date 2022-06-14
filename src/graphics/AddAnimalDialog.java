
/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package graphics;

import animals.Animal;
import animals.Bear;
import animals.Elephant;
import animals.Giraffe;
import animals.Lion;
import animals.Turtle;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddAnimalDialog extends JDialog implements ActionListener {

    private JComboBox<String> animalsType;
    private String[] animalsNames = new String[]{"Herbivore", "Omnivore", "Carnivore"};

    private JButton addButton;
    AnimalsInterface animal;
    private JPanel display = new JPanel();
    public AddAnimalDialog(final ZooPanel zoopanel, ZooFrame zooframe) {
        super(zooframe, "Add animal type", true);
        this.addButton = new JButton("ADD");
        this.addButton.addActionListener(this);
        this.animalsType = new JComboBox(this.animalsNames);
        this.animalsType.addActionListener(this);
        this.display.setLayout(new BoxLayout(this.display, 3));
        this.display.add(this.animalsType);
        this.addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String choosenAnimal = (String)AddAnimalDialog.this.animalsType.getItemAt(AddAnimalDialog.this.animalsType.getSelectedIndex());


                    switch(choosenAnimal) {
                        case "Herbivore":
                            if (choosenAnimal.equals("Herbivore")) {

                                animal=new HerbivoreFactory( zoopanel,zooframe).createAnimal();

                            }
                            break;
                        case "Omnivore":
                            if (choosenAnimal.equals("Omnivore")) {
                                animal=new OmnivoreFactory( zoopanel,zooframe).createAnimal();
                            }
                            break;
                        case "Carnivore":
                            if (choosenAnimal.equals("Carnivore")) {
                                animal=new CarnivoreFactory( zoopanel,zooframe).createAnimal();


                            }
                            break;

                    }
                     AddAnimalDialog.this.dispose();

                zoopanel.addToAnimalArray(animal.breathe());
            }

        });
        this.display.add(this.addButton);
        this.add(this.display);
        this.pack();
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    }
}
