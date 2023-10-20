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

public class CheckoutYourInformation {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Login With Valid Credentials user and password")
    public void Login_With_Valid_Credentials_user_and_password(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        driver.findElement(By.name("login-button")).isDisplayed();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @When("Add Some Product to Cart With Click Add to cart Button in every product")
    public void addSomeProductToCartWithClickAddToCartButtonInEveryProduct() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }

    @And("Click Cart in the top right corner")
    public void clickCartInTheTopRightCorner() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("Click Checkout Button to next process")
    public void clickCheckoutButtonToNextProcess() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("Input First Name")
    public void inputFirstName() {
        driver.findElement(By.id("first-name")).sendKeys("Mr");
    }

    @And("Input Last Name")
    public void inputLastName() {
        driver.findElement(By.id("last-name")).sendKeys("Koplak");
    }

    @And("Input Postal Code")
    public void inputPostalCode() {
        driver.findElement(By.id("postal-code")).sendKeys("75123");
    }

    @And("Click Continue Button to next process")
    public void clickContinueButtonToNextProcess() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }

    @Then("User in on Checkout Overview Page")
    public void userInOnCheckoutOverviewPage() {
        String overviewpage = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(overviewpage, "Checkout: Overview");
        driver.close();
    }

    @And("Do Not Input Postal Code")
    public void doNotInputPostalCode() {
        //Dikosongkan untuk Pengujian
    }

    @Then("User get error message postal code is required")
    public void userGetErrorMessagePostalCodeIsRequired() {
        String errorlogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorlogin, "Error: Postal Code is required");
        driver.close();
    }
}
