package org.toyWars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon extends LifeBeing{
    private String name;
    //tipo (planta, fuego...)
    private String type;
    private String color;
    private static ArrayList<Pokemon> pokemonAttribute = new ArrayList<>();

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

//MÉTODOS DE LA INTERFACE (ACCIONES ENUM EAT, SLEEP Y PLAY)
    Status status=new Status();
    @Override
    public void doEat() {
        Random random = new Random();
        String [] food = new String[]{"healthyFood", "garbageFood"};
            String element = food[random.nextInt(food.length)];
            if(element.equals("healthyFood")){
                    status.setHungryPoints(20);
                    status.setHealthyPoints(10);
                    status.setEnergyPoints(20);
            } else {
                    status.setHungryPoints(20);
                    status.setHealthyPoints(10*(-1));
                    status.setEnergyPoints(10);
            }
    }
    @Override
    public void doSleep() {
        Random random = new Random();
        String[] sleep = new String[]{"bad", "good", "excellent"};
        String element = sleep[random.nextInt(sleep.length)];
            switch (element) {
                case "bad":
                    status.setHungryPoints(-30);
                    status.setEnergyPoints(10);
                    status.setHealthyPoints(-10);
                    break;
                case "good":
                    status.setHungryPoints(-25);
                    status.setEnergyPoints(20);
                    status.setHealthyPoints(10);
                    break;
                default:
                    status.setHungryPoints(-20);
                    status.setEnergyPoints(30);
                    status.setHealthyPoints(20);
                    break;
            }
    }
    @Override
    public void doPlay() {
    Random random=new Random();

    }

    @Override
    public List<Actions> getCurrentAction() {
        return null;
    }

    @Override
    public void doRender(RenderType renderType) {

    }
}
