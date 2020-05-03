package testcases;

import java.io.IOException;
import java.sql.Driver;
import pageobject.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.basesetup;
import utils.xpaths;
public class testcase1 extends basesetup{
	
	
	
	@Test
	public void testcasenum1() throws Exception
	{
	  pageobject.login();
	 
	}

}
