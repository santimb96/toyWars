package org.toyWars.toyRestController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.toyWars.Actions;
import org.toyWars.Pokemon;
import org.toyWars.RenderType;
import org.toyWars.Status;
import org.toyWars.toyService.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ToyRest {
/*
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLon;

        @GetMapping(value = "/get/{IActions}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
            public ResponseEntity<List<RegisterItem>> getRegisterById(@PathVariable IActions uuid) {
            try {
                return new ResponseEntity<>(analysisService.getDataRegisterById(uuid), HttpStatus.OK);
            } catch (Exception e) {
                log.error("register:get/", e);
                return new ResponseEntity<List<RegisterItem>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }*/
    //prueba REST

    @GetMapping("/new")
    public List<Pokemon> getPokemon( @RequestParam(value = "name", defaultValue = "Pikachu") String name,
                                     @RequestParam(value = "type", defaultValue = "Electric") String type,
                                     @RequestParam(value = "color", defaultValue = "yellow") String color) {
        GameService gameService = new GameService();
        gameService.reset();
        gameService.initPokemon();
        Pokemon pokemon = new Pokemon();
        return pokemon.getPokemonAttribute();
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
        public List<Actions> getStats(@RequestParam(value = "action", defaultValue = "NON ACTION SELECTED") String action) {
            GameService gameService = new GameService();
            return gameService.getPastActionList();
        }

}
