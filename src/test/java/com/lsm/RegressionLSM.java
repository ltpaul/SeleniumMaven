package com.lsm;


import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class RegressionLSM {
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
//		WebElement ele = driver.findElement(By.xpath("//*[@class='blue-btn dropdown-toggle btn']"));
//		JavascriptExecutor executorhome = (JavascriptExecutor)driver; 
//		executorhome.executeScript("arguments[0].click();", ele);
//		System.out.println("Clicked");
		Thread.sleep(2000);
		WebElement categoriesDropDown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div/div/div[3]/form/div/select"));
        Select categories_es = new Select(categoriesDropDown);
        System.out.println("Clicked");
        categories_es.selectByVisibleText("QA dataModel set 1653");
        System.out.println("Drop down selected");
        
        //Thread.sleep(3000);
		Thread.sleep(10000);
		
		//Executive Summary page --default
		JavascriptExecutor jses= (JavascriptExecutor) driver;
		
		ArrayList<Integer> pixels=new ArrayList<Integer>(); //Creating arraylist    
		pixels.add(15);
		pixels.add(280);
		pixels.add(895);
		pixels.add(1550);
		pixels.add(2080);
		pixels.add(2680);
		//int len = pixels.size();
		int k =1;
			for(int pixel:pixels)
			{	
				jses.executeScript("scroll(0,"+pixel+")");
				String path_es = "target\\ExecutiveSummary_"+k+".jpg";
				File src_es=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_es,new File(path_es));
				System.out.println("ExecutiveSummary_"+k+" taken");
				k++;
			}
			Thread.sleep(2000);
			jses.executeScript("scroll(0,15)");
						
			Thread.sleep(2000);
			//Result-comparison page
			WebElement rs_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/ul/li[2]/a"));
			JavascriptExecutor executorhome = (JavascriptExecutor)driver; 
			executorhome.executeScript("arguments[0].click();", rs_ele);
			System.out.println("Clicked1");
			
			Thread.sleep(2000);
			WebElement rds1DropDown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[1]/div/div[2]/form/div/select"));
	        Select rds1_es = new Select(rds1DropDown);
	        System.out.println("Clicked");
	        rds1_es.selectByVisibleText("QA Old config DS 1652");
	        System.out.println("rds1 Drop down selected");
	        Thread.sleep(11000);
	        
	    	WebElement rds2DropDown = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div/div[2]/form/div/select"));
	        Select rds2_es = new Select(rds2DropDown);
	        System.out.println("Clicked");
	        rds2_es.selectByVisibleText("QA dataModel set 1653");
	        System.out.println("rds2 Drop down selected");
	        Thread.sleep(15000);
	        
	      
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			
			ArrayList<Integer> rspixels=new ArrayList<Integer>(); //Creating arraylist    
			rspixels.add(15);
			rspixels.add(280);
			rspixels.add(770);
			rspixels.add(950);
			rspixels.add(1570);
			rspixels.add(2250);
			rspixels.add(2900);
			rspixels.add(3550);

	        k++;
			for(int pixel:rspixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_rs = "target\\Result-comparison_"+k+".jpg";
				File src_rs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_rs,new File(path_rs));
				System.out.println("Result-comparison_"+k+" taken");
				k++;
	     	}
			js.executeScript("scroll(0,15)");
			k++;
			//Front sheet page
	        WebElement fs_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/ul/li[5]/a"));
			JavascriptExecutor executorhome_fs = (JavascriptExecutor)driver; 
			executorhome_fs.executeScript("arguments[0].click();", fs_ele);
			System.out.println("Clicked2");
			
			Thread.sleep(3000);
			WebElement rdsDropDownfs = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/form/div/select"));
	        Select rds_es = new Select(rdsDropDownfs);
	        System.out.println("Clickedfs");
	        rds_es.selectByVisibleText("QA dataModel set 1653");
	        System.out.println("rds Drop down fs selected");
	        Thread.sleep(3000);
	        //int k=1;
	        js.executeScript("scroll(0,15)");
			String path_fs = "target\\Frontsheet_Summary_"+k+".jpg";
			File src_fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src_fs,new File(path_fs));
			System.out.println("Frontsheet_Summary_"+k+" taken");
        //Commented
//			Thread.sleep(4000);
//			WebElement ele_fsall = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tabpane-Summary']/div[1]/div[1]/div[3]/div/button"));
//			JavascriptExecutor executorfs = (JavascriptExecutor)driver; 
//			executorfs.executeScript("arguments[0].click();", ele_fsall);
//			
//			 WebElement categoriesDropDown_fs = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tabpane-Summary']/div[1]/div[1]/div[3]/div/button"));
//	          Select categories_fs = new Select(categoriesDropDown_fs);
//
//	          java.util.List<WebElement> optionsList = categories_fs.getOptions();
//	          System.out.println("The options list : ");
//	           for (WebElement option : optionsList) {
//	                    System.out.println(option.getText());
//	           }
//	        System.out.println("Clickedfs");
//						
//	       
//	        System.out.println("rds Drop down fs all selected");
			
	        Thread.sleep(3000);
	        k++;
	        js.executeScript("scroll(0,15)");
			String path_fss = "target\\Frontsheet_Summary_"+k+".jpg";
			File src_fss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src_fss,new File(path_fss));
			System.out.println("Frontsheet_Summary_"+k+" taken");
			
			//Split of Affirmation
			WebElement ele_afall = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Split of Affirmation']"));
			JavascriptExecutor executoraf = (JavascriptExecutor)driver; 
			executoraf.executeScript("arguments[0].click();", ele_afall);
			
			Thread.sleep(3000);
	        k++;
	        js.executeScript("scroll(0,15)");
			String path_afs = "target\\Frontsheet_Split_Affirmation_"+k+".jpg";
			File src_afs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src_afs,new File(path_afs));
			System.out.println("Frontsheet_Split_Affirmation_"+k+" taken");
			
			//Split by Industry
			WebElement ele_indall = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Split by Industry']"));
			JavascriptExecutor executorind = (JavascriptExecutor)driver; 
			executorind.executeScript("arguments[0].click();", ele_indall);
			
			Thread.sleep(3000);
	        k++;
	        js.executeScript("scroll(0,15)");
			String path_inds = "target\\Frontsheet_Split_by_Industry_"+k+".jpg";
			File src_inds=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src_inds,new File(path_inds));
			System.out.println("Frontsheet_Split_by_Industry_"+k+" taken");
			
			
			//RDS Details
			WebElement ele_rdsdall = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-RDS Details']"));
			JavascriptExecutor executorrdsd = (JavascriptExecutor)driver; 
			executorrdsd.executeScript("arguments[0].click();", ele_rdsdall);
			
			Thread.sleep(3000);
	        k++;
	        js.executeScript("scroll(0,15)");
			String path_rdsd = "target\\Frontsheet_RDS_Details_"+k+".jpg";
			File src_rdsd=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src_rdsd,new File(path_rdsd));
			System.out.println("Frontsheet_RDS_Details_"+k+" taken");
			
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
			
			//What if Results  
			
			WebElement wtr_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/ul/li[2]/a"));
			JavascriptExecutor executorhome_wtr = (JavascriptExecutor)driver; 
			executorhome_wtr.executeScript("arguments[0].click();", wtr_ele);
			System.out.println("WRTClicked2");
			
			Thread.sleep(2000);
			WebElement rdsDropDownwtr = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div[1]/div/div[2]/form/div/select"));
	        Select rds_wtr = new Select(rdsDropDownwtr);
	        System.out.println("WTRClickedfs");
	        rds_wtr.selectByVisibleText("QA dataModel set 1653");
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
	        WebElement mySelectElm = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div[2]/div/div[2]/form/div/select"));
	        Select mySelect= new Select(mySelectElm);
	        List<WebElement> options = mySelect.getOptions();
	        for (WebElement option : options) {
	            System.out.println(option.getText());
	            System.out.println(options.size());
	      
	            option.click();
	            Thread.sleep(4000);
	        
	        for(int pixel:wtrpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wtr = "target\\What_If_Results_"+k+".jpg";
				File src_wtr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wtr,new File(path_wtr));
				System.out.println("What_If_Results_"+k+" taken");

				Thread.sleep(2000);
				if (pixel == 1800) {
					WebElement ele_br = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Branch']"));
					JavascriptExecutor executorbr = (JavascriptExecutor)driver; 
					executorbr.executeScript("arguments[0].click();", ele_br);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_br = "target\\What_If_Results_"+k+".jpg";
					File src_br=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_br,new File(path_br));
					System.out.println("What_If_Results_"+k+" taken");
					
					WebElement ele_geo = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Geography']"));
					JavascriptExecutor executorgeo = (JavascriptExecutor)driver; 
					executorgeo.executeScript("arguments[0].click();", ele_geo);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_geo = "target\\What_If_Results_"+k+".jpg";
					File src_geo=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_geo,new File(path_geo));
					System.out.println("What_If_Results_"+k+" taken");
					
					WebElement ele_pl = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Pillar']"));
					JavascriptExecutor executorpl = (JavascriptExecutor)driver; 
					executorpl.executeScript("arguments[0].click();", ele_pl);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_pl = "target\\What_If_Results_"+k+".jpg";
					File src_pl=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_pl,new File(path_pl));
					System.out.println("What_If_Results_"+k+" taken");
					
					WebElement ele_ind = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Industry']"));
					JavascriptExecutor executorinds = (JavascriptExecutor)driver; 
					executorinds.executeScript("arguments[0].click();", ele_ind);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_ind = "target\\What_If_Results_"+k+".jpg";
					File src_ind=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_ind,new File(path_ind));
					System.out.println("What_If_Results_"+k+" taken");
					k++;
					Thread.sleep(2000);
				}
				else if (pixel == 3550) {
					
					WebElement ele_brcnt = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Tier-2 Contribution']"));
					JavascriptExecutor executorbrcnt = (JavascriptExecutor)driver; 
					executorbrcnt.executeScript("arguments[0].click();", ele_brcnt);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_cnt = "target\\What_If_Results_"+k+".jpg";
					File src_cnt=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_cnt,new File(path_cnt));
					System.out.println("What_If_Results_"+k+" taken");
					
					WebElement ele_non = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-None']"));
					JavascriptExecutor executornon = (JavascriptExecutor)driver; 
					executornon.executeScript("arguments[0].click();", ele_non);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_non = "target\\What_If_Results_"+k+".jpg";
					File src_non=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_non,new File(path_non));
					System.out.println("What_If_Results_"+k+" taken");
					k++;
					Thread.sleep(2000);
					
				}
				else {
					k++;
				}
				
				Thread.sleep(2000);
	        }
	     }
	        
	        //What if Comparison
			
			WebElement wtc_ele = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/ul/li[3]/a"));
			JavascriptExecutor executorhome_wtc = (JavascriptExecutor)driver; 
			executorhome_wtc.executeScript("arguments[0].click();", wtc_ele);
			System.out.println("WTCTClicked2");
			
			Thread.sleep(2000);
			WebElement rdsDropDownwtc = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[1]/div[1]/div/div[2]/form/div/select"));
	        Select rds_wtc = new Select(rdsDropDownwtc);
	        System.out.println("WTCClickedfs");
	        rds_wtc.selectByVisibleText("QA dataModel set 1653");
	        System.out.println("WTC rds Drop down fs selected");
	        Thread.sleep(9000);
	        
	        Thread.sleep(2000);
			WebElement rdsDropDownwtcsc1 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[1]/div/div[2]/form/div/select"));
	        Select rds_wtcsc1 = new Select(rdsDropDownwtcsc1);
	        System.out.println("WTCSC1 Clickedfs");
	        rds_wtcsc1.selectByVisibleText("jan sc1 1.1");
	        System.out.println("WTC SC1 rds Drop down fs selected");
	        Thread.sleep(6000);
	        
	        Thread.sleep(2000);
			WebElement rdsDropDownwtcsc2 = driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/form/div/select"));
	        Select rds_wtcscsc2 = new Select(rdsDropDownwtcsc2);
	        System.out.println("WTCSC2 Clickedfs");
	        rds_wtcscsc2.selectByVisibleText("jan sc1 1");
	        System.out.println("WTC SC2 rds Drop down fs selected");
	        Thread.sleep(6000);
	        
			ArrayList<Integer> wtcscpixels=new ArrayList<Integer>(); //Creating arraylist    
			wtcscpixels.add(15); //6
			wtcscpixels.add(280);//7
			wtcscpixels.add(770);//8
			wtcscpixels.add(1150);//9
			wtcscpixels.add(1520);//10
			wtcscpixels.add(2170);//11
			wtcscpixels.add(2800);//12
			wtcscpixels.add(3550);//13

	        k++;
        
	        for(int pixel:wtcscpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wtrsc = "target\\What_If_Comparison_"+k+".jpg";
				File src_wtrsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wtrsc,new File(path_wtrsc));
				System.out.println("What_If_Comparison_"+k+" taken");
				Thread.sleep(2000);
				if (pixel == 1520) {
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
	        
	        //Exclusion Effectiveness
			
			WebElement wtc_elexc = driver.findElement(By.xpath("//*[@id='root']/div[2]/ul/li[3]/a"));
			JavascriptExecutor executorhome_wtcxc = (JavascriptExecutor)driver; 
			executorhome_wtcxc.executeScript("arguments[0].click();", wtc_elexc);
			System.out.println("EEClicked2");
			
			Thread.sleep(2000);
			WebElement rdsDropDownwtcxc = driver.findElement(By.xpath("//*[@id='root']/div[2]/div/div[1]/div[2]/div/div[2]/form/div/select"));
	        Select rds_wtcxc = new Select(rdsDropDownwtcxc);
	        System.out.println("EEClickedfs");
	        rds_wtcxc.selectByVisibleText("QA dataModel set 1653");
	        System.out.println("EE rds Drop down fs selected");
	        Thread.sleep(9000);
	      
	        
	                
			ArrayList<Integer> wtcscpixelsxc=new ArrayList<Integer>(); //Creating arraylist    
			wtcscpixelsxc.add(15); //6
			wtcscpixelsxc.add(380);//7
			//wtcscpixelsxc.add(770);//8
			wtcscpixelsxc.add(1040);//9
			wtcscpixelsxc.add(1690);//10
			wtcscpixelsxc.add(2290);//11
			wtcscpixelsxc.add(2820);//12
			wtcscpixelsxc.add(3550);//13

	        k++;
        
	        for(int pixel:wtcscpixels)
			{	
				js.executeScript("scroll(0,"+pixel+")");
				String path_wtrscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
				File src_wtrscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(src_wtrscxc,new File(path_wtrscxc));
				System.out.println("Exclusion_Effectiveness_"+k+" taken");

				Thread.sleep(2000);
				
				if (pixel == 15) {
					k++;
					WebElement ee_elexc = driver.findElement(By.xpath("//*[@id='root']/div[2]/button"));
					JavascriptExecutor executorhome_eexc = (JavascriptExecutor)driver; 
					executorhome_eexc.executeScript("arguments[0].click();", ee_elexc);
					System.out.println("EE Clicked2");
					
					js.executeScript("scroll(0,"+pixel+")");
					Thread.sleep(2000);
					String path_wtrfacxc = "target\\Exclusion_Effectiveness_Factor"+k+".jpg";
					File src_wtrscfacxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_wtrscfacxc,new File(path_wtrfacxc));
					System.out.println("Exclusion_Effectiveness__Factor"+k+" taken");
					
					Thread.sleep(2000);
				}
				else if (pixel == 1690) {
					WebElement ele_brscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Branch']"));
					JavascriptExecutor executorbrscxc = (JavascriptExecutor)driver; 
					executorbrscxc.executeScript("arguments[0].click();", ele_brscxc);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_brscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_brscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_brscxc,new File(path_brscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					
					WebElement ele_geoscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Geography']"));
					JavascriptExecutor executorgeoscxc = (JavascriptExecutor)driver; 
					executorgeoscxc.executeScript("arguments[0].click();", ele_geoscxc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_geoscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_geoscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_geoscxc,new File(path_geoscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					
					WebElement ele_plscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Pillar']"));
					JavascriptExecutor executorplscxc = (JavascriptExecutor)driver; 
					executorplscxc.executeScript("arguments[0].click();", ele_plscxc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_plscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_plscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_plscxc,new File(path_plscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					
					WebElement ele_indscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Industry']"));
					JavascriptExecutor executorindscxc = (JavascriptExecutor)driver; 
					executorindscxc.executeScript("arguments[0].click();", ele_indscxc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_indscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_indscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_indscxc,new File(path_indscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					k++;
					Thread.sleep(2000);
				}
				else if (pixel == 3550) {
					
					WebElement ele_brcntscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-Tier-2 Contribution']"));
					JavascriptExecutor executorbrcntscxc = (JavascriptExecutor)driver; 
					executorbrcntscxc.executeScript("arguments[0].click();", ele_brcntscxc);
					
					Thread.sleep(2000);
					
					k++;
			        js.executeScript("scroll(0,"+pixel+")");
					String path_cntscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_cntscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_cntscxc,new File(path_cntscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					
					WebElement ele_nonscxc = driver.findElement(By.xpath("//*[@id='controlled-tab-example-tab-None']"));
					JavascriptExecutor executornonscxc = (JavascriptExecutor)driver; 
					executornonscxc.executeScript("arguments[0].click();", ele_nonscxc);
					
					Thread.sleep(2000);
					k++;
			        //js.executeScript("scroll(0,"+pixel+")");
					String path_nonscxc = "target\\Exclusion_Effectiveness_"+k+".jpg";
					File src_nonscxc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileHandler.copy(src_nonscxc,new File(path_nonscxc));
					System.out.println("Exclusion_Effectiveness_"+k+" taken");
					k++;
					Thread.sleep(2000);
					
				}
				else {
					k++;
				}
			
	        Thread.sleep(2000);
	        
	        }
	        System.out.println("@@@@@@@@@@@@@@............Completed.........@@@@@@@@@@@@@@@@@@@@@@@@");
	        driver.close();
			
	}
}