package org.toyWars;

public class Pokemon {
    private String name;
    //tipo (planta, fuego...)
    private String type;
    private String color;
    private Status status;

    public List<Action> getCurrentAction(){
        if (status.getCurrentAction().equals(Action.fight)) {
            //listado de acciones
            //posibilidades de fight
            }
        }

        //hacer un switch
    }

    public Pokemon(String name, String type, String color){
        this.name=name;
        this.type=type;
        this.color=color;
    }

    public Pokemon(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
