package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class basesetup {
public static WebDriver driver;
//ExtentHtmlReporter reportinghtml;
public static String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
public static ExtentHtmlReporter reportinghtml=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\html\\ExtentReportResults"+datename+".html");
public static ExtentReports repo=new ExtentReports();

//public static ExtentReports repo=null;
public static ExtentTest test;
//public static String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  @BeforeSuite
  public static void test1()
  {
	  try
	  {
	//   String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	   System.out.println(datename);
	//    ExtentHtmlReporter reportinghtml=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\reports\\html\\ExtentReportResults"+datename+".html");
	//	 ExtentReports repo=new ExtentReports();
		 repo.attachReporter(reportinghtml);
		 
		System.out.println(repo); 
	  System.out.println("extent reporting");
	  }
	  catch(NullPointerException e) 
      { 
		  
          System.out.print(e+"NullPointerException Caught"); 
      } 
	  
	  }

	@BeforeTest
	@Parameters({"browser","urls","rowids","classnames"})
	public static void initiate(String browser1,String url1,String rowid1,String classname1)
	{
		try
		{
			System.out.println(browser1+"----------"+url1+"----------"+rowid1+"----------"+classname1);
			System.out.println();
			System.out.println("--->"+repo); 
		 System.out.println("before test"); 
		 switch (browser1) {
			case "firefox":
				System.out.println("browser : " + browser1 + " Launching.....");
				
				System.setProperty("webdriver.gecko.driver","C://Users//Lenovo//Desktop//javaproject//drivers//geckodriver.exe");
				
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
			case "chrome":
				System.out.println("browser : " + browser1 + " Launching.....");
				
				System.setProperty("webdriver.chrome.driver","C://Users//Lenovo//Desktop//javaproject//drivers//chromedriver.exe");
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "ie":
				System.out.println("browser : " + browser1 +  " Launching.....");
				
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;
			case "edge":
				System.out.println("browser : " + browser1 +  " Launching.....");
				  System.setProperty("webdriver.edge.driver", "C://Users//Lenovo//Desktop//javaproject//drivers//MicrosoftWebDriver.exe");
				   driver=new EdgeDriver();
					driver.manage().window().maximize();
					break;
			default:
				System.out.println("browser : " + browser1 + " is invalid, Launching Firefox as browser of choice..");
				driver = new FirefoxDriver();
			}
		
		 /* System.setProperty("webdriver.gecko.driver","C://Users//Lenovo//Desktop//javaproject//drivers//geckodriver.exe");
		 driver=new FirefoxDriver();
	     driver.manage().window().maximize();
		*/
		test=repo.createTest("testcasename-->"+classname1);
		}
		catch(NullPointerException e) 
	      { 
	          System.out.print(e+"NullPointerException Caught"); 
	      } 
		   
		}
	@AfterTest
	public static void test3()
	{
		try
		{
			System.out.println("--->"+repo); 
		 System.out.println("close browser"); 
		 driver.close();
		}
		catch(NullPointerException e) 
	      { 
	          System.out.print(e+"NullPointerException Caught"); 
	      }
	}
	
	@AfterSuite
	public static void test4()
	{
		System.out.println("--->"+repo); 
		repo.flush();
		 System.out.println("flush"); 
		  
	}
	
	
}
