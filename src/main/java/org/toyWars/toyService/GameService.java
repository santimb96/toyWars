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
    private Action action;
    private RenderType renderType;
    private String response;
    private String renderTypeFinal;
    private static List <Pokemon> actionsList = new ArrayList<>();

    public static List<Pokemon> getActionsList() {
        return actionsList;
    }

    public static void setActionsList(List<Pokemon> actionsList) {
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

    public String getCurrentLifeBeing() {
        return currentLifeBeing;
    }

    public void setCurrentLifeBeing(String currentLifeBeing) {
        this.currentLifeBeing = currentLifeBeing;
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
        Pokemon.getPokemonAttribute().add(pokemon);
    }
    public void doActions (Actions actions){
        String response="";
        Status status=new Status();
        Pokemon pokemon=new Pokemon();
            switch (actions) {
                case EAT:
                    pokemon.doEat();
                    response += "El estado es: "+status.getEasyStatus()+" y su puntuación media es: "+status.getAvg();
                    break;
                case SLEEP:
                    pokemon.doSleep();
                    response += "El estado es: "+status.getEasyStatus()+" y su puntuación media es: "+status.getAvg();
                    break;
                case PLAY:
                    pokemon.doPlay();
                    response += "El estado es: "+status.getEasyStatus()+" y su puntuación media es: "+status.getAvg();
                    break;
                default:
            }
            if (status.getAvg()<=0){
                response = "El Pokémon ha fallecido porque su estado total es malo y menor o igual a 0. RIP";
                this.setResponse(response);
            } else {
                this.setResponse(response);
            }
    }
    //getActions() return!!
    public void listActions(){
        Pokemon pokemon=new Pokemon();
        for (int i = 0; i < Actions.values().length; i++) {
                pokemon.getCurrentAction().add(Actions.values()[i]);
             }
       /* String values=("Las acciones que puede realizar son: ");
        for (int i = 0; i < Actions.values().length; i++) {
            values += values()[i].name()+ ", ";
            }
        return values;*/
        }
    }


