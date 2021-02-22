/*Estado del LifeBeing (bastaría con el número de puntos)*/
package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class Status {
    private static int hungryPoints;
    private static int energyPoints;
    private static int healthyPoints;
    private static String easyStat;
    private int maxPoints;
    private int avg;

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints=maxPoints;
    }

    public int getAvg() {
        int maxPoints=getMaxPoints();
        this.avg =(int)(Math.floor(this.getEnergyPoints() + this.getHungryPoints() + this.getHealthyPoints())/3);
        if (this.avg<=0)
        {
            this.avg=0;
        }
        if(maxPoints<this.avg)
        {
            setMaxPoints(this.avg);
        }
        return this.avg;
    }

    public void setAvg(int hungryPoints,int energyPoints,int healthyPoints) {
        this.hungryPoints=hungryPoints;
        this.energyPoints=energyPoints;
        this.healthyPoints=healthyPoints;
    }

    private static ArrayList<Status> status = new ArrayList<>();

    public int getHungryPoints() {
        if (this.hungryPoints > 100) {
            hungryPoints = 100;
        }
        return hungryPoints;
    }

    public void setHungryPoints(int hungryPoints) {
        if(getAvg()<=0)
        {
            this.hungryPoints=0;
        }
        else {
            int hungryP = getHungryPoints();
            this.hungryPoints = hungryP + hungryPoints;
        }
    }

    public int getEnergyPoints() {
        if (this.energyPoints > 100) {
            energyPoints = 100;
        }
        return energyPoints;
    }

    public void setEnergyPoints(int energyPoints) {
        if(getAvg()<=0)
        {
            this.energyPoints=0;
        }
        else {
            int eP = getEnergyPoints();
            this.energyPoints= eP + energyPoints;
        }
    }

    public int getHealthyPoints() {
        if (this.healthyPoints > 100) {
            healthyPoints = 100;
        }
        return healthyPoints;
    }

    public void setHealthyPoints(int healthyPoints) {
        if(getAvg()<=0)
        {
            this.healthyPoints=0;
        }
        else {
            int hP=getHealthyPoints();
            this.healthyPoints = hP + healthyPoints;
        }
    }

    //constructor
    public Status() {}

    public Status(int hungryPoints, int energyPoints, int healthyPoints) {
        this.hungryPoints = hungryPoints;
        this.energyPoints = energyPoints;
        this.healthyPoints = healthyPoints;
        this.maxPoints=(int)(Math.floor(hungryPoints+energyPoints+healthyPoints)/3); //inicializamos los maxPoints con el primer average

    }

    ///MÉTODO EASYSTATUS
    public String getEasyStatus() {
        int avgPoints=getAvg();
        if(avgPoints<=0){
            easyStat="Pokemon died";
        }
        else if (avgPoints>0 && avgPoints < 25) {
            easyStat = "Bad";
        } else if (avgPoints > 25 && avgPoints < 50) {
            easyStat = "Not bad";
        } else if (avgPoints >= 50 && avgPoints < 65) {
            easyStat = "Good";}
        else {
            easyStat = "Excellent";
        }
        return easyStat;
    }
}


