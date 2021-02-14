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
