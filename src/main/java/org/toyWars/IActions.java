package org.toyWars;

import java.util.List;

public interface IActions {
    public void doEat();
    public void doSleep();
    public void doPlay();
    public void doClean();
    public void doDie();
    public void doWalk();
    public void doFight();
    public List<Actions> getCurrentAction();
    //generar una lista de acciones
    //dame la lista de acciones
}
