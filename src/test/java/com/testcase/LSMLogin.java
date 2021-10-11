package com.testcase;
import java.util.concurrent.TimeUnit;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.List;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.Keys;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
public class LSMLogin {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse-workspace\\SeliniumPrj\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//public static BaseDriver base;
		//driver.get("https://cear-qa.prevalent.ai/cear-workbench/admin-workbench/policy-dataset");
		driver.get("https://idp-lsmstage.prevalent.ai/auth/realms/Staging/protocol/openid-connect/auth?client_id=caparaizon-admin-workbench&redirect_uri=https%3A%2F%2Fcear-qa.prevalent.ai%2Fcear-workbench%2Fhome&state=a8b7fec8-43e6-46b3-8ab7-6687153a1786&response_mode=fragment&response_type=code&scope=openid&nonce=1936aa71-866b-49a7-8e89-128823192be5");
		//Thread.sleep(20000);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,60);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='kc-login']")));
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("lsm.dashboarduser@prevalent.ai");
		
		System.out.println("Username entry successfull");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Xib5fBOITuianzWPzWb9y3d9Jp3H5C");
		
		System.out.println("Password entry successfull");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		
		System.out.println("About to zoom out");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.8'");
		System.out.println("Zooming Out Done");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[3]/form/div/select")));
		System.out.println("Login Successfull.........!!");
		

		System.out.println("Insight workbench");
		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-basic")));
		System.out.println("trying to click");
		WebElement ele = driver.findElement(By.xpath("//*[@class='blue-btn dropdown-toggle btn']"));
		JavascriptExecutor executorhome = (JavascriptExecutor)driver; 
		executorhome.executeScript("arguments[0].click();", ele);
		System.out.println("Clicked");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
			int pixels=25;
			js.executeScript("scroll(0,"+pixels+")");
			String path = "target\\Home.jpg";
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,new File(path));
			System.out.println("Screenshot1 taken");
		   
			int pixels1=280;
			js.executeScript("scroll(0,"+pixels1+")");
			String path1 = "target\\Home1.jpg";
			File src1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src1,new File(path1));
			System.out.println("Screenshot2 taken");
			
			int pixels2=980;
			js.executeScript("scroll(0,"+pixels2+")");
			String path2 = "target\\Home2.jpg";
			File src2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src2,new File(path2));
			System.out.println("Screenshot3 taken");
			
			int pixels3=1580;
			js.executeScript("scroll(0,"+pixels3+")");
			String path3 = "target\\Home3.jpg";
			File src3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src3,new File(path3));
			System.out.println("Screenshot4 taken");
			
			int pixels4=2080;
			js.executeScript("scroll(0,"+pixels4+")");
			String path4 = "target\\Home4.jpg";
			File src4=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src4,new File(path4));
			System.out.println("Screenshot5 taken");
			
			
			
		Thread.sleep(1000);
		System.out.println("Selecting report");
		WebElement ele1 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[5]/div/div[2]/div/a[1]"));
		JavascriptExecutor executorhome1 = (JavascriptExecutor)driver; 
		executorhome1.executeScript("arguments[0].click();", ele1);
		
		Thread.sleep(5000);
		
		System.out.println("Report downloaded 1");
		
		  WebElement categoriesDropDown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[3]/form/div/select"));
          Select categories = new Select(categoriesDropDown);

          // 2. getting all options of menu

           java.util.List<WebElement> optionsList = categories.getOptions();
           System.out.println("The options list : ");
           for (WebElement option : optionsList) {
                    System.out.println(option.getText());
           }
           categories.selectByVisibleText("QA Jan dataset01 1616"); 

           
           System.out.println("Drop down selected");
           Thread.sleep(5000);
          
           WebDriverWait wait3 = new WebDriverWait(driver, 120);
   		wait3.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-basic")));
   		System.out.println("trying to click 1");
   		WebElement ele2 = driver.findElement(By.xpath("//*[@class='blue-btn dropdown-toggle btn']"));
   		JavascriptExecutor executorhome2 = (JavascriptExecutor)driver; 
   		executorhome2.executeScript("arguments[0].click();", ele2);
   		System.out.println("Clicked 1");
   		
   		
   		Thread.sleep(2000);
   		System.out.println("Selecting another report");
   		WebElement ele3 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[5]/div/div[2]/div/a[2]"));
   		JavascriptExecutor executorhome3 = (JavascriptExecutor)driver; 
   		executorhome3.executeScript("arguments[0].click();", ele3);

   	   		
   		Thread.sleep(10000);
   		
   		System.out.println("Report downloaded 2 ");
		driver.close();

	}
}
