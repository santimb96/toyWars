package org.toyWars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.toyWars.toyService.GameService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class UnitTestingApplicationTests {

    @Test
    public void Pokemon() {
		Pokemon pokemon = new Pokemon("Charizard", "fire", "red" );
        Assertions.assertEquals(pokemon.getName(), "Charizard", "No es igual");
        Assertions.assertEquals(pokemon.getType(), "fire", "No es igual");
        Assertions.assertEquals(pokemon.getColor(), "red", "No es igual");
    }
    @Test
    public void doAction(){
        Status status=new Status(50,50,50);
        GameService gameservice=new GameService();
        gameservice.doActions(Actions.EAT);
        Assertions.assertEquals("El estado es: Good y su puntuación media es: 50", gameservice.getResponse());
    }
    /*@Test
    public void initPokemonTest(){
        Pokemon pokemon=new Pokemon();
        GameService gameService=new GameService();
        gameService.initPokemon("Charizard", "fire", "red");
        Assertions.assertArrayEquals(Pokemon.getPokemonAttribute().toArray(new Pokemon[0]), Pokemon.getPokemonAttribute().toArray(new Pokemon[0]));
    }*/
    @Test
    public void doEat(){
        Pokemon pokemon=new Pokemon();
        Status status=new Status(50,50,50);
        pokemon.doEat();
        Assertions.assertEquals(70, status.getHungryPoints());
    }
    @Test
    public void doEatAverage(){
        Pokemon pokemon=new Pokemon();
        Status status=new Status(50,50,50);
        pokemon.doEat();
        int average=(status.getHealthyPoints()+status.getEnergyPoints()+status.getHungryPoints())/3;
        Assertions.assertEquals(average, status.getAvg());
    }

    @Test
    public void doSleepAverage(){
        Pokemon pokemon=new Pokemon();
        Status status=new Status(50,50,50);
        pokemon.doSleep();
        int average=(status.getHealthyPoints()+status.getEnergyPoints()+status.getHungryPoints())/3;
        Assertions.assertEquals(average, status.getAvg());
    }

    //trying the default values (50,50,50) on initPokemon
    @Test
    public void initPokemon(){
        GameService gameService= new GameService();
        Pokemon pokemon=new Pokemon();
        Status status=new Status();
        gameService.initPokemon();
        pokemon.doEat();
        Assertions.assertEquals(70, status.getHungryPoints());
    }
}
