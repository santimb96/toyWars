package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private int hungryPoints = 50;
    private int energyPoints = 50;
    private int healthyPoints = 50;
    private String easyStat;
    private int avg;

    public int getAvg() {
        return avg;
    }

    public void setAvg(int avg) {
        this.avg = avg;
    }

    private static ArrayList<Status> status = new ArrayList<>();

    public int getHungryPoints() {
        if (hungryPoints > 100) {
            hungryPoints = 100;
        }
        return hungryPoints;
    }

    public void setHungryPoints(int hungryPoints) {
        this.hungryPoints += hungryPoints;
    }

    public int getEnergyPoints() {
        if (energyPoints > 100) {
            energyPoints = 100;
        }
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints += energyPoints;
    }

    public int getHealthyPoints() {
        if (healthyPoints > 100) {
            healthyPoints = 100;
        }
        return healthyPoints;
    }

    public void setHealthyPoints(int healthyPoints) {
        this.healthyPoints += healthyPoints;
    }


    public static ArrayList<Status> getStatus() {
        return status;
    }

    public static void setStatus(ArrayList<Status> status) {
        Status.status = status;
    }

    //constructor
    public Status() {
    }

    ///MÉTODO EASYSTATUS
    public int getAvgPoints() {
        return ((this.getEnergyPoints() + this.getHungryPoints() + this.getHealthyPoints()) / 3);
    }

    public String getEasyStatus() {
        int avgPoints = (this.getEnergyPoints() + this.getHungryPoints() + this.getHealthyPoints()) / 3;
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
        this.setAvg(avgPoints);
        return easyStat;
    }
}


