package com.day8;

import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest 
{
    Actions actions;
    Alert alert;
    WebDriverWait wait;
    WebDriver driver;
    String text;
    String username, password;

    @BeforeTest
    public void beforeTest() throws IOException{
        String path="E:\\software testing\\Day8_Class2\\class2\\Excelsheet\\Datas.xlsx";
        XSSFWorkbook workbook=new XSSFWorkbook(path);
        username = workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        password = workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        workbook.close();
       
        driver =  new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        actions = new Actions(driver);
    }
    @Test(priority = 1)
    public void test1() throws InterruptedException{

         driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();

         WebElement b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("MacBook air")));
         b.click();

         WebElement x = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tbodyid']/div[2]/div/a")));
         x.click();

         wait.until(ExpectedConditions.alertIsPresent()).accept();

        Thread.sleep(5000);

         WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div/ul/li[4]/a")));
         e.click();
         
        WebElement text2 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tbodyid']/tr/td[2]")));
        
        
         if(text2.getText().equals("MacBook air")){
            System.out.println("MacBook air is there");
         }
         else{
            System.out.println("MacBook air is not there");
         }
    }

    @Test(priority = 2)
    public void test2() throws InterruptedException{

        Thread.sleep(4000);
        WebElement l = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log in")));
        l.click();

        driver.findElement(By.xpath("//*[@id='loginusername']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id='logInModal']/div/div/div[3]/button[2]")).click();

        String text3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/div/div/ul/li[7]/a"))).getText();
        if(text3.equals("Welcome Testalpha")){
            System.out.println("The content is there");
        }
        else{
            System.out.println("The content is not there");
        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException{
        Thread.sleep(5000);
        driver.quit();
    }
}
