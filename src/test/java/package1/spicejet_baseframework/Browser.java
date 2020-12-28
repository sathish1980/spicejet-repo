package package1.spicejet_baseframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Browser 
{
	String chromediverpath="C:\\Users\\sathish.kumar15\\OneDrive - EY\\Desktop\\SathishkumarR\\Personal\\EY\\chromedriver_win32\\chromedriver.exe";
	String firefoxdriver="";
	public static WebDriver driver;
	 
	public void firstmethod(String browsername)
	{
		if(browsername.equals("Chrome"))
				{
		System.setProperty("webdriver.chrome.driver",chromediverpath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		driver =new ChromeDriver(options);
				}
		else if(browsername.equals("firefox"))
				{
			System.setProperty("webdriver.gecko.driver",firefoxdriver);
			driver =new FirefoxDriver();
				}

	}
	
	
}
