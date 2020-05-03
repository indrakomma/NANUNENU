package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class basesetup2 {
public WebDriver driver;
public static String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//ExtentHtmlReporter reportinghtml;
public static ExtentReports repo;
//public static ExtentTest test;


@BeforeSuite
public void beforesuites()
{try
{
	ExtentHtmlReporter reportinghtml=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\html\\ExtentReportResults"+datename+".html");
	 ExtentReports repo=new ExtentReports();
	 repo.attachReporter(reportinghtml);
	System.out.println("beforesuits");

}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caught"); 
} 
}
@BeforeTest
public void beforetest()
{try
{
	//test=repo.createTest("testcase1");
	System.out.println("beforetest");


}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caught"); 
} 
}
@org.testng.annotations.Test
public void Test()
{try
{
	System.out.println("test");


}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caught"); 
} 
}

@AfterTest
public void aftertest()
{try
{
	System.out.println("after test");


}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caughtf"); 
} 
}


@AfterClass
public void afterclasses()
{try
{
	//driver.close();
	System.out.println("after class");


}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caught"); 
} 
}

@AfterSuite
public void aftersuites()
{try
{
	repo.flush();
	System.out.println("after suits");


}catch(NullPointerException e) 
{ 
    System.out.print(e+"NullPointerException Caught"); 
} 
}
}
