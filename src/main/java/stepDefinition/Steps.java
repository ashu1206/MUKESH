package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Home_Page_Details;
import pageObjects.SelectFlight;

public class Steps 
{
	WebDriver driver;
	HomePage homepage;
	Home_Page_Details homePageDetails ;
	SelectFlight selectFlight;
	 
//	PageObjectManager pageObjectManager;
	
	
	 
	
	
	
		
	
	
	@Given("^User is on Home Page and One Way is selected$")
	public void user_is_on_Home_Page_and_One_Way_is_selected() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Chromenew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
    //	pageObjectManager = new PageObjectManager(driver);
	//	homepage = pageObjectManager.getHomePage();
    	homepage = new HomePage(driver);
		homepage.navigate_To_HomePage();
	//	homePageDetails = pageObjectManager.getHomePageDetails();
		homePageDetails = new Home_Page_Details(driver);
		selectFlight = new SelectFlight(driver);
	//	selectFlight = pageObjectManager.clickOnSelectFlight(); 
			
	    
	}

	@Then("^Fills the From which is boarding place$")
	public void fills_the_From_which_is_boarding_place() throws Throwable 
	{
			
	    homePageDetails.fromBoard("Pune, IN - Lohegaon (PNQ)");
	}

	@Then("^Fills the To which is deboarding place$")
	public void fills_the_To_which_is_deboarding_place() throws Throwable
	{
		
	   homePageDetails.toDeboard("New Delhi, IN - Indira Gandhi Airport (DEL)");
		
	}

	@Then("^Selects the date of departure \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void selects_the_date_of_departure_and(String yearto, String monthto, String dateto)
	{
				
		homePageDetails.dateDepart(yearto, monthto, dateto);
	}
	    

	@Then("^Fills the number of Adults and Children and Infants$")
	public void fills_the_number_of_Adults_Children_and_Infants() throws Throwable 
	{
				
	   homePageDetails.noOfAdults("1");
	   homePageDetails.noOfChildren("1");
	   homePageDetails.noOfInfants("1");
	}

	@Then("^Clicks on Search Flights$")
	public void clicks_on_Search_Flights() throws Throwable 
	{
				
	   homePageDetails.flightsearch();
	}
	
/*	@Given("^User is on second page and verifies the Route$")
	public void user_is_on_second_page_and_verifies_the_Route() throws Throwable {
		
		selectFlight.verify_Route();
	    
	}

	@Then("^User verifies the Boarding City$")
	public void user_verifies_the_Boarding_City() throws Throwable {
		
		selectFlight.boarding_city_Verify();
	    
	}

	@Then("^User verifies the DeBoarding City$")
	public void user_verifies_the_DeBoarding_City() throws Throwable {
		
		selectFlight.deboarding_city_Verify();
	    
	}

	@Then("^User verifies the Date of Travelling$")
	public void user_verifies_the_Date_of_Travelling() throws Throwable {
		
		selectFlight.date_Of_Journey();
	   
	}

	@Then("^User verifies the number of Persons$")
	public void user_verifies_the_number_of_Persons() throws Throwable {
		
		selectFlight.number_Of_Travellers();
	   
	}    */

	@Then("^User chooses the flight and clicks on book$")
	public void user_chooses_the_flight_and_clicks_on_book() throws Throwable {
		
				selectFlight.book_flight();
	    
	}



}
