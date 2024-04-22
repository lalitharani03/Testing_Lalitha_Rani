package com.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://moneycontrol.com");
    }
    @Test
    public void test(){
        driver.findElement(By.id("search-str")).click();
        driver.findElement(By.id("search-str")).sendKeys("Reliance Industries");
    }
    @AfterTest
    public void afterTest() throws InterruptedException{
        Thread.sleep(3000);
        driver.quit();
    }
}
