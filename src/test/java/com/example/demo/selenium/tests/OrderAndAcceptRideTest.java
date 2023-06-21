package com.example.demo.selenium.tests;
import com.example.demo.selenium.pages.DriverPage;
import com.example.demo.selenium.pages.PassengerPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderAndAcceptRideTest extends TestBase {
    DriverPage driverPage;

    PassengerPage passengerPage;
    @BeforeClass
    public void setUp() {
        driverPage = new DriverPage(driver);
        passengerPage = new PassengerPage(passenger);
    }

    @Test
    public void logIn() {
        boolean isLogged = driverPage.login();
        Assert.assertTrue(isLogged);
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
        boolean isLogged = passengerPage.submitOrder(passenger);
        Assert.assertTrue(isLogged);
    }

    @Test(dependsOnMethods = {"orderRideSubmit"})
    public void acceptRide() throws InterruptedException {
        boolean isLogged = driverPage.acceptRide();
        Assert.assertTrue(isLogged);
    }




}