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

public class CheckoutComplete {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("Login With Valid Credentials")
    public void Login_With_Valid_Credentials(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseurl);
        driver.findElement(By.name("login-button")).isDisplayed();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
    }

    @When("Add Some Product to Cart With Click Add to cart Button")
    public void addSomeProductToCartWithClickAddToCartButton() {
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
    }

    @And("Click Cart Button in the top right corner")
    public void clickCartButtonInTheTopRightCorner() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @And("Click Checkout Button")
    public void clickCheckoutButton() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
    }

    @And("Input Checkout Information")
    public void inputCheckoutInformation() {
        driver.findElement(By.id("first-name")).sendKeys("Mr");
        driver.findElement(By.id("last-name")).sendKeys("Koplak");
        driver.findElement(By.id("postal-code")).sendKeys("75123");
    }

    @And("Click Continue Button")
    public void clickContinueButton() {
        driver.findElement(By.xpath("//input[@id='continue']")).click();
    }


    @And("in Checkout overview Page Click Finish Button")
    public void inCheckoutOverviewPageClickFinishButton() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }

    @Then("User get info Thank for your order")
    public void userGetInfoThankForYourOrder() {
        String complete_checkout = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertEquals(complete_checkout, "Thank you for your order!");
        driver.close();
    }
}
