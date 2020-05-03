package pageobject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.relevantcodes.*;
import com.relevantcodes.extentreports.LogStatus;
import pageobject.*;
import utils.actionelements;
import utils.basesetup;
import utils.xpaths;

public class pageobject extends basesetup{
public static String snappath1;	
	@Test
	public static void login() throws Exception
	{
		
		try
		{
			System.out.println("<>"+driver);
			System.out.println("--->"+repo);
			System.out.println("+++"+test);
		 Thread.sleep(3000);
	   	driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		 actionelements.isElementPresentByXpath(xpaths.username);		
		 driver.findElement(By.xpath(xpaths.username)).click();	
           
	  	 driver.findElement(By.xpath(xpaths.username)).sendKeys("sunil");
	  
	  	 actionelements.isElementPresentByXpath(xpaths.password);
		 driver.findElement(By.xpath(xpaths.password)).click();	
		 test.log(Status.PASS, "password entered");
		 driver.findElement(By.xpath(xpaths.password)).sendKeys("sunil");
		 actionelements.isElementPresentByXpath(xpaths.username);
		
		 driver.findElement(By.xpath(xpaths.submit)).click();
		 actionelements.clickButton(xpaths.submit);
		 
		 System.out.println("driver---->"+driver);
		}
		catch(NullPointerException e) 
	      { 
	          System.out.print(e+"NullPointerException Caught"); 
	      }
		
	}
	@Test
	public static void tc3method() throws Exception
	{
		
		try
		{
			System.out.println("testcase3");
			
		}
		catch(NullPointerException e) 
	      { 
	          System.out.print(e+"NullPointerException Caught"); 
	      }
		
	}
	@Test
	public static void tc4method() throws Exception
	{
		
		try
		{
			System.out.println("testcase4");
			driver.get("http://newtours.demoaut.com/mercurywelcome.php");
			 		
			 actionelements.isElementPresentByXpath(xpaths.username);		
			 actionelements.enterText(xpaths.username, "sunil", "entering username");
			 actionelements.isElementPresentByXpath("khjjh");		
	//		 actionelements.enterText("saaaaaa", "sunil", "entering pass");
		}
		catch(NullPointerException e)	      { 
			  test.log(Status.FAIL, "--->"+e);
	          System.out.print(e+" NullPointerException Caught"); 
	      }
		
	}
}
