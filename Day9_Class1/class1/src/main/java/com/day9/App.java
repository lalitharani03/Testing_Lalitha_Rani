package com.day9;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException 
    {
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://groww.in");
        driver.findElement(By.xpath("//*[@id='footer']/div/div[1]/div/div[1]/div[2]/div[3]/a[2]")).click();
        
        String text=driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/h1")).getText();
        if(text.equals("Calculators")){
            System.out.print("The Site Groww contains Calculators");
            //test.log(Status.PASS, "The Site Groww contains Calculators");
        }
        else{
            System.out.println("The Site doesn't contains Calculators");
            //test.log(Status.PASS, "The Site doesn't contains Calculators");
        }

        TakesScreenshot ts=(TakesScreenshot)driver;
        File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/groww.png"));


        driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]/div/p[1]")).click();

        
        driver.findElement(By.xpath("//*[@id='LOAN_AMOUNT']")).sendKeys("2300000");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input")).sendKeys("8");
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input")).sendKeys("25");

        
        String find =  driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if(find.equals("Your Amortization Details (Yearly/Monthly)")){
            System.out.println("Success");
            //test.log(Status.PASS, "Success");
        }
        else{
            System.out.println("Failed");
            //test.log(Status.PASS, "Failed");
        }
    }
}
