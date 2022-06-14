/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package graphics;
import java.util.Observable;
import java.util.Observer;
import animals.Animal;
import diet.Carnivore;
import diet.Omnivore;
import food.IEdible;
import food.Meat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.concurrent.*;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import mobility.Point;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

public class ZooPanel extends JPanel implements Runnable, ActionListener
{
    public synchronized  int getarraysize(){return this.array.size();}
    public synchronized  int getanimalsQueuesize(){return this.animalsQueue.size();}
    public synchronized  int getAnimalcaunt(){return this.Animalcaunt;}
    public synchronized  void incAnimalcaunt(){Animalcaunt+=1;}
    public synchronized  void decAnimalcaunt(){Animalcaunt-=1;}
    private boolean threadSuspended = false;
    private boolean notthreadSuspended = false;
    private int Animalcaunt=0;
    private Thread controller;
    private BufferedImage img = null;
    private ArrayList<Runnable> animalsQueue;
    private boolean changeChack = false;
    private  controller theanimalcontroller;

    private Plant plant;
    private List<Object> foodDataBase;
    private JPanel lowerPanel;
    private JButton addAnimalButton;
    private JButton clearButton;
    private JButton foodButton;
    private JButton infoButton;
    private JButton exitButton;
    private JButton SleepButton;
    private JButton WakeUpButton;
    private ZooFrame zooframe;
    private int timetowait=1;



    private String[] foodNames = new String[]{"Lettuce", "Cabbage", "Meat"};

    //HW4
    private ExecutorService threadPoolExecutor;
    private List<Runnable> array;
    static  private  volatile ZooPanel single_instance = null;
    public ZooFrame getFrame(){
        return zooframe;
    }
    private final int sizeofLinkedBlockanimals=10;
    private ZooPanel(ZooFrame p)
    {
        theanimalcontroller=new controller();
        this.setSize(800, 540);
        this.setLayout(new BorderLayout());
        this.lowerPanel = new JPanel();
        this.lowerPanel.setPreferredSize(new Dimension(800, 25));
        this.zooframe = p;
        this.addAnimalButton = new JButton("ADD ANIMAL");
        this.SleepButton = new JButton("Sleep");
        this.WakeUpButton = new JButton("Wake");
        this.clearButton = new JButton("CLEAR");
        this.foodButton = new JButton("FOOD");
        this.infoButton = new JButton("INFO");
        this.exitButton = new JButton("EXIT");
        this.lowerPanel.add(this.addAnimalButton);
        this.lowerPanel.add(this.SleepButton);
        this.lowerPanel.add(this.WakeUpButton);
        this.lowerPanel.add(this.clearButton);
        this.lowerPanel.add(this.foodButton);
        this.lowerPanel.add(this.infoButton);
        this.lowerPanel.add(this.exitButton);
        this.lowerPanel.setLayout(new FlowLayout(1, 2, 2));
        this.lowerPanel.setBackground(Color.CYAN);
        this.addAnimalButton.addActionListener(this);
        this.SleepButton.addActionListener(this);
        this.WakeUpButton.addActionListener(this);
        this.foodButton.addActionListener(this);
        this.clearButton.addActionListener(this);
        this.infoButton.addActionListener(this);
        this.exitButton.addActionListener(this);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(this.lowerPanel, "South");
        this.animalsQueue = new ArrayList();
        this.setVisible(true);
        this.controller = new Thread(this);
        this.lowerPanel.setVisible(true);
        this.controller.start();
        array=new  ArrayList();
        threadPoolExecutor = Executors.newFixedThreadPool(10);
    }

    public static ZooPanel getInstance(ZooFrame p)
    {        if (single_instance == null)
            synchronized(ZooPanel.class){
                if (single_instance == null)
                    single_instance = new ZooPanel(p);
            }
        return single_instance;
    }
    public static ZooPanel gettheInstance()
    {
        return single_instance;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if (this.changeChack)
        {

            Dimension size = this.getSize();
            g.drawImage(this.img, 0, 0, size.width, size.height, this);
        }

        try
        {
            Iterator var4 =array.iterator();
            Iterator var3 = this.animalsQueue.iterator();

            while (var4.hasNext())
            {
                Animal animals = (Animal) var4.next();
                animals.drawObject(g);
            }
            this.plant.drawObject(g);

        }
        catch (Exception var4)
        {
        }
    }

    public void run()
    {

        while (true)
        {
            try
            {
                Thread.sleep(10L);
            } catch (InterruptedException var2)
            {
                System.out.print("Exception 3");
            }


            this.manageZoo();

            if (threadSuspended) {

                   try {
                       threadSuspended = false;

                      /*/

                       timetowait = 0;


                       Object op[] = array.toArray();
                       for (int i = 0; i < op.length; ++i) {
                           if (op[i] != null) {
                               synchronized ((Animal) op[i]) {
                                   ((Animal) op[i]).setSuspended();
                                   //threadPoolExecutor.wait(1000000000);
                               }
                           }
                       }

                      /*/

                       synchronized (threadPoolExecutor) {
                           System.out.println("MTF");
                           Animal.setRuntime(false);
                           threadPoolExecutor.wait(1000000000);
                       }
                   }catch ( InterruptedException op )
                    {
                        System.out.print("Exception 4");
                    }





            }
           /*/ if (notthreadSuspended) {
                System.out.println("MTF55");

                    try {
                        notthreadSuspended = false;
                        timetowait=1;
                        Object op[] =array.toArray();
                        for (int i =0 ;i<op.length;++i) {
                            if (op[i] != null)
                                ((Animal) op[i]).setResumed();
                        }
                        synchronized (this) {
                            System.out.println("MTF55");
                                notifyAll();
                        }
                                    //threadPoolExecutor.wait(1000000000);
                    } catch (IllegalMonitorStateException var2) {
                        System.out.print("Exception 4");
                    }

            }/*/
            //threadPoolExecutor.shutdown();
        }

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == this.addAnimalButton)
        {
            if ( array.size()+this.animalsQueue.size()<15)
                new AddAnimalDialog(this, this.zooframe);
            else
            {
                JOptionPane.showInternalMessageDialog((Component) null, "you cant add more than 15 animals");
            }
        }

        int i;
        if (e.getSource() == this.foodButton)
        {
            i = JOptionPane.showOptionDialog(this, "CHOOSE FOOD", "Animal Food", 1, -1, (Icon) null, this.foodNames, (Object) null);
            switch (i)
            {
                case 0:
                case 1:
                    this.plantEdible(i);
                    Animal.changesplant(true);
                    break;
                case 2:
                    this.plantEdible(i);
                    Animal.changesmeat(true);
            }
        }


        if (e.getSource() == clearButton)
        {

            if (getarraysize()> 0) {
                synchronized(this.getAnimalsarray()) {

                    for ( i = 0; i < array.size(); i++) {
                        ( (Animal)array.get(i)).setSuspended();
                         ((Animal)array.get(i)).setChanges(true);

                        if(array.remove( array.get(i)))
                            System.out.println("yes");
                        repaint();
                    }

                }
            }
            if (getanimalsQueuesize() > 0)
            {
                synchronized(this.animalsQueue) {

                    for (i = 0; i <= array.size(); i++) {
                        synchronized (this.getAnimalsarray()) {
                            ((Animal) animalsQueue.get(i)).setChanges(true);
                            if (animalsQueue.remove(animalsQueue.get(i)))
                                System.out.println("yes");
                            repaint();
                        }
                    }
                }
            }
            if (foodDataBase!=null) {
                for ( i = 0; i <= foodDataBase.size(); i++) {
                   if( foodDataBase.get(i)!=null);
                    {
                        foodDataBase.remove(0);
                        repaint();
                    }
                }
            }
            threadPoolExecutor.shutdown();
            plant = null;
            //meat = null;
            repaint();
        }

        if (e.getSource() == this.infoButton)
        {
            JFrame frame = new JFrame();
            String[][] data = new String[this.array.size()][6];
            Object op [] = array.toArray();
            for (i = 0; i < array.size(); ++i)
            {
                data[i][0] = ((Animal) op[i]).getClass().getSimpleName();
                data[i][1] =  ((Animal) op[i]).getColor();
                data[i][2] = String.valueOf( ((Animal) op[i]).getWeight());
                data[i][3] = String.valueOf( ((Animal) op[i]).getHorSpeed());
                data[i][4] =String.valueOf( ((Animal) op[i]).getVerSpeed());
                data[i][5] = String.valueOf( ((Animal) op[i]).getEatCount());
            }

            String[] collumn = new String[]{"Animal", "Color", "Weight", "Horizon speed", "Vertical sped", "Eat count"};
            JTable table = new JTable(data, collumn);
            table.setBounds(40, 80, 150, 250);
            JScrollPane scroll_pane = new JScrollPane(table);
            frame.add(scroll_pane);
            frame.setSize(300, 400);
            frame.setVisible(true);
        }

        if (e.getSource() == this.exitButton)
        {
            System.exit(0);
        }

        if (e.getSource() == this.SleepButton)
        {
            synchronized (this){
                threadSuspended = true;


            }

        }
        if (e.getSource() == this.WakeUpButton) {
            System.out.println("MTF0");
                System.out.println("MTF0");
                try {
                    synchronized (threadPoolExecutor) {
                      threadPoolExecutor.notifyAll();
                        Animal.setRuntime(true);
                    }
                        /*/Object op[] =array.toArray();
                        for (int k =0 ;k<op.length;++k) {
                            if (op[k] != null)
                                ((Animal) op[k]).setResumed();
                        }
                        /*/
                }
            catch (IllegalMonitorStateException var2)
                {
                    System.out.println("MTF0");
                }

            notthreadSuspended = true;
        }




    }

    /*/public boolean isChange()  {

       for(int i =0;i<array.size();++i)

            if (((Animal)array.get(i)).getChanges())
            {
                ((Animal)array.get(i)).setChanges(false);
                return true;
            }


        return false;
    }/*/

    public void addToAnimalArray(Animal animal) {
        synchronized (this.array) {

        try {
            animal.breathe().addObserver(theanimalcontroller);

            if (this.array.size() == 10 && this.animalsQueue.size() < 5) {
                incAnimalcaunt();
                animalsQueue.add(animal);


            } else if (this.array.size() < 10) {

                    incAnimalcaunt();
                    this.array.add(animal);
                    this.threadPoolExecutor.execute(animal);
                    System.out.println(array.size()+"כוסעמק0");
                    this.repaint(this.array.size());

            } else {
                throw new ArrayIndexOutOfBoundsException();
            }


            //this.animalsQeueu.add(animal);
            this.repaint();
        } catch (ArrayIndexOutOfBoundsException var3) {
            JOptionPane.showInternalMessageDialog((Component) null, "you cant add more than 15 animals");
        }
    }
    }

    public  List<Runnable> getAnimalsarray()
    {
        return this.array;
    }
    int p;
    public void manageZoo() {
        // if (this.isChange())
        // {
        synchronized (this) {
            this.repaint();
            for (int i = 0; i < this.array.size(); ++i) {
                Animal animal = ((Animal) array.get(i));
                if (animal!=null) {
                    for (int j = 0; j < this.array.size(); ++j) {
                        if (animal.getMobile().calcDistance(((Animal) array.get(j)).getMobile().getLocation()) < (((Animal) array.get(j))).getWeight() && (animal).getWeight() > 2.0 * (((Animal) array.get(j))).getWeight() && (animal).eat(((Animal) array.get(j)))) {
                            p = i - 1;
                            synchronized (this.array) {
                                System.out.println("its coming");
                                decAnimalcaunt();
                                animal.eatInc();
                                this.array.remove(array.get(j));
                                System.out.println(array.size());
                                if (animalsQueue.size() > 0) {
                                    array.add(animalsQueue.get(0));
                                    this.threadPoolExecutor.execute(animalsQueue.get(0));
                                    System.out.println("its coming כוסעמק");
                                    animalsQueue.remove(0);

                                }
                            }


                            this.repaint();
                        }
                    }
                }

                if (this.plant != null && (animal.getMobile().calcDistance(new Point(400, 300)) < (double) (animal).getEatDistance() && (animal).eat(this.plant))) {
                    this.plant = null;
                    animal.eatInc();
                    this.repaint();
                }
            }


            // }

        }
    }

    public IEdible get_food()
    {
        return this.plant;
    }

    public void plantEdible(int choose)
    {
        switch (choose)
        {
            case 0:
                this.plant = Lettuce.getInstance(this,zooframe);
                this.plant.loadImages("lettuce.png");
                this.repaint();
                break;
            case 1:
                this.plant = Cabbage.getInstance(this,zooframe);
                this.plant.loadImages("cabbage.png");
                this.repaint();
                break;
            case 2:
                this.plant =  Meat.getInstance(this);
                this.plant.loadImages("meat.gif");
                this.repaint();
        }

    }




    public class controller implements Observer {
        @Override
        public void update(Observable o, Object arg) {
            manageZoo();

        }
    }
}
