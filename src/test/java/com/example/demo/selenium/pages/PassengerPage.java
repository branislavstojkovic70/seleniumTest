package com.example.demo.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassengerPage {
    private WebDriver driver;

    @FindBy(id = "button-login")
    WebElement logIn;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement btnSubmitLogin;

    @FindBy(id = "order-ride")
    WebElement btnOrderRide;

    @FindBy(id = "departure")
    WebElement departureInput;

    @FindBy(id = "destination")
    WebElement destinationInput;

    @FindBy(id = "initLocation")
    WebElement locationsButton;

    @FindBy(id = "time")
    WebElement time;

    @FindBy(id = "radioGroup")
    WebElement radioGroup;

    @FindBy(id = "option1")
    WebElement option1;

    @FindBy(id = "petTransport")
    WebElement petTransport;

    @FindBy(id = "babyTransport")
    WebElement babyTransport;

    @FindBy(id = "next1")
    WebElement form1Submit;

    @FindBy(id = "next2")
    WebElement form1Submit2;

    @FindBy(id = "next3")
    WebElement form1Submit3;

    public PassengerPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:4200/");

        PageFactory.initElements(driver, this);
    }


    public boolean login(String email, String password) {
        logIn.click();
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        btnSubmitLogin.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-logout")));
        return element.isDisplayed();
    }

    public boolean makeOrder(WebDriver driver, String departure, String destination) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Adding delay to ensure that any overlay that might appear after the page load disappears
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        btnOrderRide = wait.until(ExpectedConditions.elementToBeClickable(By.id("order-ride")));
        js.executeScript("arguments[0].scrollIntoView();", btnOrderRide);
        js.executeScript("arguments[0].click();", btnOrderRide);

        departureInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("departure")));
        departureInput.sendKeys(departure);
        destinationInput.sendKeys(destination);

        locationsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("initLocation")));
        js.executeScript("arguments[0].scrollIntoView();", locationsButton);
        js.executeScript("arguments[0].click();", locationsButton);


        locationsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("option1")));
        js.executeScript("arguments[0].scrollIntoView();", option1);
        js.executeScript("arguments[0].click();", option1);

        locationsButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("option1")));
        js.executeScript("arguments[0].scrollIntoView();", option1);
        js.executeScript("arguments[0].click();", option1);

        petTransport = wait.until(ExpectedConditions.elementToBeClickable(By.id("petTransport")));
        js.executeScript("arguments[0].scrollIntoView();", petTransport);
        js.executeScript("arguments[0].click();", petTransport);

        babyTransport = wait.until(ExpectedConditions.elementToBeClickable(By.id("babyTransport")));
        js.executeScript("arguments[0].scrollIntoView();", babyTransport);
        js.executeScript("arguments[0].click();", babyTransport);

        form1Submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("next1")));
        js.executeScript("arguments[0].scrollIntoView();", form1Submit);
        js.executeScript("arguments[0].click();", form1Submit);
        return true;
    }


    public boolean submitNext(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        form1Submit = wait.until(ExpectedConditions.elementToBeClickable(By.id("next2")));
        js.executeScript("arguments[0].scrollIntoView();", form1Submit2);
        js.executeScript("arguments[0].click();", form1Submit2);

        return true;
    }

    public boolean submitOrder(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        form1Submit3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("next3")));
        js.executeScript("arguments[0].scrollIntoView();", form1Submit3);
        js.executeScript("arguments[0].click();", form1Submit3);

        return true;
    }

    public boolean submitOrderWithAlert(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        form1Submit3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("next3")));
        js.executeScript("arguments[0].scrollIntoView();", form1Submit3);
        js.executeScript("arguments[0].click();", form1Submit3);

        try {
            WebDriverWait wait1 = new WebDriverWait(driver, 30);
            wait1.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No Alert present");
        } finally {
            driver.quit();
        }
        return true;


    }





}
