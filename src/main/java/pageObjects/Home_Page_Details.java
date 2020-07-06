package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Details 
{
	WebDriver driver;
	public Home_Page_Details(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//nav[@class='row fieldRow tripType']/ul/li/label/input")
	List<WebElement> allTripType;
	
	@FindBy(xpath="//*[@id=\"FromTag\"]")
	WebElement from;
	
	@FindBy(xpath="//*[@id=\"ToTag\"]")
	WebElement to;
	
	@FindBy(xpath="//*[@id=\"DepartDate\"]")
	WebElement departure;
	
	@FindBy(xpath="//*[@id=\"Adults\"]")
	WebElement countadults;
	
	@FindBy(xpath="//*[@id=\"Childrens\"]")
	WebElement countchildren;
	
	@FindBy(xpath="//*[@id=\"Infants\"]")
	WebElement countinfants;
	
	@FindBy(xpath="//*[@id=\"SearchBtn\"]")
	WebElement search;
	
	
	
	/*public String checkSelectedTripType() {
	String tripType = null;
		
    for(WebElement ele : allTripType) {
			
	if(ele.isSelected()) {
		tripType = ele.getAttribute("id");
	}
		}
    return tripType;
	}
	
	public void selectTripType(String tripType) {
		for(WebElement ele : allTripType) {
			
			if(ele.getAttribute("id").equalsIgnoreCase(tripType)) {
				ele.click();
			}
				}
	}*/
	
	
	public void fromBoard(String board)
	{
		
		from.sendKeys(board);
	}
	
	public void toDeboard(String deboard)
	{
		
		to.sendKeys(deboard);
	}
	
	public void dateDepart(String yearto,String monthto,String dateto)
	{
		
        driver.findElement(By.xpath("//*[@id=\"ORtrip\"]/section[2]/div[1]/dl/dd/div/a/i")).click();
		
		boolean a = true;

		System.out.println(yearto);
		while(a)
		{
			WebElement years = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
			String year = years.getText();
			
			if(year.equals(yearto))
			{
				boolean m = true;
				
				
				while(m)
				{
					WebElement months = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
					String month = months.getText();
					
					if(month.equals(monthto))
					{
						List<WebElement> dates = driver.findElements(By.xpath("//*[@class='monthBlock first']//td"));
						int total_dates = dates.size();
						
						for(int k=0;k<total_dates;k++)
						{
							String date = dates.get(k).getText();
							
							if(date.equalsIgnoreCase(dateto))
							{
								dates.get(k).click();
								break;
							}
						}
						m=false;
					}
					else
					{
						driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
											}
				}
				
				a=false;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/div/a")).click();
							}						
		}
		
	}
	
	public void noOfAdults(String adults)
	{
		countadults.sendKeys(adults); 
	}
	
	public void noOfChildren(String children)
	{
		countchildren.sendKeys(children);
	}
	public void noOfInfants(String infants)
	{
		countinfants.sendKeys(infants);
	}
	public void flightsearch()
	{
		search.click();
	}


}
