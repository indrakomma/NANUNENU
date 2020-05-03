package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import pageobject.*;

public class actionelements extends basesetup{
public static String snappath;
	
	public static boolean isElementPresentByXpath(String xpath) throws InterruptedException
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			System.out.println("element is found");
			captureScreenshot1(xpath);
			test.addScreenCaptureFromPath(snappath, "dadsa");
		}
		catch(Throwable t)
		{
			test.log(Status.FAIL, "not able to find the element and reason---->"+t.getMessage());
			test.log(Status.FAIL, "not able to find the element and reason---->"+t.getClass());
		
			
			
			
			//Log.error("Element not Found -->"+t.getMessage());
			System.out.println(xpath+"element is not found");
			t.printStackTrace();
			return false;
		}
		return true;
	}
public static String captureScreenshot1(String xpath){
    	
		try{
			
			String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        //The below method will save the screen shot in d drive with name "screenshot.png"
			String name = scrFile.getName();
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\reports\\screenshots\\faa"+datename+".jpg"));
         //   snappath = "C:\\Users\\Lenovo\\Desktop\\indra\\Reports\\screenshots\\faa"+datename+".jpg";
            snappath= "C:\\Users\\Lenovo\\Desktop\\mars\\marsworkspace\\urike\\reports\\screenshots\\faa"+datename+".jpg";
		  
		}catch(Exception e){
		  System.out.println("Issue with snapshot capture");
		}
		return snappath;
	}
public static void clickButton(String ObjectxPath) throws Exception
{
	try
	{
		WebElement webButton = driver.findElement(By.xpath(ObjectxPath));
	    webButton.click();
		//webButton.sendKeys(Keys.ENTER);
	captureScreenshot1(ObjectxPath);
	test.addScreenCaptureFromPath(snappath, "clicked");
	}
	catch(Throwable t)
	{ 
		test.log(Status.FAIL, "not able click button"+t);
		t.printStackTrace();
		System.out.println(ObjectxPath+"element is not found");
		throw new Exception("Element Not Present");
	}
}
public static void RemovewaitForPageToLoad() {
	driver.manage().timeouts().implicitlyWait(Integer.parseInt("0"), TimeUnit.SECONDS);
}

public static void waitForPageToLoad() {
	driver.manage().timeouts().implicitlyWait(Integer.parseInt("90"), TimeUnit.SECONDS);
}
public void WaitUntilExist(String Element)
{
	RemovewaitForPageToLoad();
	int i=1;
	do
	{
		
		//System.out.println("loop "+i);
		try
		{
			driver.findElement(By.xpath(Element));
		//	System.out.println("Element found Exiting ");
			break;
		}
		catch(Throwable t)
		{
		//	System.out.println("Element not found");
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i=i+1;
		if (i==50)
		{			
			break;
		}
		
	}while(true);
	waitForPageToLoad();
	
}
public static void enterText(String ObjectxPath, String sValue,String Element_Name) throws Exception {
	Actions actions = new Actions(driver);
	try
	{
		WebElement inputText = driver.findElement(By.xpath(ObjectxPath));
		actions.moveToElement(inputText);
		actions.click();
		actions.sendKeys(sValue);
		actions.build().perform();
		captureScreenshot1(ObjectxPath);
		test.addScreenCaptureFromPath(snappath, "dadsa");
        test.pass(sValue+" is entered");
	//	Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
	}  catch(Throwable t)
	{ 
		test.log(Status.FAIL, "failed"+t);
		
		//Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	
}

	
}
