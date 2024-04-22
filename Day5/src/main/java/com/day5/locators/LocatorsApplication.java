package com.day5.locators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LocatorsApplication {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driverChrome=new ChromeDriver();
		driverChrome.get("https://www.google.com");
		 driverChrome.get("https://www.demoblaze.com/");
		driverChrome.findElement(By.linkText("Laptops")).click();
        driverChrome.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(10000);
		driverChrome.findElement(By.linkText("MacBook air")).click();
		Thread.sleep(10000);
		driverChrome.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(10000);
		driverChrome.findElement(By.linkText("ok")).click();
		//driverChrome.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_UP);
		SpringApplication.run(LocatorsApplication.class, args);
	}
}
