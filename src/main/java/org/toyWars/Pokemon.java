package org.toyWars;

import java.util.ArrayList;
import java.util.List;

public class Pokemon extends LifeBeing{
    private String name;
    //tipo (planta, fuego...)
    private String type;
    private String color;

    public static ArrayList<Pokemon> pokemonAttribute = new ArrayList<>();

    public Pokemon(String name, String type, String color){
        this.name=name;
        this.type=type;
        this.color=color;
    }

    public Pokemon(){}

/*
    public List<Action> getCurrentAction(){
        if (status.getCurrentAction().equals(Action.fight)) {
            //listado de acciones
            //posibilidades de fight
            }
        }*/

        //hacer un switch

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

    public static ArrayList<Pokemon> getPokemonAttribute() {
        return pokemonAttribute;
    }

    public static void setPokemonAttribute(ArrayList<Pokemon> pokemonAttribute) {
        Pokemon.pokemonAttribute = pokemonAttribute;
    }

//MÉTODOS DE LA INTERFACE (ACCIONES ENUM EAT, SLEEP Y PLAY
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
