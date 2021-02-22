package org.toyWars.toyService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.toyWars.*;
import org.toyWars.toyRestController.ToyRest;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.toyWars.Actions.*;

@Service
public class GameService{
    private List <UserAction> userAction;
    private int maxPoints;
    private RenderType renderType;
    private String response;
    private String renderTypeFinal;
    private static List <Actions> actionsList = new ArrayList<>();

    public static List<Actions> getPastActionList() {
        return pastActionList;
    }

    public static void setPastActionList(List<Actions> pastActionList) {
        GameService.pastActionList = pastActionList;
    }

    private static List <Actions> pastActionList = new ArrayList<>();

    private static List<Object> pokeCurrentStatus = new ArrayList<Object>(); //le vamos a meter los puntos, sus características...

    public static List<Actions> getActionsList() {
        return actionsList;
    }

    public static void setActionsList(List<Actions> actionsList) {
        GameService.actionsList = actionsList;
    }

    public String getRenderTypeFinal() {
        return renderTypeFinal;
    }

    public void setRenderTypeFinal(String renderTypeFinal) {
        this.renderTypeFinal = renderTypeFinal;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    //INSTANCIA DE INTERACCIÓN DEL USUARIO
    private String currentLifeBeing;

    public List<UserAction> getUserAction() {
        return userAction;
    }

    public void setUserAction(List<UserAction> userAction) {
        this.userAction = userAction;
    }

    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public void setPokeCurrentStatus() {
        Pokemon pokemon=new Pokemon();
        Status status = new Status();
        if(status.getMaxPoints()<status.getAvg())
        {
            setMaxPoints(status.getAvg());
        }
        this.getPokeCurrentStatus().add(pokemon);
        this.getPokeCurrentStatus().add(status);
    }

    public List<Object> getPokeCurrentStatus(){
        return pokeCurrentStatus;
    }

    /////MÉTODOS
    public void initPokemon(){
        Random random=new Random() ;
        Pokemon pokemon=new Pokemon();
        Status status=new Status(50,50,50);
        String[] pokeMonster=new String[]{"Charmander", "Bulbasaur", "Squirtle"};
        String[] pokeType=new String[]{"Fire", "Leaf", "Water"};
        String[] pokeColor=new String[]{"Red", "Green", "Blue"};
        int position = random.nextInt(pokeMonster.length);
        pokemon.setName(pokeMonster[position]);
        pokemon.setType(pokeType[position]);
        pokemon.setColor(pokeColor[position]);
        pokemon.getPokemonAttribute().add(pokemon);
        setPokeCurrentStatus(); //lista de datos
    }
    public void doActions (Actions actions) {
        String response = "";
        Status status = new Status();
        Pokemon pokemon = new Pokemon();
        switch (actions) {
            case EAT:
                pokemon.doEat();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += "El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            case SLEEP:
                pokemon.doSleep();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += "El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            case CLEAN:
                pokemon.doClean();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += "El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            case WALK:
                pokemon.doWalk();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += "El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            case DIE:
                pokemon.doDie();
                response = "Has asesinado al pokemon. RIP";
                break;
            case FIGHT:
                pokemon.doFight();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = pokemon.getFightReasonResult()+" El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += pokemon.getFightReasonResult()+"El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            case PLAY:
                pokemon.doPlay();
                if (status.getAvg() <= 0) {
                    status.setAvg(0, 0, 0);
                    response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                    this.setResponse(response);
                }else{
                    response += "El estado es: " + status.getEasyStatus() + " y su puntuación media es: " + status.getAvg();
                }
                break;
            default:
        }
        pastActionList.add(actions);
        this.setResponse(response);
    }
    //getActions() return!!
    public void listActions(){
        Pokemon pokemon=new Pokemon();
        for (int i = 0; i < Actions.values().length; i++) {
            pokemon.getCurrentAction().add(Actions.values()[i]);
        }
    }

    public void reset(){
        getPokeCurrentStatus().clear();
    }

}


