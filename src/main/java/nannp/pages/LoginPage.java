package nannp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Locator
    private WebElement txtEmail = driver.findElement(By.id("email")); //su dung thuoc tinh the HTML
    //private By txtEmail = By.id("email");
    private WebElement txtPassWord = driver.findElement(By.xpath("//input[@id='password']")); //su dung Xpath
    private WebElement btnLogin = driver.findElement(By.xpath("button[type='submit']"));

    //Action
    public void enterEmail(String email){
        txtEmail.sendKeys(email);
        //driver.findElement(txtEmail).sendKeys(email);
    }

    public void enterPassword(String password){
        txtPassWord.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }

















}
