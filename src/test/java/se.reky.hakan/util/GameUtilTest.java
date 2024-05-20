package se.reky.hakan.util;

//TODO /*Testa metoden toLowerCaseButFirstLetterCapitalized() i klassen GameUtil. Du ska testa
// att skicka in null till denna metod. Verifiera att ett GamingException kastas med
// passande metod i Assertions-biblioteket.*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.reky.hakan.GameException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameUtilTest {
    // Deklarerar variabeln
    GameUtil gameUtil;

    // Annotation innan varje testmetod körs
    @BeforeEach
    void setUp(){
         gameUtil = new GameUtil();
    }

    // Testar att GameUtil metod hanterar null-inmatning.
    @Test
    @DisplayName( "Testar när inputen är null" )
    void toLowerCaseButFirstLetterCapitalizedNullInput(){

        assertThrows( GameException.class, () -> {
            gameUtil.toLowerCaseButFirstLetterCapitalized( null );
        } );
    }

}
