package graphics;

/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
public interface IAnimalBehavior {

    public String getAnimalName();
    public int getsize();
    public void eatInc();
    public int getEatCount();
    public boolean getChanges();
    public void setChanges(boolean state);
    public void setSuspended();
    public void setResumed();
}
