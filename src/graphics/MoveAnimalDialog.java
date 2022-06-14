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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import mobility.Point;
import zoo.ZooActions;

public class MoveAnimalDialog extends JDialog implements ActionListener {
    private JLabel label;
    private JLabel xCoordinateLabel;
    private JLabel yCoordinateLabel;
    private JTextField xCoordinateField;
    private JTextField yCoordinateField;
    private JComboBox<String> animalsNames;
    private String[] names;
    private JPanel display = new JPanel();
    private JButton applyButton = new JButton("APPLY");

    public MoveAnimalDialog(ZooPanel zoopanel, ZooFrame zooframe) {
        super(zooframe, "Move animal", true);
        this.applyButton.addActionListener(this);
        this.display.setLayout(new BoxLayout(this.display, 3));
        this.display.add(this.xCoordinateLabel = new JLabel("X COORDINATE:"));
        this.display.add(this.xCoordinateField = new JTextField());
        this.display.add(this.yCoordinateLabel = new JLabel("Y COORDINATE"));
        this.display.add(this.yCoordinateField = new JTextField());
        int size = zoopanel.getAnimalsarray().size();
        this.names = new String[size];

        int i;
        for(i = 0; i < size && zoopanel.getAnimalsarray().toArray()[i] != null; ++i) {
            if (zoopanel.getAnimalsarray().toArray()[i] instanceof Bear) {
                this.names[i] = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getClass().getSimpleName() + "#size " + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getsize() + "#" + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getColor();
            }

            if (zoopanel.getAnimalsarray().toArray()[i] instanceof Elephant) {
                this.names[i] = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getClass().getSimpleName() + "#size " + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getsize() + "#" + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getColor();
            }

            if (zoopanel.getAnimalsarray().toArray()[i] instanceof Giraffe) {
                this.names[i] = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getClass().getSimpleName() + "#size " + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getsize() + "#" + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getColor();
            }

            if (zoopanel.getAnimalsarray().toArray()[i] instanceof Lion) {
                this.names[i] = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getClass().getSimpleName() + "#size " + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getsize() + "#" + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getColor();
            }

            if (zoopanel.getAnimalsarray().toArray()[i] instanceof Turtle) {
                this.names[i] = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getClass().getSimpleName() + "#size " + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getsize() + "#" + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getColor();
            }
        }

        this.animalsNames = new JComboBox(this.names);
        this.animalsNames.addActionListener(this);
        this.display.add(this.animalsNames);
        int k = zoopanel.getAnimalsarray().size();

        for( i = 0; i < k; ++i) {
            int x = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getMobile().getLocation().get_x() + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getMobile().getLocation().get_x() * ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getVerSpeed();
            int y = ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getMobile().getLocation().get_y() + ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getMobile().getLocation().get_y() * ((Animal)zoopanel.getAnimalsarray().toArray()[i]).getHorSpeed();
            if (ZooActions.move(zoopanel.getAnimalsarray().toArray()[i], new Point(x, y))) {
                ((Animal)zoopanel.getAnimalsarray().toArray()[i]).setChanges(true);
                zoopanel.manageZoo();
            }
        }

    }

    public void actionPerformed(ActionEvent e) {
    }
}
