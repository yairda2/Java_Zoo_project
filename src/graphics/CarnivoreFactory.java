package graphics;

public class CarnivoreFactory implements AnimalFactory{
    static private String[] animalsNames = new String[]{"Lion"};
    private ZooPanel zoopanel;
    private myDeligeitor myeligeitor;


    public CarnivoreFactory(final ZooPanel zoopanel,ZooFrame zooframe ) {
        this.zoopanel=zoopanel;
        myeligeitor = new myDeligeitor(animalsNames,zoopanel,zooframe);
    }


    public AnimalsInterface createAnimal() {
        return myeligeitor.getanimal();
    }

}
