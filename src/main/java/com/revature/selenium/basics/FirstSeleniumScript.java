package com.revature.selenium.basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class FirstSeleniumScript {

    // variable for the webdriver
    private static WebDriver driver;

    // main method to make this class executable
    public static void main(String[] args) {

        // another way to setup the driver
//
//        // create file object of driver executable
//        File chromedriver = new File("src/main/resources/chromedriver.exe");
//
//        // set the webdriver system property and point it towards the executable driver
//        System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
//
//
//        driver = new ChromeDriver();



        // use WebDriverManager to setup driver according to the browser you are using
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();

        // instantiate the driver
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();

        // .get() - is used to load a web page by its URL
        driver.get("https://www.google.com");

        // use xpath to locate an element
        WebElement searchInput = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea"));

        // type something in
        searchInput.sendKeys("mario");
        searchInput.sendKeys(Keys.ENTER);

        // DON'T DO THIS - this is for demo purposes only - Se has more appropriate ways to 'wait'
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // need to quit the driver at the end.
        driver.quit();


    }
}
