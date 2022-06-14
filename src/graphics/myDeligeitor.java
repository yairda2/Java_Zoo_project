package graphics;
import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myDeligeitor extends JDialog implements ActionListener {
    private JPanel display = new JPanel();
    private JLabel label;
    private JLabel sizeLabel;
    private JComboBox<String> animalsType;
    private JLabel horSpeedLabel;
    private JLabel verSpeedLabel;
    private JTextField sizeField;
    private JTextField horSpeedField;
    private JTextField verSpeedField;
    private String name = "zoo property";
    private float weight = 0.0F;
    private String color;
    private int i;
    private JComboBox<String> animalsPattern;
    private String[] animalsColors = new String[]{"Natural", "Blue", "Red"};
    private JButton addButton;
    private String[] animalsNames ;
    static private String[] AllanimalsNames =new String[]{"Bear", "Elephant", "Giraffe", "Lion", "Turtle"};
    private ZooPanel zoopanel;
    private int size;

    private int horSpeed;
    private int verSpeed;
    private Animal animal=null;
    public  Animal getanimal()
    {
        return animal;
    }

    public  myDeligeitor(String animalsFactorynams[],ZooPanel zoopanelp,ZooFrame zooframe) {
        super(zooframe, "Add Animal", true);
        animalsNames=animalsFactorynams;
        this.zoopanel = zoopanelp;
        this.color = color;
        this.animalsType = new JComboBox(this.animalsNames);
        this.animalsType.addActionListener(this);
        this.label = new JLabel("SELECT ANIMAL");
        this.label.setVerticalTextPosition(1);
        this.label.setHorizontalAlignment(2);
        this.display.add(this.label);
        this.display.add(this.animalsType);
        this.addButton = new JButton("ADD");
        this.addButton.addActionListener(this);
        this.display.setLayout(new BoxLayout(this.display, 3));
        this.animalsPattern = new JComboBox(this.animalsColors);
        this.animalsPattern.addActionListener(this);
        this.display.add(this.animalsPattern);
        this.display.add(this.sizeLabel = new JLabel("SIZE:"));
        this.display.add(this.sizeField = new JTextField());
        this.display.add(this.horSpeedLabel = new JLabel("HORIZON SPEED:"));
        this.display.add(this.horSpeedField = new JTextField());
        this.display.add(this.verSpeedLabel = new JLabel("VERTICAL SPEED:"));
        this.display.add(this.verSpeedField = new JTextField());
        this.addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String choosenAnimal = (String)myDeligeitor.this.animalsType.getItemAt(myDeligeitor.this.animalsType.getSelectedIndex());
                size = Integer.parseInt(sizeField.getText());
                horSpeed = Integer.parseInt(horSpeedField.getText());
                verSpeed = Integer.parseInt(verSpeedField.getText());
                color = (String) animalsPattern.getItemAt(animalsPattern.getSelectedIndex());
                String name = "zoo property";
                float weight = 0.0F;
                if (size >= 50 && size <= 300 && verSpeed <= 10 && verSpeed >= 0 && horSpeed <= 10 && horSpeed >= 0) {
                    switch(choosenAnimal) {
                        case "Turtle":
                            if (choosenAnimal.equals("Turtle")) {
                                weight = (float)((double)size * 0.5D);
                                animal = new Turtle(name, weight, color, zoopanel);
                                animal.setsize(size);
                                animal.setVerSpeed(verSpeed);
                                animal.setHorSpeed(horSpeed);

                            }
                            break;
                        case "Bear":
                            if (choosenAnimal.equals("Bear")) {
                                weight = (float)((double)size * 1.5D);
                                 animal = new Bear(name, weight, color, zoopanel);
                                animal.setsize(size);
                                animal.setVerSpeed(verSpeed);
                                animal.setHorSpeed(horSpeed);

                            }
                            break;
                        case "Lion":
                            if (choosenAnimal.equals("Lion")) {
                                weight = (float)((double)size * 0.8D);
                                animal= new Lion(name, weight, color, zoopanel);
                                animal.setsize(size);
                                animal.setVerSpeed(verSpeed);
                                animal.setHorSpeed(horSpeed);

                            }
                            break;
                        case"Elephant":
                            if (choosenAnimal.equals("Elephant")) {
                                weight = (float)(size * 10);
                                animal = new Elephant(name, weight, color, zoopanel);
                                animal.setsize(size);
                                animal.setVerSpeed(verSpeed);
                                animal.setHorSpeed(horSpeed);

                            }
                            break;
                        case "Giraffe":
                            if (choosenAnimal.equals("Giraffe")) {
                                weight = (float)((double)size * 2.2D);
                                animal= new Giraffe(name, weight, color, zoopanel);
                                animal.setsize(size);
                                animal.setVerSpeed(verSpeed);
                                animal.setHorSpeed(horSpeed);
                            }
                    }
                    myDeligeitor.this.dispose();
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid input", "MESSAGE", 1);
                }
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
