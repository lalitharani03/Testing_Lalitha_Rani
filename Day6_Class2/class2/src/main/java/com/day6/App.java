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
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://www.moneycontrol.com/");

		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search_str")));
		
		
		driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");

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


		driver.close();
        System.out.println( "Hello World!" );
    }
}
