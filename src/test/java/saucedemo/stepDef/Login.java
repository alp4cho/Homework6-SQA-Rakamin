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

public class Login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("saucedemo Login Page")
    public void saucedemo_Login_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("Input Username")
    public void input_Username() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input Password")
    public void input_Password() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click Login Button")
    public void click_Login_Button() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @Then("User in on Dashboard page")
    public void user_In_On_Dashboard_Page() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title, "Products");
        driver.close();
    }

    @And("Input Invalid Password")
    public void input_Invalid_Password() {
        driver.findElement(By.id("password")).sendKeys("tes231122");
    }

    @Then("User get error message")
    public void user_Get_Error_Message() {
        String errorlogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorlogin, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }
}
