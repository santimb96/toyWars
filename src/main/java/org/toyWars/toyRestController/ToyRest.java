package org.toyWars.toyRestController;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.toyWars.Actions;
import org.toyWars.Pokemon;
import org.toyWars.RenderType;
import org.toyWars.Status;
import org.toyWars.toyService.GameService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ToyRest {

    @GetMapping("/new")
    public Pokemon getPokemon( @RequestParam(value = "name", defaultValue = "Pikachu") String name,
                                     @RequestParam(value = "type", defaultValue = "Electric") String type,
                                     @RequestParam(value = "color", defaultValue = "yellow") String color) {
        GameService gameService = new GameService();
        gameService.reset();
        gameService.initPokemon();
        Pokemon pokemon = new Pokemon();
        Pokemon poke=pokemon.getPokemonAttribute().get(0);
        return poke;
    }
    @GetMapping("/getCurrentStatus")
    public List<Object> getCurrentStatus(@RequestParam(value = "name", defaultValue = "Pikachu") String name,
                                         @RequestParam(value = "type", defaultValue = "Electric") String type,
                                         @RequestParam(value = "color", defaultValue = "Yellow") String color,
                                         @RequestParam(value = "hungryPoints", defaultValue = "50") int hungryPoints,
                                         @RequestParam(value = "energyPoints", defaultValue = "50") int energyPoints,
                                         @RequestParam(value = "healthyPoints", defaultValue = "50") int healthyPoints) {
        GameService gameService = new GameService();
        return gameService.getPokeCurrentStatus();
    }

    @GetMapping(value = "/render/{mode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String doRender(@PathVariable ("mode") String mode) {
        GameService gameService=new GameService();
        Pokemon pokemon=new Pokemon();
        String modeUpper = mode.toUpperCase();
        RenderType renderType=RenderType.valueOf(modeUpper);
        pokemon.doRender(renderType);
        return pokemon.getReturnRender();
    }
    @GetMapping(value="/do/{Action}", produces= MediaType.APPLICATION_JSON_VALUE)
    public String doAction(@PathVariable ("Action") String action) {
        GameService gameService=new GameService();
        String actionUpper = action.toUpperCase(); //importante pasar a upper case!
        Actions actions=Actions.valueOf(actionUpper);//pasamos de string a enum
        gameService.doActions(actions);
        return gameService.getResponse();
    }

    @GetMapping("/getActions")
    public List <Actions> getActions(@RequestParam(value = "action", defaultValue = "NON ACTION SELECTED") String action) {
        GameService gameService = new GameService();
        Pokemon pokemon=new Pokemon();
        gameService.listActions();
        return pokemon.getCurrentAction();
    }

        @GetMapping("/getStats")
        public String getStats(@RequestParam(value = "action", defaultValue = "NON ACTION SELECTED") String action) {
            GameService gameService = new GameService();
            String actions="Las acciones realizadas hasta el momento son: ";
            List<Actions> list=gameService.getPastActionList();
            /*int unoMenos=list.size()-1;*/
            for (int i = 0; i < list.size(); i++) {
/*                if(list.size()==unoMenos){
                    actions+=list.get(i)+".";

                }*/
                /*else{*/
                    actions+=list.get(i)+",";
                /*}*/
            }
            actions+=".";
            return actions;
        }

}
