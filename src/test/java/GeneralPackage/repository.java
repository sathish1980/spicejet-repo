package GeneralPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class repository 
{
	int tablevalue=0;
	public void click(WebElement button)
	{	
	button.click();
	}
	
	public void sendkeys(WebElement textbox,String value)
	{	
	textbox.sendKeys(value);
	}
	
	public void explictwaitbyelement(WebDriver driver , int timeout,By element)
	{
		WebDriverWait wait= new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void selectcalender(String date,String Type,WebDriver driver)
	{
		
		//String date="15-SEPTEMBER-2020";
		Boolean Identifieddate=false;
		String[] datesplit=date.split("-");
		String actualdate= datesplit[0];
		String actualmon= datesplit[1];
		String actualyear= datesplit[2];
		//to click the calender icon
		/*if (Type.equalsIgnoreCase("Depart"))
		{
			driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
			
		}*/
		if (Type.equalsIgnoreCase("Return"))
		{
			driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();
		}
		
		//Validating the month
			for(int mo=1;mo<=12;mo++)
			{
				String month=driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']//child::div)[3]//span[1]")).getText();
				
				if(month.equalsIgnoreCase(actualmon))
				{
					tablevalue=1;
					break;
				}
				else
				{
					month= driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']//child::div)[6]//span[1]")).getText();
					if(month.equalsIgnoreCase(actualmon))
					{
						tablevalue=2;
						break;
					}
					else
					{
						driver.findElement(By.xpath("//span[text()='Next']")).click();
						//month= driver.findElement(By.xpath("(//div[@id='ui-datepicker-div']//child::div)[6]//span[1]")).getText();
					}	
					}
				
			}
				
				
				List<WebElement> Tablerow= driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])["+tablevalue+"]//tbody//tr"));
				int tablerowsize =Tablerow.size();
				List<WebElement> Tablecolumn= driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])["+tablevalue+"]//tbody//tr[1]//td"));
				int tablecolumnsize =Tablecolumn.size();
				
				for( int i=1;i<=tablerowsize;i++)
				{
					for(int j=1;j<=tablecolumnsize;j++)
					{
						String classname=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])["+tablevalue+"]//tbody//tr["+i+"]//td["+j+"]")).getAttribute("class");
						String Actual_classnamevalue="disabled";
						if(classname.contains(Actual_classnamevalue))
						{
						
						}
						else
						{
						String value=driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])["+tablevalue+"]//tbody//tr["+i+"]//td["+j+"]//a")).getText();
					
						if(Integer.parseInt(value)==Integer.parseInt(actualdate))
						{
							driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])["+tablevalue+"]//tbody//tr["+i+"]//td["+j+"]")).click();
							Identifieddate=true;
							break;
						}
						}
						}
					if(Identifieddate==true)
					{
						break;
					}
				}
	}
	
	
	public void dropdownvalue(WebElement dropdown,String methodname,String selectvalue)
	{
		Select s= new Select(dropdown);
		if(methodname.equalsIgnoreCase("selectbyvalue"))
		{
			s.selectByValue(selectvalue);
		}
		else if(methodname.equalsIgnoreCase("selectbyvisibletext"))
		{
			s.selectByVisibleText(selectvalue);
		}
		else if(methodname.equalsIgnoreCase("selectbyindex"))
		{
			s.selectByIndex(Integer.parseInt(selectvalue));
		}
		
	}

}
