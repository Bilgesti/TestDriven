package se.reky.hakan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.model.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO  /*Du ska testa att metoden playerSetup(Player player) i interfacet PlayerInteraction
//    (implementationsklassen är SimplePlayerInteraction) sätter spelarens namn. Använd den
//    privata metoden som du själv har skapat och som ger dig en instans av PlayerInteraction
//    och skicka med det tänkta namnet på spelaren till Scannern. Kalla därefter på metoden
//    .playerSetup() och verifiera därefter, med lämplig metod i Assertions-klassen, att
//    player.getName() motsvarar värdet av det namn du har valt (namnet du skickade in till
//    Scannern).*/

public class PlayerInteractionTest {

    private Player player;
    private PlayerInteraction playerInteraction;


    @BeforeEach
    void setUp(){
        player = new Player();
        IOHandler ioHandler = new IOHandler(createScannerWithInput());
        playerInteraction = new SimplePlayerInteraction(ioHandler);
    }
    private Scanner createScannerWithInput() {
        InputStream inputStream = new ByteArrayInputStream( "Test Player".getBytes());
        return new Scanner(inputStream);
    }

    @Test
    void testPlayerSetup() {
        String playerName = "Test Player";
        playerInteraction.setupPlayer(player); // Anropa setupPlayer-metoden med vår spelare
        Assertions.assertEquals(playerName, player.getName()); // Verifiera att spelarens namn är det förväntade
    }

    @Test
    @DisplayName( "Test that update player HP" )
    void testUpdatePlayerHealth(){

        int initialHealth = player.getHp();
        int healthIncrement = 5; // Increment health by 5
        int expectedHealth = initialHealth + healthIncrement;

        playerInteraction.updatePlayerHealth(player, healthIncrement);

        Assertions.assertEquals(expectedHealth, player.getHp());
    }

}
