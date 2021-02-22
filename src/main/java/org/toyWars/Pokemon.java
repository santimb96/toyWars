package org.toyWars;

import net.minidev.json.JSONArray;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokemon extends LifeBeing{
    private static String name;
    private static String type;
    private static String color;
    private String returnRender;
    private static List<Pokemon> pokemonAttribute = new ArrayList<>();
    private static List<Actions> currentAction = new ArrayList<>();

    public String getFightReasonResult() {
        return fightReasonResult;
    }

    public void setFightReasonResult(String fightReasonResult) {
        this.fightReasonResult = fightReasonResult;
    }

    private String fightReasonResult;


    public Pokemon(String name, String type, String color){
        this.name=name;
        this.type=type;
        this.color=color;
    }

    public Pokemon(){}

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

    public static List<Pokemon> getPokemonAttribute() {
        return Pokemon.pokemonAttribute;
    }

    public static void setPokemonAttribute(ArrayList<Pokemon> pokemonAttribute) {
        Pokemon.pokemonAttribute = pokemonAttribute;
    }
    public String setReturnRender(String returnRender) {
        this.returnRender = returnRender;
        return returnRender;
    }
    public String getReturnRender() {
        return this.returnRender;
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
    public void doDie() {
            status.setAvg(0,0,0);
    }
    @Override
    public void doWalk() {
        Random random = new Random();
        String [] length= new String[]{"longWalk", "shortWalk"};
        String element = length[random.nextInt(length.length)];
        if(element.equals("longWalk")){
            status.setHungryPoints(-20);
            status.setHealthyPoints(25);
            status.setEnergyPoints(-30);
        } else {
            status.setHungryPoints(-10);
            status.setHealthyPoints(15);
            status.setEnergyPoints(-18);
        }
    }

    @Override
    public void doPlay() {
        Random random = new Random();
        String [] sensation= new String[]{"fun", "bored"};
        String element = sensation[random.nextInt(sensation.length)];
        if(element.equals("fun")){
            status.setHungryPoints(-20);
            status.setHealthyPoints(20);
            status.setEnergyPoints(-15);
        } else {
            status.setHungryPoints(-30);
            status.setHealthyPoints(10);
            status.setEnergyPoints(-20);
        }
    }

    //el doFight haremos como un random. Puede ser de: "Fire", "Leaf", "Water"
    @Override
    public void doFight() {
        Random random = new Random();
        String [] enemy= new String[]{"Fire", "Leaf","Water"};
        String myPokemonType=this.getType();
        String element = enemy[random.nextInt(enemy.length)];
        if(element.equals(myPokemonType)){ //si mi pokemon es del mismo elemento que el enemigo, entonces -(1/2)
            status.setHungryPoints((int)(Math.floor(status.getHungryPoints()/2)));
            status.setHealthyPoints((int)(Math.floor(status.getHealthyPoints()/2)));
            status.setEnergyPoints((int)(Math.floor(status.getEnergyPoints()/2)));
            setFightReasonResult("Eramos del mismo elemento,"+element+", hemos quedado empatados pero cansados.");
        }
        //si la primera condición no se cumple, entonces === (element != myPokemonType)
        else if(element.equals("Fire")){ //enemigo es de fuego
            if(myPokemonType.equals("Water")){// AGUA vs FIRE
                status.setHungryPoints(0);
                status.setHealthyPoints(10); //autoestima, man
                status.setEnergyPoints(-1);
                setFightReasonResult("EASY! Ese pokemon era de "+element+". ¡Mi pokemon es un campeón!");
            }
            else{ //LEAF vs FIRE (podríamos hacer un random, suerte o muerte)
                status.setHungryPoints(-20);
                status.setHealthyPoints(-10);
                status.setEnergyPoints(-20);
                setFightReasonResult("Ese pokemon era de "+element+"... Hemos perdido.");
            }
        } else if(element.equals("Leaf")){
            if(myPokemonType.equals("Water")){//WATER vs LEAF
                status.setHungryPoints(-20);
                status.setHealthyPoints(-10);
                status.setEnergyPoints(-20);
                setFightReasonResult("Ese pokemon era de "+element+"... Hemos perdido.");
            }
            else{ //FUEGO vs LEAF
                status.setHungryPoints(0);
                status.setHealthyPoints(10); //autoestima, man
                status.setEnergyPoints(-1);
                setFightReasonResult("EASY! Ese pokemon era de "+element+". ¡Mi pokemon es un campeón!");
            }
        }
        else{ //enemigo es de agua
            if(myPokemonType.equals("Leaf")){//LEAF vs AGUA
                status.setHungryPoints(0);
                status.setHealthyPoints(10); //autoestima, man
                status.setEnergyPoints(-1);
                setFightReasonResult("EASY! Ese pokemon era de "+element+". ¡Mi pokemon es un campeón!");
            }
            else{ //FUEGO vs AGUA
                status.setHungryPoints(-20);
                status.setHealthyPoints(-10);
                status.setEnergyPoints(-20);
                setFightReasonResult("Ese pokemon era de "+element+"... Hemos perdido.");
            }
        }
    }

    @Override
    public void doClean() {
        Random random = new Random();
        String [] type= new String[]{"shower", "bath"};
        String element = type[random.nextInt(type.length)];
        if(element.equals("bath")){
            status.setHungryPoints(-20);
            status.setHealthyPoints(20);
            status.setEnergyPoints(-10);
        } else {
            status.setHungryPoints(-15);
            status.setHealthyPoints(10);
            status.setEnergyPoints(-20);
        }
    }

    @Override
    public List<Actions> getCurrentAction() {
        return currentAction;
    }
    @Override
    public String toString() {
        return "name: "+name+" type: "+type+" color: "+color;
    }
    @Override
    public String doRender(RenderType renderType) {
        String returnRender = StringUtils.EMPTY;
        switch (renderType){
            case CONSOLE:
                System.out.println("Pokemon: " + getPokemonAttribute().toString());
                break;
            case HTML:
                returnRender = String.format("<div>%s</div>",getPokemonAttribute().toString());
                break;
            case JSON:
                returnRender = JSONArray.toJSONString(getPokemonAttribute());
                break;
            default:
                returnRender = "No se ha seleccionado una opción valida. Íntentalo de nuevo";
                break;
        }
        return setReturnRender(returnRender);
    }
}
