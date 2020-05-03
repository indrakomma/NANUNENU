package pageobject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.LogStatus;
import pageobject.pageobject;
import utils.xpaths;

public class extentreport {
public static WebDriver driver;
//static String snappath;
	
	@Test
	public void rep() throws IOException
	{
		 
		 String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 	 ExtentHtmlReporter reportinghtml=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\html\\ExtentReportResults.html");
		 ExtentReports repo=new ExtentReports();
		 repo.attachReporter(reportinghtml);
		 
	
		 System.setProperty("webdriver.gecko.driver","C://Users//Lenovo//Desktop//javaproject//drivers//geckodriver.exe");
		 driver=new FirefoxDriver();

		 
		 ExtentTest test=repo.createTest("testcase1");
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		 driver.findElement(By.xpath(xpaths.username)).click();	
		 captureScreenshot();
		 
		 test.log(Status.PASS, "username entered");
		 test.addScreenCaptureFromPath(captureScreenshot(), "haha");
		 driver.findElement(By.xpath(xpaths.username)).sendKeys("sunil");
		 driver.findElement(By.xpath(xpaths.password)).click();	
		 test.log(Status.PASS, "password entered");
		 driver.findElement(By.xpath(xpaths.password)).sendKeys("sunil");
		 captureScreenshot();
		 
		 
		 driver.findElement(By.xpath(xpaths.submit)).click();
		 driver.close();
		 
		 repo.flush();
		
	}
    
	public static String screenshot() throws IOException
	{
		System.out.println("asasa");
		 String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      String destination="C:\\Users\\Lenovo\\Desktop\\indra\\Reports\\screenshots\\faa"+datename+".jpg";
      File finaldestination=new File(destination);
    //  FileUtils.copyFile(scrFile, new File("C:\\Users\\Lenovo\\Desktop\\indra\\Reports\\screenshots\\faa"+datename+".jpg"));
		FileUtils.copyDirectory(scrFile, finaldestination);
		return destination;
		
	}
    public static String captureScreenshot(){
    	
		try{
			
			String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			String name = scrFile.getName();
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\reports\\screenshots\\faa"+datename+".jpg"));
         //   snappath = "C:\\Users\\Lenovo\\Desktop\\indra\\Reports\\screenshots\\faa"+datename+".jpg";
             pageobject.snappath1 = "C:\\Users\\Lenovo\\Desktop\\mars\\marsworkspace\\urike\\reports\\screenshots\\faa"+datename+".jpg";
		  
		}catch(Exception e){
		  System.out.println("Issue with snapshot capture");
		}
		return pageobject.snappath1;
	}
    public static String get_snappath(){
    	return pageobject.snappath1;
    }
	
	
}
