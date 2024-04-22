package com.day6;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    JavascriptExecutor js;
    Actions actions;
   @BeforeTest
   public void beforeTest(){
   driver=new ChromeDriver();
   js = (JavascriptExecutor) driver;
    actions = new Actions(driver);


    driver.get("https://www.moneycontrol.com/");
   }
   @Test
   public void test(){
    driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]")));
		
		driver.findElement(By.xpath("/html/body/div[3]/header/div[1]/div[1]/div/div/div[2]/div/div/form/div[2]/div[2]/ul/li[1]")).click();

		
		js.executeScript("window.scrollBy(0,500)");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Reliance Industries Ltd.")));
		WebElement reliance = driver.findElement(By.linkText("Reliance Industries Ltd."));
		
		if(reliance.isDisplayed()){
				System.out.println("Reliance Industries is present in the page");
		}
		else{
			System.out.println("Reliance Industries is not present in the page");
		}

   }
   @AfterTest
   public void afterTest() throws InterruptedException{
    Thread.sleep(3000);
    driver.quit();
   }
}
