package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePage;
import pageObjects.Home_Page_Details;
import pageObjects.SelectFlight;

public class PageObjectManager 
{
	private WebDriver driver;
	private HomePage homepage;
	private Home_Page_Details homePageDetails;
	private SelectFlight selectFlight;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public HomePage getHomePage()
	{
		return(homepage!=null)?homepage=new HomePage(driver):homepage;
	}
	
	public Home_Page_Details getHomePageDetails()
	{
		return(homePageDetails!=null)?homePageDetails=new Home_Page_Details(driver):homePageDetails;
	}
	
	public SelectFlight clickOnSelectFlight()
	{
		return(selectFlight!=null)?selectFlight=new SelectFlight(driver):selectFlight;
	}
 
}
