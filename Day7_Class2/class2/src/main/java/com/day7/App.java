package com.day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.moneycontrol.com");
        driver.findElement(By.id("wzrk-cancel")).click();
        driver.findElement(By.id("search_str")).click();
        driver.findElement(By.id("search_str")).sendKeys("Reliance Industries");
        driver.findElement(By.id("Capa_1")).click();
        System.out.println( "Hello World!" );
    }
}
