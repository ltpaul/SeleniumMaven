package com.lsm;



import java.util.List;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

public class Test {

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
	        rds_wt.selectByVisibleText("QA dataModel set 1653");
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

			//Exclusion Effectiveness
			
			WebElement wtc_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/ul/li[3]/a"));
			JavascriptExecutor executorhome_wtc = (JavascriptExecutor)driver; 
			executorhome_wtc.executeScript("arguments[0].click();", wtc_ele);
			System.out.println("EEClicked2");
			
			Thread.sleep(2000);
			WebElement rdsDropDownwtc = driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[1]/div[2]/div/div[2]/form/div/select"));
	        Select rds_wtc = new Select(rdsDropDownwtc);
	        System.out.println("EEClickedfs");
	        rds_wtc.selectByVisibleText("QA dataModel set 1653");
	        System.out.println("EE rds Drop down fs selected");
	        Thread.sleep(9000);
	      
	        
	                
			ArrayList<Integer> wtcscpixels=new ArrayList<Integer>(); //Creating arraylist    
			wtcscpixels.add(15); //6
			wtcscpixels.add(380);//7
			//wtcscpixels.add(770);//8
			wtcscpixels.add(1060);//9
			wtcscpixels.add(1690);//10
			wtcscpixels.add(2290);//11
			wtcscpixels.add(2820);//12
			wtcscpixels.add(3550);//13

	        k++;
        
	        for(int pixel:wtcscpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wtrsc = "target\\Exclusion_Effectiveness_"+k+".jpg";
				File src_wtrsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wtrsc,new File(path_wtrsc));
				System.out.println("Exclusion_Effectiveness_"+k+" taken");

				Thread.sleep(2000);
				
				if (pixel == 15) {
					k++;
					WebElement ee_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/button"));
					JavascriptExecutor executorhome_ee = (JavascriptExecutor)driver; 
					executorhome_ee.executeScript("arguments[0].click();", ee_ele);
					System.out.println("EE Clicked2");
					
					js.executeScript("scroll(0,"+pixel+")");
					Thread.sleep(2000);
					String path_wtrfac = "target\\Exclusion_Effectiveness_Factor"+k+".jpg";
					File src_wtrscfac=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_wtrscfac,new File(path_wtrfac));
					System.out.println("Exclusion_Effectiveness__Factor"+k+" taken");
					
					Thread.sleep(2000);
				}
				else if (pixel == 1690) {
					WebElement ele_brsc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Branch']"));
					JavascriptExecutor executorbrsc = (JavascriptExecutor)driver; 
					executorbrsc.executeScript("arguments[0].click();", ele_brsc);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_brsc = "target\\What_If_Comparison_"+k+".jpg";
					File src_brsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_brsc,new File(path_brsc));
					System.out.println("What_If_Comparison_"+k+" taken");
					
					WebElement ele_geosc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Geography']"));
					JavascriptExecutor executorgeosc = (JavascriptExecutor)driver; 
					executorgeosc.executeScript("arguments[0].click();", ele_geosc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_geosc = "target\\What_If_Comparison_"+k+".jpg";
					File src_geosc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_geosc,new File(path_geosc));
					System.out.println("What_If_Comparison_"+k+" taken");
					
					WebElement ele_plsc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Pillar']"));
					JavascriptExecutor executorplsc = (JavascriptExecutor)driver; 
					executorplsc.executeScript("arguments[0].click();", ele_plsc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_plsc = "target\\What_If_Comparison_"+k+".jpg";
					File src_plsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_plsc,new File(path_plsc));
					System.out.println("What_If_Comparison_"+k+" taken");
					
					WebElement ele_indsc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Industry']"));
					JavascriptExecutor executorindsc = (JavascriptExecutor)driver; 
					executorindsc.executeScript("arguments[0].click();", ele_indsc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_indsc = "target\\What_If_Comparison_"+k+".jpg";
					File src_indsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_indsc,new File(path_indsc));
					System.out.println("What_If_Comparison_"+k+" taken");
					k++;
					Thread.sleep(2000);
				}
//				else if (pixel == 2370) {
//					pixel = 2370;
//					WebElement ele_brri = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Branch']"));
//					JavascriptExecutor executorbrri = (JavascriptExecutor)driver; 
//					executorbrri.executeScript("arguments[0].click();", ele_brri);
//					
//					Thread.sleep(2000);
//					
//					k++;
//			        js.executeScript("scroll(0,"+pixel+")");
//					String path_brri = "target\\What_If_Results_"+k+".jpg";
//					File src_brri=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					FileHandler.copy(src_brri,new File(path_brri));
//					System.out.println("What_If_Results_"+k+" taken");
//					
//					WebElement ele_geori = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Geography']"));
//					JavascriptExecutor executorgeori = (JavascriptExecutor)driver; 
//					executorgeori.executeScript("arguments[0].click();", ele_geori);
//					
//					Thread.sleep(2000);
//					k++;
//			        js.executeScript("scroll(0,"+pixel+")");
//					String path_geori = "target\\What_If_Results_"+k+".jpg";
//					File src_geori=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					FileHandler.copy(src_geori,new File(path_geori));
//					System.out.println("What_If_Results_"+k+" taken");
//					
//					WebElement ele_plri = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Pillar']"));
//					JavascriptExecutor executorplri = (JavascriptExecutor)driver; 
//					executorplri.executeScript("arguments[0].click();", ele_plri);
//					
//					Thread.sleep(2000);
//					k++;
//			        js.executeScript("scroll(0,"+pixel+")");
//					String path_plri = "target\\What_If_Results_"+k+".jpg";
//					File src_plri=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					FileHandler.copy(src_plri,new File(path_plri));
//					System.out.println("What_If_Results_"+k+" taken");
//					
//					WebElement ele_indri = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Industry']"));
//					JavascriptExecutor executorindri = (JavascriptExecutor)driver; 
//					executorindri.executeScript("arguments[0].click();", ele_indri);
//					
//					Thread.sleep(2000);
//					k++;
//			        js.executeScript("scroll(0,"+pixel+")");
//					String path_indri = "target\\What_If_Results_"+k+".jpg";
//					File src_indri=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//					FileHandler.copy(src_indri,new File(path_indri));
//					System.out.println("What_If_Results_"+k+" taken");
//					k++;
//					Thread.sleep(2000);
//				}
				
				else if (pixel == 3550) {
					
					WebElement ele_brcntsc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Tier-2 Contribution']"));
					JavascriptExecutor executorbrcntsc = (JavascriptExecutor)driver; 
					executorbrcntsc.executeScript("arguments[0].click();", ele_brcntsc);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_cntsc = "target\\What_If_Comparison_"+k+".jpg";
					File src_cntsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_cntsc,new File(path_cntsc));
					System.out.println("What_If_Comparison_"+k+" taken");
					
					WebElement ele_nonsc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-None']"));
					JavascriptExecutor executornonsc = (JavascriptExecutor)driver; 
					executornonsc.executeScript("arguments[0].click();", ele_nonsc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_nonsc = "target\\What_If_Comparison_"+k+".jpg";
					File src_nonsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_nonsc,new File(path_nonsc));
					System.out.println("What_If_Comparison_"+k+" taken");
					k++;
					Thread.sleep(2000);
					
				}
				else {
					k++;
				}
			
	        Thread.sleep(2000);
	        
	        }
	        System.out.println("@@@@@@@@@@@@@@............Finish Line.........@@@@@@@@@@@@@@@@@@@@@@@@");
	        
	}
	
}
