package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpencartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
       System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        driver = new FirefoxDriver(); //launch browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
        driver.get("https://demo.opencart.com"); // enter the url

    }
    @Test
    public void opencartTest(){
        String title = driver.getTitle();
        System.out.println("The title is:" + title);

        if(title.equals("Your Store")){
            System.out.println("CORRECT TITLE");
        }
        else{
            System.out.println("The Title is Incorrect");

        }
    }

    @Test
    public void getLogo(){
       boolean b =  driver.findElement(By.xpath("//img[@title ='Your Store']")).isDisplayed();
       System.out.println(b);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
