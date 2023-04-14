import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class HomePageTest {

    private WebDriver driver; //komunikacja z przeglądarką
    private WebElement element; //obsługa elementów na stronie

    //przed wszystkimi testami
    @BeforeAll
//    public static void setupCLass() {
//        WebDriverManager.chromedriver().setup();
//    }
    public static void setupCLass() {
        WebDriverManager.chromedriver().setup();
    }

    //przed każdym testem
//    @BeforeEach
//    public void setupTest() {
//        driver = new ChromeDriver();
//    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    //po każdym teście
    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldReturnCorrectPageTitle() {
        driver.get("http://automationpractice.pl/index.php");
        Assertions.assertThat(driver.getTitle()).isEqualTo("My Store");
//        System.out.println(driver.getTitle());
    }

    @Test
    public void shouldSeeBestsellersOnHomePage() {
        driver.get("http://automationpractice.pl/index.php");
//
        List<WebElement> bestsellersByCssSelector = driver.findElements(By.cssSelector("#blockbestsellers .product-name"));
//        List<WebElement> bestsellersByXpath = driver.findElements(By.xpath("//*[@id='blockbestsellers']//*[@class='product-name']"));
//
        for (WebElement bestseller : bestsellersByCssSelector) {
            System.out.println(bestseller.getText());
        }
//        for (WebElement bestseller : bestsellersByXpath) {
//            System.out.println(bestseller.getText());
//        }

    }
}

