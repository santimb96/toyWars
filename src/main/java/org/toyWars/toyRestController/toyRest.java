package org.toyWars.toyRestController;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.toyWars.Actions;
import org.toyWars.Pokemon;
import org.toyWars.toyService.GameService;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


@RestController
    public class toyRest {
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
            gameService.initPokemon("Charmander", "fire", "red");
            Pokemon pokemon = new Pokemon();
            return Pokemon.getPokemonAttribute();
        }
/*

        @GetMapping("/render")
        public Account getTeam(@RequestParam(value = "names", defaultValue = "Pepito,Juanito") String names,
                               @RequestParam(value = "bank", defaultValue = "ING") String bank,
                               @RequestParam(value = "cash", defaultValue = "20.") Double cash) {
            String[] clientNames = StringUtils.split(names, ",");
            Account account = BankOperationsHelper.initAccount(bank, cash, clientNames);
            return account;
        }*/
        @GetMapping(value="/do/{Action}", produces= MediaType.APPLICATION_JSON_VALUE)
        public String doAction(@PathVariable ("Action") String action) {
            GameService gameService=new GameService();
            String actionUpper = action.toUpperCase(); //importante pasar a upper case!
            Actions actions=Actions.valueOf(actionUpper);//pasamos de string a enum
            gameService.doActions(actions);
            return gameService.getResponse();
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
