/**
 *
 * @author Yair davidoff 314792714 nehoray hajaj 208090738
 */
package mobility;

import animals.Animal;
import food.EFoodType;

public  class Mobile implements Ilocatable
{
    private Point location;
    private double totalDistance;

    public Mobile(Point location) {
        this.location = location;
        this.totalDistance = 0.0D;
    }

    public Point getLocation() {
        return this.location;
    }

    public boolean setLocation(Point p) {
        if (p.get_x() > 0 && p.get_x() < 800 && p.get_y() > 0 && p.get_y() < 600) {
            this.location = new Point(p);
            return true;
        } else {
            return false;
        }
    }

    public void addtotalDistance(double distance) {
        if (distance > 0.0D) {
            this.totalDistance += distance;
        }

    }

    public double getDistance() {
        return this.totalDistance;
    }

    public double calcDistance(Point point) {
        return Math.sqrt(Math.pow((double)(this.location.get_x() - point.get_x()), 2.0D) + Math.pow((double)(this.location.get_y() - point.get_y()), 2.0D));
    }

    public double move(Point p) {
        double dist_traveld = this.calcDistance(p);
        this.addtotalDistance(dist_traveld);
        return dist_traveld;
    }

    public void change_direction(EFoodType f,Animal animal) {

            if (this.getLocation().get_x() < 400 && (animal.getXdir() == -1)) {
                (animal).setXdir(1);
            }

            if (this.getLocation().get_y() < 300 &&animal.getYdir() == -1) {
                animal.setYdir(1);
            }

            if (this.getLocation().get_x() > 400 && animal.getXdir() == 1) {
                animal.setXdir(-1);
            }

            if (this.getLocation().get_y() > 300 && animal.getYdir() == 1) {
                animal.setYdir(-1);
            }


    }
}
