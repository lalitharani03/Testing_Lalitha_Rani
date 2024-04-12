package com.day4.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		WebDriver driverchrome=new ChromeDriver();
        driverchrome.get("https://www.google.com");
		driverchrome.get("https://shoppersstop.com/");
		driverchrome.findElement(By.className("user-icon")).click();
		WebDriver driveredge=new EdgeDriver();
		WebDriver driverfirefox=new FirefoxDriver();
		driveredge.get("https://www.edge.com");
		driverfirefox.get("https://www.firefox.com");
		SpringApplication.run(SeleniumApplication.class, args);
	}

}
