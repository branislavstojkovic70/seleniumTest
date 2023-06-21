package com.example.demo.selenium.tests;


import com.example.demo.selenium.pages.DriverPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EndRideTest extends TestBase{
    DriverPage driverPage;

    @BeforeClass
    public void setUp() {
        driverPage = new DriverPage(driver);
    }
    @Test
    public void logIn() {
        boolean isLogged = driverPage.loginWithRide();
        Assert.assertTrue(isLogged);
    }

    @Test(dependsOnMethods = {"logIn"})
    public void endRide()  {
        boolean isLogged = driverPage.endRide();
        Assert.assertTrue(isLogged);
    }

    @Test(dependsOnMethods = {"endRide"})
    public void endRideNonExistingCurrentRide()  {
        boolean isLogged = driverPage.endRideFalse();
        Assert.assertTrue(isLogged);
    }
    
}