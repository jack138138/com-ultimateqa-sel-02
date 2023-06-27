package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String Myurl = "https://courses.ultimateqa.com/";

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //open url
        openBrowser(Myurl);
        //Click on LogIn button
        Mydriver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        //Verify loginpage message
        String expectedMessage = "Welcome Back!";
        String actualMessage = Mydriver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("Error Message Displayed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyTheErrorMessage() {
        //open url
        openBrowser(Myurl);
        //input credential
        Mydriver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li/a")).click();
        //input email
        Mydriver.findElement(By.name("user[email]")).sendKeys("Prime123@Testing.com");
        //input password
        Mydriver.findElement(By.name("user[password]")).sendKeys("Prime123");
        //verify Error Message
        Mydriver.findElement(By.xpath("//button[@class = 'button button-primary g-recaptcha']")).click();
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = Mydriver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("Error Message", expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
