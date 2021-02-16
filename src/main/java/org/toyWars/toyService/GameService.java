package org.toyWars.toyService;

import org.springframework.stereotype.Service;
import org.toyWars.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.toyWars.Actions.*;

@Service
public class GameService{
    private List <UserAction> userAction;
    private int maxPoints;
    private Action action;
    private RenderType renderType;
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
    public void initPokemon(String fullName, String type, String color){
        Pokemon pokemon=new Pokemon();
        //ArrayList<Pokemon> pokemonAtr = new ArrayList<>();
        pokemon.setName(fullName);
        pokemon.setType(type);
        pokemon.setColor(color);
        //Pokemon.setPokemonAttribute(pokemon);
        Pokemon.getPokemonAttribute().add(pokemon);
    }
    public String doActions (Actions actions){
        String response="";
        Status status=new Status();
        Pokemon pokemon=new Pokemon();
            switch (actions) {
                case EAT:
                    pokemon.doEat();
                    response += "";
                    break;
                case SLEEP:
                    pokemon.doSleep();
                    break;
                case PLAY:
                    pokemon.doPlay();
                    break;
                default:

            }
            return response;
    }
    public void resetLifeBeing(){
    }
    public void IRender(IRender render){}
    //public Integer getStatus(){return Statu}


}
