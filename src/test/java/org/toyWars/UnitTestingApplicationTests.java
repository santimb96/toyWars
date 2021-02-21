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
        Pokemon pokemon=new Pokemon();
        initPokemon();
        Assertions.assertEquals(Arrays.asList("Bulbasaur", "Leaf","Green",null), Pokemon.getPokemonAttribute() );

    }
    @Test
    public void doAction(){
        Status status=new Status(50,50,50);
        GameService gameservice=new GameService();
        gameservice.doActions(Actions.EAT);
        Assertions.assertEquals("El estado es: Good y su puntuación media es: 56", gameservice.getResponse());
    }
    @Test
    public void pokemonStatusAvg(){
        Status status=new Status(20,50,50);
        Assertions.assertEquals(40,status.getAvg());
        Assertions.assertEquals(20,status.getHungryPoints());
        Assertions.assertEquals(50,status.getEnergyPoints());
        Assertions.assertEquals(50,status.getHealthyPoints());
    }

    @Test
    public void pokemonDiedStatus(){
        Status status=new Status(50,50,50);
        status.setAvg(0,0,0);
        Assertions.assertEquals(0,status.getHungryPoints());
        Assertions.assertEquals(0,status.getEnergyPoints());
        Assertions.assertEquals(0,status.getHealthyPoints());
    }

    @Test
    public void pokemonPlayingAverageNegative(){
        Pokemon pokemon= new Pokemon();
        Status status=new Status();
        status.setAvg(50,50,50); //empezamos el juego (init)
        status.setHungryPoints(-50); //doPlay 50-50 =0
        status.setHealthyPoints(-60); //doPlay 50-60=-10
        status.setEnergyPoints(-50); //doPlay 50-50=0
        //the avg after playing == 0
        Assertions.assertEquals(0,status.getAvg());
    }

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

    //me estoy complicando x2
    @Test
    public void gettingAttributes(){
        List<Object> pokeCurrentStatus = new ArrayList<>();
        Pokemon pokemon = new Pokemon();
        Status status = new Status();
        GameService gameService = new GameService();
        gameService.initPokemon();
        pokeCurrentStatus.add(pokemon.getName());
        pokeCurrentStatus.add(pokemon.getType());
        pokeCurrentStatus.add(pokemon.getColor());
        pokeCurrentStatus.add(status.getHungryPoints());
        pokeCurrentStatus.add(status.getHealthyPoints());
        pokeCurrentStatus.add(status.getEnergyPoints());
        Assertions.assertEquals(pokeCurrentStatus,gameService.getPokeCurrentStatus());
    }

    @Test
    public void resetear(){
        GameService gameService = new GameService();
        gameService.initPokemon();
        gameService.reset();
        Assertions.assertEquals("[]",gameService.getPokeCurrentStatus()); //da error porque no se como plasmar un objeto vacío xD
    }

    @Test
    public void gettingMaxPoints(){
        Status status = new Status(50,50,50);
        Assertions.assertEquals(50,status.getMaxPoints());
    }

    @Test
    public void gettingPastList(){
        GameService gameService = new GameService();
        gameService.doActions(Actions.EAT);
        Assertions.assertNotNull(gameService.getPastActionList());
    }

/*    @Test
    public void resurrectionConfirmation(){
        Status status=new Status(0,0,0);
        GameService gameService = new GameService();
        gameService.reset();
        System.out.println(gameService.getPokeCurrentStatus());
    }*/

}
