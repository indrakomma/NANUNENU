package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class excelhandling {
  

public ArrayList<String> browsers = new ArrayList<String>(); 
public ArrayList<String> testcases = new ArrayList<String>();
public ArrayList<String> urls = new ArrayList<String>();
public ArrayList<Double> tcnums = new ArrayList<Double>();
public ArrayList<String> runs = new ArrayList<String>();
	@Test(priority=1)
	public void collectingdata() throws IOException
	{
		try{
			
			FileInputStream input=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\mars\\marsworkspace\\urike\\data.xlsx");
		//    HSSFWorkbook BOOK=new HSSFWorkbook(input);
		//    HSSFSheet sheet1=BOOK.getSheet("Sheet1");
			XSSFWorkbook BOOK=new XSSFWorkbook(input);
			XSSFSheet sheet1=BOOK.getSheet("Sheet1");
			int totaltescases=sheet1.getLastRowNum();
			System.out.println("Total testcases :"+totaltescases);
			double s=sheet1.getRow(1).getCell(0).getNumericCellValue();
			String s1=sheet1.getRow(0).getCell(0).getStringCellValue();
			System.out.println(s+s1);
			for (int i = 1; i <=totaltescases; i++) {
				String Yo=sheet1.getRow(i).getCell(4).getStringCellValue();
				System.out.println(Yo);
				if(Yo.contains("Y"))
				{
					
					String browser=sheet1.getRow(i).getCell(2).getStringCellValue();
					String testcase=sheet1.getRow(i).getCell(1).getStringCellValue();
					String url=sheet1.getRow(i).getCell(3).getStringCellValue();
					double tcnum=sheet1.getRow(i).getCell(0).getNumericCellValue();
					String run=sheet1.getRow(i).getCell(4).getStringCellValue();
					System.out.println(tcnum+" "+testcase+" "+browser+" "+url+" "+run);
				    browsers.add(browser);
				    testcases.add(testcase);
				    tcnums.add(tcnum);
				    urls.add(url);
				    runs.add(run);
				    
				    
				}
									
			}
			System.out.println("-->"+browsers+"--"+testcases+""+tcnums+""+urls+" ");

			
			
		}catch(EmptyStackException sd)
		{
			System.out.println(sd);
			
		}
		
		
		
	}
	@Test(priority=2)
	public void createxml()
	{
		
		  String line1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		    String line2 = "<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">";
		    String line3 = "<suite name=\"Suite\">";
/*		    String listenerss="<listeners>"+"\n"+
		"<listener class-name="+"\""+"utils.listeners"+"\""+"/>"+"\n"+
		 "</listeners>";
	*/	    
		    String line8 = "";
		    String line11 = "</suite> <!-- listners -->";

		    String classNamesFinalString = "";
		    for (int i = 0; i < testcases.size(); i++) {
		    classNamesFinalString = classNamesFinalString+
		    "<test name="+"\""+testcases.get(i)+"\">"+"\n"
		    +"<parameter name="+"\"browser\""+"  value="+'"'+browsers.get(i)+ '"'+"/>"+"\n"	
		    +"<parameter name="+"\"urls\""+"  value="+'"'+urls.get(i)+ '"'+"/>"+"\n"
		    +"<parameter name="+"\"rowids\""+"  value="+'"'+tcnums.get(i)+ '"'+"/>"+"\n"
		    +"<parameter name="+"\"classnames\""+"  value="+'"'+testcases.get(i)+ '"'+"/>"+"\n"
		    +"<classes>"+"\n"
		    + "<class name=\"testcases."+testcases.get(i) + "\"/>" + "\n"+
		    "</classes>"+"\n"+
		    "</test>"+"\n";
		    }
		    line8 = classNamesFinalString;
		    

		    String finalTextNGXMLString = line1 + "\n" + line2 + "\n" + line3+ "\n"+"\n"+  line8 + "\n" + line11;
	//add for listners and uncomment above and string listenerss
	//	    String finalTextNGXMLString = line1 + "\n" + line2 + "\n" + line3+ "\n" +listenerss+"\n"+  line8 + "\n" + line11;
			
		    System.out.println(finalTextNGXMLString);
		    // till here u create ur own xml
		    // below writing xml

		    File file = null;
		    FileWriter fileWriter = null;
		    BufferedWriter writer = null;

		    try {
		    file = new File("createdtestngxml.xml");
		    fileWriter = new FileWriter(file);
		    file.createNewFile();
		    writer = new BufferedWriter(fileWriter);
		    writer.write(finalTextNGXMLString);
		    System.out.println("File written successfully.");
		    } catch (Exception e) {
		    e.printStackTrace();
		    } finally {
		    if (writer != null) {
		    try {
		    writer.close();
		    } catch (Exception e) {
		    e.printStackTrace();
		    }
		    }
		    if (fileWriter != null) {
		    try {
		    fileWriter.close();
		    } catch (Exception e) {
		    e.printStackTrace();
		      }
             }
		    }
		    }

	@Test(priority=3)
	public void testngrun()
	{
		TestNG obj=new TestNG();
		List<String> suites=new ArrayList<String>();
		suites.add("C:\\Users\\Lenovo\\Desktop\\mars\\marsworkspace\\urike\\createdtestngxml.xml");
		obj.setTestSuites(suites);
		obj.run();
	}
}
