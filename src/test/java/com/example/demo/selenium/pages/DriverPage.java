package com.example.demo.selenium.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverPage {

    private WebDriver driver;

    @FindBy(id = "button-login")
    WebElement logIn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement btnSubmit;

    @FindBy(id = "end")
    WebElement btnEnd;

    @FindBy(id = "accept")
    WebElement btnAccept;
    @FindBy(id = "currentRide")
    WebElement btnCurrentRide;


    public DriverPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:4200/");

        PageFactory.initElements(driver, this);
    }


    public boolean login() {
        logIn.click();
        email.sendKeys("anjapetkovic92@gmail.com");
        password.sendKeys("123");
        btnSubmit.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-activity")));
        return element.isDisplayed();
    }

    public boolean loginWithRide() {
        logIn.click();
        email.sendKeys("bangiekg1@gmail.com");
        password.sendKeys("123");
        btnSubmit.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-activity")));
        return element.isDisplayed();
    }


    public boolean hasCurrentRide() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        btnCurrentRide = wait.until(ExpectedConditions.elementToBeClickable(By.id("currentRide")));
        return btnCurrentRide.isDisplayed();
    }

    public boolean acceptRide() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        btnAccept = wait.until(ExpectedConditions.elementToBeClickable(By.id("accept")));
        js.executeScript("arguments[0].scrollIntoView();", btnAccept);
        js.executeScript("arguments[0].click();", btnAccept);
        return true;
    }

    public boolean endRide() {
        btnCurrentRide.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        btnEnd = wait.until(ExpectedConditions.elementToBeClickable(By.id("end")));
        js.executeScript("arguments[0].scrollIntoView();", btnEnd);
        js.executeScript("arguments[0].click();", btnEnd);
        return true;
    }
}
