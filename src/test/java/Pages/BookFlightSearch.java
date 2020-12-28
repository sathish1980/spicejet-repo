package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GeneralPackage.repository;

public class BookFlightSearch 
{
	@FindBy(xpath="//div[@id='divpaxinfo']")
	WebElement passengerdropdown;	
	@FindBy(xpath="(//p[@id='adultDropdown']//following::select[1])[1]")
	WebElement adultdropdown;
	@FindBy(xpath="(//p[@id='adultDropdown']//following::select[1])[2]")
	WebElement childdropdown;
	@FindBy (xpath="(//div[@class='currency-dropdown']//following::select)[1]")
	WebElement currency;
	@FindBy(xpath="(//span[@class='btn-find-flight-home']//child::input)[1]")
	WebElement searchbutton;
	@FindBy(xpath="(//div[@class='left1']//following::input)[1]")
	WebElement fromlocation;
	repository rs= new repository();
	WebDriver driver;
	WebDriverWait wait;
	String fromlocat="(//div[@class='left1']//following::input)[1]";
	String Locationidentified="NotDone";
	public BookFlightSearch(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void fromlocation(String fromloc)
	{
		//this changes is due to so so 
		/*WebElement loc=driver.findElement(By.id("'"));
		rs.click(loc);*/
		wait= new WebDriverWait(driver,60);
		//finding segments
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fromlocat)));
		fromlocation.click();
		List<WebElement> fromDrop=driver.findElements(By.xpath("(//div[@id='dropdownGroup1']//child::div)[1]//ul"));
		listvalue(fromDrop,fromloc,"from");
	
		//dropdownvalue(fromDrop,"selectbyvalue","CJB");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='right1']//following::input)[1]")));
		//driver.findElement(By.xpath("(//div[@class='right1']//following::input)[1]")).click();
		//List<WebElement> toDrop=driver.findElement(By.xpath("(//div[@class='right1']//following::select)[1]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void Tolocation(String toloc)
	{
		Locationidentified="NotDone";
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@id='dropdownGroup1']//child::div)[2]//ul)[1]")));
		List<WebElement> toDrop=driver.findElements(By.xpath("(//div[@id='dropdownGroup1']//child::div)[2]//ul"));
		listvalue(toDrop,toloc,"to");
	}
	
	public void depaturedate()
	{
		//
		rs.selectcalender("25-DECEMBER-2020","Depart",driver);
	}
	public void passengers(String value) throws InterruptedException
	{
	Thread.sleep(3000);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='divpaxinfo']")));
	passengerdropdown.click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[@id='adultDropdown']//following::select[1])[1]")));
//Adult Dropdown
	rs.dropdownvalue(adultdropdown,"selectbyvalue",value);
//Child Dropdown
	//WebElement childdropdown=driver.findElement(By.xpath("(//p[@id='adultDropdown']//following::select[1])[2]"));
	rs.dropdownvalue(childdropdown,"selectbyvalue",value);
	//infant Dropdown
	/*WebElement infantdropdown=driver.findElement(By.xpath("(//p[@id='adultDropdown']//following::select)[3]"));
	rs.dropdownvalue(infantdropdown,"selectbyvalue",value);*/
	}
	
	public void Curency(String cur)
	{
		//Currecny Dropdown
				//WebElement currencydropdown=driver.findElement(By.xpath("(//div[@class='currency-dropdown']//following::select)[1]"));
		rs.dropdownvalue(currency,"selectbyindex",cur);
							
		
	}
	
	public void searchbutton()
	{
		//WebElement searchbutton=driver.findElement(By.xpath("(//span[@class='btn-find-flight-home']//child::input)[1]"));
		rs.click(searchbutton);
	}
	
	public void modifysearch() throws InterruptedException
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()=' Modify Search']")));
		Thread.sleep(3000);
		driver.navigate().back();
		
		
	}
	
	public void listvalue(List<WebElement> fromdropdownvalue,String dropdownvalue,String fromto)
	{
		int s=1;
		int fromtovalue=1;
		int dp_size=fromdropdownvalue.size();
		if (fromto.equalsIgnoreCase("from"))
		{
			fromtovalue=1;
		}
		else if (fromto.equalsIgnoreCase("to"))
		{
			fromtovalue=2;
		}
		//four rows
		for(int i=1;i<=dp_size;i++) 
		{
			
			
			List<WebElement> Locationcount=driver.findElements(By.xpath("((//div[@id='dropdownGroup1']//child::div)["+fromtovalue+"]//ul)["+i+"]//li"));
			int Locationcountsize=Locationcount.size();
			
			//finding out the location value
			 for(int j=1;j<=Locationcountsize;j++)
			 {
				 String locationvalue=driver.findElement(By.xpath("((//div[@id='dropdownGroup1']//child::div)["+fromtovalue+"]//ul)["+i+"]//li["+j+"]//a")).getAttribute("value");
				 if(locationvalue.equalsIgnoreCase(dropdownvalue))
				 {
					 driver.findElement(By.xpath("((//div[@id='dropdownGroup1']//child::div)["+fromtovalue+"]//ul)["+i+"]//li["+j+"]//a")).click();
					 Locationidentified="Done";
					 break;
				 }
			 }
			 if (Locationidentified.equals("Done"))
			 {
				 break;
			 }
		}
	}
}
