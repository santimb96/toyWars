package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private int hungryPoints=50;
    private int energyPoints=50;
    private int healthyPoints=50;
    private String easyStat;
    private static ArrayList <Status> status = new ArrayList<>();

    public int getHungryPoints() {
        return hungryPoints;
    }

    public void setHungryPoints(int hungryPoints) {
            this.hungryPoints += hungryPoints;
    }

    public int getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        this.energyPoints += energyPoints;
    }

    public int getHealthyPoints() {
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
    public Status(){}

///MÉTODO EASYSTATUS
    public int getAvgPoints(){
        return (this.getEnergyPoints()+ this.getHungryPoints()+ this.getHealthyPoints()/3);
    }
public String getEasyStatus(){
    int avgPoints = this.getAvgPoints();
    String easyStat;
    if (avgPoints<25){
        easyStat = "Bad";
    }
    else if (avgPoints>25 && avgPoints<50){
        easyStat = "Not bad";
    }
    else if(avgPoints>=50 && avgPoints<65){
        easyStat = "Good";
    }
    else{
        easyStat = "Excellent";
    }
    return easyStat;
    }
}


