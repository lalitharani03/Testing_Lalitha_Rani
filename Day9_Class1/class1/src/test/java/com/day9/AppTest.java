package com.day9;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class AppTest 
{ 
    WebDriverWait wait;
    WebDriver driver;
    XSSFWorkbook workbook;
    String loan,rate,years;
    ExtentReports reports;
    ExtentTest test;
    @BeforeTest
    public void beforeTest(){
        String path="E:\\software testing\\Day9_Class1\\class1\\src\\Reports\\report.html";
        reports=new ExtentReports();
        ExtentSparkReporter spark=new ExtentSparkReporter(path);
        reports.attachReporter(spark);
        spark.config().setDocumentTitle("Groww");
        spark.config().setTheme(Theme.DARK);
        test=reports.createTest("TestCase");
        test.log(Status.PASS,"WellDone");
    }
    @org.testng.annotations.BeforeMethod
    public void BeforeMethod() throws IOException{
        String paths="E:\\software testing\\Day9_Class1\\class1\\ExcelSheet\\Data.xlsx";
        FileInputStream fs=new FileInputStream(paths);
        workbook=new XSSFWorkbook(fs);
        XSSFSheet sheet=workbook.getSheetAt(0);
        loan = sheet.getRow(1).getCell(0).getNumericCellValue()+"";
        rate = sheet.getRow(1).getCell(1).getNumericCellValue()+"";
        years = sheet.getRow(1).getCell(2).getNumericCellValue()+""; 

        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://www.google.com");
        driver.navigate().to("https://groww.in");
    }
    @Test
    public void test1() throws IOException{
        driver.findElement(By.xpath("//*[@id='footer']/div/div[1]/div/div[1]/div[2]/div[3]/a[2]")).click();
        
        String text= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/h1"))).getText();
        if(text.equals("Calculators")){
            System.out.println("The Site Groww contains Calculators");
            test.log(Status.PASS, "The Site Groww contains Calculators");
        }
        else{
            System.out.println("The Site doesn't contains Calculators");
            test.log(Status.PASS, "The Site doesn't contains Calculators");
        }

        TakesScreenshot ts=(TakesScreenshot)driver;
        File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./Screenshots/groww.png"));


        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]/div/p[1]")));
        e.click();

        WebElement l=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div/input")));
        l.clear(); 
        l.sendKeys(loan);

        WebElement r= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div/input")));
        r.clear();
        r.sendKeys(rate);

        WebElement y=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/input")));
        y.clear();  
        y.sendKeys(years);

        
        String find =  driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if(find.equals("Your Amortization Details (Yearly/Monthly)")){
            System.out.println("Success");
            test.log(Status.PASS, "Success");
        }
        else{
            System.out.println("Failed");
            test.log(Status.PASS, "Failed");
        }
    }
    
    @AfterMethod
    public void afterMethod(){
        reports.flush();
    }
    @AfterTest
    public void afterTest() throws InterruptedException{
        Thread.sleep(4000);
        driver.quit();
    }
}
