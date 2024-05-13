package se.reky.hakan.model;
//TODO /*Skapa ett test av attack()-metoden i Actor-klassen. Låt en implementation-klass av Actor
//  attackera en annan implementations-klass av Actor. Verifiera att den attackerades HP
//  minskar på ett sätt som överensstämmer med vad du förväntar dig. Instansera båda
//  implementationerna med värden (ej de tomma konstruktorerna). */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.IOHandler;
import se.reky.hakan.SimplePlayerInteraction;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorTest {
    Player player;
    Goblin goblin;

    @BeforeEach
    void init() {
        player = new Player( "Håkan", 10, 7 );
        goblin = new Goblin( "Goblin", 20, 3 );
    }

    @Test
    @DisplayName( "Testar att Goblin tar attack från spelaren" )
    void playerAttackToGoblin(){
        int goblinHP = goblin.getHp();

        player.attack( goblin );
        assertEquals(goblin.getHp(),goblinHP- player.getDamage());
    }

    @Test
    @DisplayName( "Testar att Spelaren tar attack från Goblin" )
    void goblinAttackToPlayer(){
        int playerHP = player.getHp();

        goblin.attack( player );
        assertEquals( player.getHp(),playerHP- goblin.getDamage() );
    }

}
