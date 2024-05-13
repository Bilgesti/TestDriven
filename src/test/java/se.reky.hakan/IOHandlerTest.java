package se.reky.hakan;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

   //TODO java.util.Scanner, som används i detta spel (precis som i era elevspel) kan instanseras med en sträng.
   // Strängen kan motsvara det användaren matar in via System.in.
   // Gör detta och testa sedan, med lämplig metod i Assertions-klassen, att metoden NextLine() i
   // Scanneren ger tillbaka denna data.

   //TODO /*Metoden hasNextInt() i en java.util.Scanner kommer att returnera true om du instanserar
   //   klassen med en siffra (fast i en sträng, omgiven av citattecken). För att kunna skapa en
   //   instans av klassen IOHandler behöver du skicka med en instans av java.util.Scanner.
   //   Skapa en instans av IOHandler med en Scanner, just instanserad med en siffra. Använd
   //   din privata metod du själv har skapat och som ger tillbaka en IOHandler-instans. Testa
   //   sedan metoden hasNextInt() i IOHandler på passande sätt. Undersök klassen IOHandler
   //   för att förstå hur detta hänger ihop.
   //   */
public class IOHandlerTest {

   private IOHandler ioHandler;

   private IOHandler testIOHandler(String data){
      return new IOHandler( new Scanner( data ) );
   }

   @DisplayName( "Test av NextLine-metoden i IOHandler" )
   @Test
   void testNextLine(){

      ioHandler = testIOHandler("input");
      Assertions.assertEquals( "input", ioHandler.nextLine() );
   }

   @DisplayName( "Test av hasNextInt-metoden i IOHandler" )
   @Test
   void testHasNextInt(){

      ioHandler = testIOHandler( "123" );
      Assertions.assertTrue( ioHandler.hasNextInt() );
   }
}
