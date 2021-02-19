/*Estado del LifeBeing (bastaría con el número de puntos)*/
package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private static int hungryPoints;
    private static int energyPoints;
    private static int healthyPoints;
    private static String easyStat;
    private int avg;

    public int getAvg() {
        return ((this.getEnergyPoints() + this.getHungryPoints() + this.getHealthyPoints()) / 3);
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    private static ArrayList<Status> status = new ArrayList<>();

    public int getHungryPoints() {
        if (this.hungryPoints > 100) {
            hungryPoints = 100;
        }
        return hungryPoints;
    }

    public void setHungryPoints(int hungryPoints) {
        int hP=getHungryPoints();
        this.hungryPoints = hP+hungryPoints;
    }

    public int getEnergyPoints() {
        if (this.energyPoints > 100) {
            energyPoints = 100;
        }
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        int eP=getEnergyPoints();
        this.energyPoints = eP+energyPoints;
    }

    public int getHealthyPoints() {
        if (this.healthyPoints > 100) {
            healthyPoints = 100;
        }
        return healthyPoints;
    }

    public void setHealthyPoints(int healthyPoints) {
        int hP=getHealthyPoints();
        this.healthyPoints = healthyPoints;
    }

    public static ArrayList<Status> getStatus() {
        return status;
    }

    public static void setStatus(ArrayList<Status> status) {
        Status.status = status;
    }

    //constructor
    public Status() {}

    public Status(int hungryPoints, int energyPoints, int healthyPoints) {
        this.hungryPoints = healthyPoints;
        this.energyPoints = energyPoints;
        this.healthyPoints = hungryPoints;
    }


    ///MÉTODO EASYSTATUS
    public String getEasyStatus() {
        //int avgPoints = (this.getEnergyPoints() + this.getHungryPoints() + this.getHealthyPoints()) / 3;
        int avgPoints=getAvg();
        String easyStat;
        if (avgPoints < 25) {
            easyStat = "Bad";
        } else if (avgPoints > 25 && avgPoints < 50) {
            easyStat = "Not bad";
        } else if (avgPoints >= 50 && avgPoints < 65) {
            easyStat = "Good";
        } else {
            easyStat = "Excellent";
        }
        //this.setAvg(avgPoints); //por qué le estamos haciendo un set?
        return easyStat;
    }
}


