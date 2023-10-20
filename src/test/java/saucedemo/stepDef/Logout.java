package saucedemo.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Logout {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Login With Valid Credentials User")
    public void Login_With_Valid_Credentials_User(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @When("The User in on The Dashboard Page")
    public void theUserInOnTheDashboardPage() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title, "Products");
    }

    @And("Click Sidebar menu in top left corner")
    public void clickSidebarMenuInTopLeftCorner() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }

    @And("Click Logout Button")
    public void clickLogoutButton() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("User back on login page")
    public void userBackOnLoginPage() {
        driver.findElement(By.name("login-button")).isDisplayed();
        driver.close();
    }

}
