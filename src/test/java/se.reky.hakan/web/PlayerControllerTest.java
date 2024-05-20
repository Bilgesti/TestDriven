package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Använder disabled för att testerna kommer inte nå till Github Action
@Disabled
public class PlayerControllerTest {

    // Variabel som representerar Selenium-webbläsaren
    private WebDriver driver;

    //Körs före alla test. Här använder vi WebDriverManager för att konfigurera ChromeDrivern.
    @BeforeAll
    public static void  init(){
        WebDriverManager.chromedriver().setup();
    }

    //Körs före varje test. Setup metoden instansierar ChromeDriver innan varje testmetod körs sedan körs till URL-n
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get( "http://localhost:8080/players" );
    }

    //Körs efter varje test. Stänger ner drivern efter testet.
    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }


    // Testar att rätt antal spelare visas i listan genom att räkna antalet <li>- elementet på sidan.
    @DisplayName( "Testar rätt antal spelare visas i listan" )
    @Test
    void correctNumberOfPlayersIsShown(){
        assertEquals( 2, driver.findElements( By.tagName( "li" )).size());
    }

    // Testar att första spelarens namn visas på webbsidan genom att hitta elementet med klassen "player-name"
    // Och kontrollera om det är synligt.
    @DisplayName( "Testar att visas rätt namn på första spelaren" )
    @Test
    void showFirstPlayerName(){
        WebElement firstPlayerName = driver.findElement( By.className( "player-name" ) );

        assertTrue( firstPlayerName.isDisplayed() );

    }

    // Testar att webbplatsens titeln är korrekt genom att jämföra den med förväntad titel.
    @DisplayName("Testar webbplatsens titel")
    @Test
    public void testWebsiteTitle(){
        // kontrollerar att titeln matchar
        assertEquals("Players List", driver.getTitle());
    }


    @DisplayName( "Testar att knappen har texten = Logga in" )
    @Test
    void testTextButton(){
        WebElement loginButton = driver.findElement( By.tagName( "button" ) );

        assertEquals( "Logga in", loginButton.getText() );
    }

    // Testar att ny endpoint som fungerar genom att klicka på en spelar-länk och kontrollera om spelardetaljerna visas.
    @DisplayName( "Testar att ny endPoint fungerar" )
    @Test
    void testPlayerDetailsEndPoint(){

        WebElement playerLink = driver.findElement( By.className( "player-name" ) );
        playerLink.click();

        WebDriverWait wait = new WebDriverWait( driver, Duration.ofSeconds( 5 ) );
        WebElement playerDetails = wait.until( ExpectedConditions.visibilityOfElementLocated(By.className( "player-id" )) );

        assertTrue( playerDetails.isDisplayed() );

    }

    // Testar att spelarinformation visas när man besöker en specifik spelare med ID.
    @Test
    void getPlayerById(){
        driver.get("http://localhost:8080/players/1");

        WebElement playerById = driver.findElement(By.className("player-id"));

        assertTrue(playerById.isDisplayed() );
    }

}
