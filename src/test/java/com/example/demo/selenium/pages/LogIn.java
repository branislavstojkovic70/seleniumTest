package com.example.demo.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn {
    @FindBy(id = "button-login")
    WebElement logIn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement btnSubmitLogin;
    private final WebDriver driver;

    public LogIn(WebDriver driver)  {
        this.driver = driver;
        driver.get("http://localhost:4200/");

        PageFactory.initElements(driver, this);
    }
    public boolean login(String email, String password){
        logIn.click();
        WebDriverWait wait = new WebDriverWait(driver, 25);
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.btnSubmitLogin.click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-logout")));
        return element.isDisplayed();
    }

}