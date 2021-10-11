package com.lsm;

//import java.util.List;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class List {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException{
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse-workspace\\Selinum_Maven\\chromedriver.exe");
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
		
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("lsm.poweruser@prevalent.ai");
		
		System.out.println("Username entry successfull");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("sOfaU2iykoKQtv2vygd1d90MdrnLwC");
		
		System.out.println("Password entry successfull");
		//Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='kc-login']")).click();
		
//		System.out.println("About to zoom out");
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("document.body.style.zoom = '0.8'");
//		System.out.println("Zooming Out Done");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div/div[2]/div/div/div[1]/table/thead/tr/th[6]")));
		System.out.println("Login Successfull.........!!");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='/cear-workbench/insight-workbench/executive-summary']")).click();
		System.out.println("Insight workbench");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[3]/form/div/select")));
		System.out.println("Element found.........!!");
		WebDriverWait wait_es = new WebDriverWait(driver, 60);
		wait_es.until(ExpectedConditions.elementToBeClickable(By.id("dropdown-basic")));
		System.out.println("Waiting for element over");
		Thread.sleep(3000);
		
		int k =1;
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 
		//What-If Scenario page
	        WebElement wt_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/ul/li[4]/a"));
			JavascriptExecutor executorhome_wt = (JavascriptExecutor)driver; 
			executorhome_wt.executeScript("arguments[0].click();", wt_ele);
			System.out.println("WTClicked2");
			
			Thread.sleep(3000);
			WebElement rdsDropDownwt = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div/div/div[2]/form/div/select"));
	        Select rds_wt = new Select(rdsDropDownwt);
	        System.out.println("WTClickedfs");
	        rds_wt.selectByVisibleText("QA Jan Sprint9 1644");
	        System.out.println("WT rds Drop down fs selected");
	        Thread.sleep(3000);

			ArrayList<Integer> wtpixels=new ArrayList<Integer>(); //Creating arraylist    
			wtpixels.add(15);
			wtpixels.add(280);
			wtpixels.add(770);
			

	        k++;
			for(int pixel:wtpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wt = "target\\What_If_scenario_"+k+".jpg";
				File src_wt=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wt,new File(path_wt));
				System.out.println("What_If_scenario_"+k+" taken");
				k++;
	     	}
		//What if Results  
			
			WebElement wtr_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/ul/li[2]/a"));
			JavascriptExecutor executorhome_wtr = (JavascriptExecutor)driver; 
			executorhome_wtr.executeScript("arguments[0].click();", wtr_ele);
			System.out.println("WRTClicked2");
			
			Thread.sleep(2000);
			WebElement rdsDropDownwtr = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div[1]/div/div[2]/form/div/select"));
	        Select rds_wtr = new Select(rdsDropDownwtr);
	        System.out.println("WTRClickedfs");
	        rds_wtr.selectByVisibleText("QA Jan Sprint9 1644");
	        System.out.println("WTR rds Drop down fs selected");
	        Thread.sleep(9000);

			ArrayList<Integer> wtrpixels=new ArrayList<Integer>(); //Creating arraylist    
			wtrpixels.add(15); //6
			wtrpixels.add(280);
			wtrpixels.add(770);
			wtrpixels.add(1150);
			wtrpixels.add(1800);
			wtrpixels.add(2370);
			wtrpixels.add(2900);
			wtrpixels.add(3550);

	        k++;
			for(int pixel:wtrpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wtr = "target\\What_If_Results_"+k+".jpg";
				File src_wtr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wtr,new File(path_wtr));
				System.out.println("What_If_Results_"+k+" taken");
				
				if(pixel == 1150) {
			//	WebElement rds_dropdown=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[4]/div/div/div/div[1]/div[2]/div/div[1]/div/div/button"));
				 
					WebElement mySelectElm = driver.findElement(By.id("mySelectID")); 
					Select mySelect= new Select(mySelectElm);
					//List<WebElement> options = mySelect.getOptions();
				//	List<WebElement> linkElements = driver.findElements(By.tagName("a"));
//					for (WebElement option : options) {
//					    System.out.println(option.getText()); //Prints "Option", followed by "Not Option"
//					}
				k++;
	     	}
		
			}	
}
	
}