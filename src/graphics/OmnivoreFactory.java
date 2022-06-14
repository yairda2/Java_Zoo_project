package graphics;

import animals.Bear;

public class OmnivoreFactory implements AnimalFactory {
    static private String[] animalsNames = new String[]{"Bear"};
    private ZooPanel zoopanel;
    private myDeligeitor myeligeitor;


    public OmnivoreFactory(final ZooPanel zoopanel,ZooFrame zooframe ) {
        this.zoopanel=zoopanel;
        myeligeitor = new myDeligeitor(animalsNames,zoopanel,zooframe);
    }


    public AnimalsInterface createAnimal() {
        return myeligeitor.getanimal();
    }

}



