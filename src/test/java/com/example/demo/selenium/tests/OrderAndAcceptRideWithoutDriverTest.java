package com.example.demo.selenium.tests;

import com.example.demo.selenium.pages.DriverPage;
import com.example.demo.selenium.pages.PassengerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderAndAcceptRideWithoutDriverTest extends TestBase{


    PassengerPage passengerPage;
    @BeforeClass
    public void setUp() {
        passengerPage = new PassengerPage(passenger);
    }

    @Test
    public void logInPassenger() {
        boolean isLogged = passengerPage.login("zika@gmail.com","123");
        Assert.assertTrue(isLogged);
    }

    @Test(dependsOnMethods = {"logInPassenger"})
    public void orderRide()  {
        boolean isOrder = passengerPage.makeOrder(passenger,"Strumicka 6","Narodnog Fronta 65");
        Assert.assertTrue(isOrder);
    }

    @Test(dependsOnMethods = {"orderRide"})
    public void orderRideNextStep()  {
        boolean isLogged = passengerPage.submitNext(passenger);
        Assert.assertTrue(isLogged);
    }

    @Test(dependsOnMethods = {"orderRideNextStep"})
    public void orderRideSubmit()  {
        boolean isLogged = passengerPage.submitOrderWithAlert(passenger);
        Assert.assertTrue(isLogged);
    }


}
