package org.toyWars.toyRestController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.toyWars.Actions;
import org.toyWars.IActions;
import org.toyWars.Pokemon;
import org.toyWars.RenderType;
import org.toyWars.toyService.GameService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
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
        @GetMapping("/getActions")
        public String getName(@RequestParam(value = "name", defaultValue = "Pika") String name) {
        return name;
        }

        @GetMapping("/new")
        public ArrayList<Pokemon> getPokemon(@RequestParam(value = "name", defaultValue = "Pikachu") String name,
                                             @RequestParam(value = "type", defaultValue = "Electric") String type,
                                             @RequestParam(value = "color", defaultValue = "yellow") String color) {
            GameService gameService = new GameService();
            gameService.initPokemon();
            Pokemon pokemon = new Pokemon();
            return Pokemon.getPokemonAttribute();
        }


       @GetMapping(value = "/render/{mode}", produces = MediaType.APPLICATION_JSON_VALUE)
        public String doRender(@PathVariable ("mode") String mode) {
            GameService gameService=new GameService();
            String modeUpper = mode.toUpperCase();
            RenderType renderType=RenderType.valueOf(modeUpper);
            gameService.doRender(renderType);
            return gameService.getResponse();
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
        public List <String> getActions(@RequestParam(value = "action", defaultValue = "NON ACTION SELECTED") String action) {
        GameService gameService = new GameService();
        gameService.initPokemon();
        Pokemon pokemon = new Pokemon();
        return Pokemon.getPokemonAttribute();
    }
        /*
        @GetMapping("/getCurrentStatus")
        public Student getStudent(@RequestParam(value = "name", defaultValue = "Quijote") String name) {
            return new Student(counter.incrementAndGet(), String.format(template, name));
        }
        @GetMapping("/getStats")
        public Student getStudent(@RequestParam(value = "name", defaultValue = "Quijote") String name) {
            return new Student(counter.incrementAndGet(), String.format(template, name));
        }
    }*/


}
