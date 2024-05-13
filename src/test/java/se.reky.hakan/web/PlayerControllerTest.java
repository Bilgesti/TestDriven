package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Använder disabled för att testerna kommer inte nå till Github Action
@Disabled
public class PlayerControllerTest {

    private WebDriver driver;

    //Körs före alla test
    @BeforeAll
    public static void  init(){
        WebDriverManager.chromedriver().setup();
    }

    //Körs före varje test
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.get( "http://localhost:8080/players" );
    }

    //Körs efter varje test
    @AfterEach
    void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @DisplayName("Testar webbplatsens titel")
    @Test
    public void testWebsiteTitle(){
        // Navigera in till den URL
        driver.get("http://localhost:8080/players");
        // kontrollerar att titeln matchar
        assertEquals("Players List", driver.getTitle(), "Titeln stämmer med förväntat");
    }

    @DisplayName( "Testar rätt antal spelare visas i listan" )
    @Test
    void correctNumberOfPlayersIsShown(){
        driver.get("http://localhost:8080/players");

        assertEquals( 2, driver.findElements( By.tagName( "li" )).size());
    }

    @DisplayName( "Testar att visas rätt namn på första spelaren" )
    @Test
    void showFirstPlayerName(){
        driver.get("http://localhost:8080/players");

        WebElement firstPlayerName = driver.findElement( By.className( "player-name" ) );

        assertTrue( firstPlayerName.isDisplayed() );

    }

    @DisplayName( "Testar att knappen har texten = Logga in" )
    @Test
    void testTextButton(){
        driver.get( "http://localhost:8080/players" );

        WebElement loginButton = driver.findElement( By.tagName( "button" ) );

        assertEquals( "Logga in", loginButton.getText() );
    }

    @Test
    void getPlayerById(){
        driver.get("http://localhost:8080/players/1");

        WebElement playerById = driver.findElement(By.className("player-id"));

        assertTrue(playerById.isDisplayed() );
    }

}
