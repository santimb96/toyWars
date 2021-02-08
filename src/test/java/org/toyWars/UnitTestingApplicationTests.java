package org.toyWars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class UnitTestingApplicationTests {

    @Test
    void setName() {
		Pokemon pokemon = new Pokemon();
		pokemon.setName("Pikachu");
        Assertions.assertEquals("Pikachu", pokemon.getName());
    }

}
