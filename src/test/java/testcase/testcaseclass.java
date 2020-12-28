package testcase;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BookFlightSearch;
import package1.spicejet_baseframework.Browser;
import package1.spicejet_baseframework.proertyfile;

public class testcaseclass extends Browser
{
	proertyfile pf= new proertyfile();
	String filepath="C:\\Users\\sathish.kumar15\\eclipse-workspace\\spicejet_baseframework\\InputData\\";
	String filename="Filesearchfile.xls";
	String sheetname="oneround";

	@BeforeSuite
	public void launch() throws IOException
	{
		String browsername = pf.getObjectRepository().getProperty("Browser");
		firstmethod(browsername);
	}
	
	@BeforeTest
	public void homepage() throws IOException
	{
		String url = pf.getObjectRepository().getProperty("URL");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	///project related stuffs
	@Test(dataProvider="flightsearch")
	public void searchwithvalidvalues(String from,String tolo,String date,String pas,String cur) throws InterruptedException
	{
		BookFlightSearch bs= new BookFlightSearch(driver);
		bs.fromlocation(from);
		bs.Tolocation(tolo);
		bs.depaturedate();
		bs.passengers(pas);
		bs.Curency(cur);
		bs.searchbutton();
		bs.modifysearch();
	}
	
	@AfterSuite
	public void teardown()
	{
		driver.close();
		driver.quit();
		
	}
	@DataProvider(name="flightsearch")
	public String[][] methodname() throws IOException	
	{
		return package1.spicejet_baseframework.excelreadandwrite.excelreaddata(filepath, filename, sheetname);
	
	}
	
}
