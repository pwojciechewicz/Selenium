package tests;

import Model.Message;
import enums.MessageSubject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ContactusFormPage;
import pages.TopManuPage;
import utils.PageTitleUtils;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactUsTest extends BaseTest {

    private TopManuPage topManuPage;
    private ContactusFormPage contactusFormPage;

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        assertThat(driver.getTitle()).isEqualTo(PageTitleUtils.HOME_PAGE_TITLE);

        topManuPage = new TopManuPage(driver);
        contactusFormPage = new ContactusFormPage(driver);
    }

    @Test
    @Order(1)
    public void shouldNotAllowToSendEmptyContactUsForm() {
        // globalny wait dla wszystkich find.element (czekaj max 10 sekund)
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        WebElement contactUsLink = driver.findElement(By.linkText("Contact us"));
//        WebElement contactUsLink = driver.findElement(By.linkText("Contact os"));
//        contactUsLink.click();
        topManuPage.clickOnContactUsLink();
        contactusFormPage.clickOnSendButton();
        assertThat(contactusFormPage.isRedAlertBoxDisplayed()).isTrue();

        //nigdy nie używać!
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        WebElement redAlertBox = driver.findElement(By.className("alert-danger"));
//        //explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(redAlertBox));

//        assertThat(redAlertBox.isDisplayed()).isTrue();

    }

    @Test
    @Order(2)
    public void shouldNotAllowToSendContactUsFormWithEmailOnly() {
        topManuPage.clickOnContactUsLink();
        contactusFormPage.enterEmail("test@test.com");
        contactusFormPage.clickOnSendButton();

        assertThat(contactusFormPage.isRedAlertBoxDisplayed()).isTrue();

//        WebElement redAlertBox = driver.findElement(By.className("alert-danger"));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(redAlertBox));
//        assertThat(redAlertBox.isDisplayed()).isTrue();
    }
    @Test
    @Order(3)
    public void shouldSendContactUsFormWithValidData(){
        topManuPage.clickOnContactUsLink();
        Message message = new Message();
        message.setSubject(MessageSubject.WEBMASTER);
        message.setEmail("test@test.com");
        message.setOrderReference("123");
        message.setMessage("Jakaś wiadomość");

        contactusFormPage.sendContactUsForm(message);
        assertThat(contactusFormPage.isGreenAlertBoxDisplayed()).isTrue();


    }

}
