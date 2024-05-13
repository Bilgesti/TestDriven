package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//TODO  /*Du ska testa att metoden playerSetup(Player player) i interfacet PlayerInteraction
//    (implementationsklassen är SimplePlayerInteraction) sätter spelarens namn. Använd den
//    privata metoden som du själv har skapat och som ger dig en instans av PlayerInteraction
//    och skicka med det tänkta namnet på spelaren till Scannern. Kalla därefter på metoden
//    .playerSetup() och verifiera därefter, med lämplig metod i Assertions-klassen, att
//    player.getName() motsvarar värdet av det namn du har valt (namnet du skickade in till
//    Scannern).*/

public class SimplePlayerInteractionTest {

    private Player player;
    private PlayerInteraction playerInteraction;

    private PlayerInteraction setupPlayerTest(){
        player = new Player();
        return new SimplePlayerInteraction( new IOHandler( new Scanner( "Test player" ) ) );
    }

    @BeforeEach
    void init(){

        playerInteraction = setupPlayerTest();
        playerInteraction.setupPlayer( player );
    }
    @DisplayName( "Testar att visa upp spelarens namn" )
    @Test
    void testPlayerName(){
        assertEquals( "Test player", player.getName() );

    }

    @Test
    @DisplayName( "Testar att spelarens hälsa uppdateras" )
    void testUpdatePlayerHealth(){

        playerInteraction.updatePlayerHealth(player, 5);

        Assertions.assertEquals(15, player.getHp());
    }


}
