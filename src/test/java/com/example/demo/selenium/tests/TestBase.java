package com.example.demo.selenium.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static WebDriver passenger;

    @BeforeSuite
    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0, 0));
        Dimension halfScreenSize = new Dimension((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        driver.manage().window().setSize(halfScreenSize);
//        driver.manage().window().fullscreen();


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        passenger = new ChromeDriver();
        passenger.manage().window().setPosition(new Point((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2), 0));  // Podešava položaj prozora na sredinu ekrana
        passenger.manage().window().setSize(halfScreenSize);

    }

}
