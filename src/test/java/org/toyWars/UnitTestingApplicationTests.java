package org.toyWars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.toyWars.toyService.GameService;

import java.util.ArrayList;
import java.util.Arrays;

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
    public void initPokemonTest(){
        Pokemon pokemon=new Pokemon();
        GameService gameService=new GameService();
        gameService.initPokemon("Charizard", "fire", "red");
        Assertions.assertEquals(Arrays.asList("Charizard", "fire", "red"), pokemon.getPokemonDNI());
    }

}
