package org.toyWars.toyRestController;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.toyWars.IActions;
import org.toyWars.Pokemon;

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
/*
        @GetMapping("/new")
        public Team getTeam(@RequestParam(value = "name", defaultValue = "Quijote") String name,
                            @RequestParam(value = "q", defaultValue = "12") Integer numPlayers) {
            Team team = new Team();
            team.setName(name);
            team.setPlayerList(CompetitionHelper.getRandomPlayers(numPlayers, name, ""));
            return team;
        }


        @GetMapping("/render")
        public Account getTeam(@RequestParam(value = "names", defaultValue = "Pepito,Juanito") String names,
                               @RequestParam(value = "bank", defaultValue = "ING") String bank,
                               @RequestParam(value = "cash", defaultValue = "20.") Double cash) {
            String[] clientNames = StringUtils.split(names, ",");
            Account account = BankOperationsHelper.initAccount(bank, cash, clientNames);
            return account;
        }
        @GetMapping("/doAction")
        public Student getStudent(@RequestParam(value = "name", defaultValue = "Quijote") String name) {
            return new Student(counter.incrementAndGet(), String.format(template, name));
        }
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
