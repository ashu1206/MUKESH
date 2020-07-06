package pageObjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight 
{
	WebDriver driver;
	
	public SelectFlight(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
/*	@FindBy(xpath="//*[@id=\"root\"]/div/header/div[2]/div/div/div/div[1]/div/div/div/div")
	WebElement verifyOneWay;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/div[2]/div/div/div/div[3]/div/div/div/input")
	WebElement verifyBoarding;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/div[2]/div/div/div/div[6]/div/div/div/input")
	WebElement verifyDeboarding;

	@FindBy(xpath="//*[@id=\"root\"]/div/header/div[2]/div/div/div/div[8]/div/div[1]/div")
	WebElement verifyDate;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/header/div[2]/div/div/div/div[10]/div/div/div/div")
	WebElement verifyPersons;     */
	
	@FindBy(xpath="//*[@id='root']//span/div[contains(text(),'Flight details')]/../../../..")
	WebElement selectFlights;
	
	
	
	
/*	public void verify_Route()
	{
		String actual = verifyOneWay.getText();
		String expected = "One way";
		Assert.assertEquals(expected, actual);
		
		
	}
	
	public void boarding_city_Verify()
	{
		String actual = verifyBoarding.getText();
		String expected = "PNQ - Pune, IN";
		Assert.assertEquals(expected, actual);
	}
	
	public void deboarding_city_Verify()
	{
		String actual = verifyDeboarding.getText();
		String expected ="DEL - New Delhi, IN ";
		Assert.assertEquals(expected, actual);
	}
	
	public void date_Of_Journey()
	{
		String actual = verifyDate.getText();
		String expected ="Tue, Jan 26";
		Assert.assertEquals(expected, actual);
	}
	
	public void number_Of_Travellers()
	{
		String actual = verifyPersons.getText();
		String expected ="3 Travellers";
		Assert.assertEquals(expected, actual);
	}   */
	
	public void book_flight( )
	{
		
	//	List<WebElement> airlines = driver.findElements(By.xpath("//nav/ul[@class='listView flights']/li//tbody[2]//th[1]"));
		
		List<WebElement> airlines = selectFlights.findElements(By.xpath("//*[@id='root']//span/div[contains(text(),'Flight details')]/../../../..]"));
		List<WebElement> airLines_name = selectFlights.findElements(By.xpath(".//div/img"));
		for(WebElement ele: airLines_name) {
			System.out.println(ele.getAttribute("alt"));
		}
		
		List<String> air_name = new ArrayList<String>();
		
		int total_airlines = airlines.size();
		
		for(int i=0;i<total_airlines;i++)
		{
			String airlines_name = airlines.get(i).getText();
			
			air_name.add(airlines_name);
			
		}
		
		System.out.println();
		
       List<WebElement> prices = driver.findElements(By.xpath("//nav/ul[@class='listView flights']/li//tbody[2]//th[6]"));
		
		
		List<String> air_prices = new ArrayList<String>();
		
		int airlines_price = prices.size();
		
				
		for(int z=0;z<airlines_price;z++)
		{
			String indiviual_airlines_price = prices.get(z).getText();
			
			air_prices.add(indiviual_airlines_price);		
		}
				
		
		Map<String,String> map = new HashMap<String,String>();
		int j = 0;
		for(int y=0;y<total_airlines;y++)
		{
			map.put(air_name.get(y) +j, air_prices.get(y));
			j++;
		}
		System.out.println(map);
		
       TreeMap<String, String> sorted = new TreeMap<String, String>();
		
		sorted.putAll(map);
		String keys = null;
		String values = null;
		
		for(Map.Entry<String, String>entry:sorted.entrySet())
		{
			 keys = entry.getKey();
			 values = entry.getValue();
			System.out.println(keys+" = "+values);
		}
		if(keys.equalsIgnoreCase("GoAir2")&&(values.equalsIgnoreCase("Rs.8,522"))) {
			
			driver.findElement(By.xpath("//*[@id=\"flightForm\"]/section[2]/div[4]/div/nav/ul/li[3]/table/tbody[2]/tr[2]/td[3]/button")).click();
		}
	else if(keys.equalsIgnoreCase("GoAir2")&&(values.equalsIgnoreCase("Rs.8,522"))){
		driver.findElement(By.xpath("//*[@id=\"flightForm\"]/section[2]/div[4]/div/nav/ul/li[4]/table/tbody[2]/tr[2]/td[3]/button")).click();
	}
	else {
		driver.findElement(By.xpath("//*[@id=\"flightForm\"]/section[2]/div[4]/div/nav/ul/li[5]/table/tbody[2]/tr[2]/td[3]/button")).click();
	}
	
	}
	
	
	
	
	
}
