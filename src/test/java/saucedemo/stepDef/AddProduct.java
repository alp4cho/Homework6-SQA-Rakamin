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

public class AddProduct {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Login App With Valid Credentials")
    public void Login_App_With_Valid_Credentials() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

    }

    @When("The user has successfully logged in and is on the dashboard page")
    public void theUserHasSuccessfullyLoggedInAndIsOnTheDashboardPage() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title, "Products");
    }

    @And("Add Some Product to Cart With Click Add to cart")
    public void addSomeProductToCartWithClickAddToCart() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
    }

    @And("Click Cart Button in the top right corner to next process")
    public void clickCartButtonInTheTopRightCornerToNextProcess() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("the user successfully added the product and is on the cart page")
    public void theUserSuccessfullyAddedTheProductAndIsOnTheCartPage() {
        String title = driver.findElement(By.cssSelector(".title")).getText();
        Assert.assertEquals(title, "Your Cart");
        driver.close();
    }
}
