/* Registro del momento en el que se ha ejecutado la action.
* El tipo de juguete sobre el que se ha realizado.
* Los puntos de inicio.
* Los puntos conseguidos.*/
package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class UserAction {
    List<List> currentStatus = new ArrayList<List>();

    public List<List> getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(List<List> currentStatus) {
        this.currentStatus = currentStatus;
    }


}
