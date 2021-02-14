package org.toyWars;

import java.util.List;

public class Status extends LifeBeing{
    //private Action currentAction;
    private int happyPoints;

    public int getHappyPoints() {
        return happyPoints;
    }

    public void setHappyPoints(int happyPoints) {
        this.happyPoints = happyPoints;
    }

    //constructor
    public Status(){}

    @Override
    public void doEat() {

    }

    @Override
    public void doSleep() {

    }

    @Override
    public void doPlay() {

    }

    @Override
    public List<Actions> getCurrentAction() {
        return null;
    }

    @Override
    public void doRender(RenderType renderType) {

    }
}
