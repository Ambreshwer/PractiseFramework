package stepDefinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.homePage;
import pageObjects.pageObjectManager;
import pageObjects.topDealsPage;
import utils.TestContextSetup;

public class homePageStepDefination {

	TestContextSetup testContextSetup;
	pageObjectManager pm;
	homePage hp;
	
	
	public homePageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Given("Land on Green cart home page")
	public void land_on_green_cart_home_page() {
		
		
	}
	@Given("Land on dropdown practise home page")
	public void land_on_dropdown_practise_home_page() {
	   
		
	}
	@When("^Enter the (.+) in search bar extract the name$")
    public void enter_the_something_in_search_bar_extract_the_name(String productName) throws Throwable {
	  
		
		homePage hp=testContextSetup.pom.getHomePage();
		hp.enterProduct(productName);
		hp.getHomePageProductName();
	}
	
	@When("Seach the product {string} and add on cart")
	public void seach_the_product_tomato_and_add_on_cart(String productName) throws Exception {
	
		hp=testContextSetup.pom.getHomePage();
		hp.enterProduct(productName);
		hp.getHomePageProductName();
		hp.addProductOnCart();
		topDealsPage tp=testContextSetup.pom.gettopDealsPage();
		tp.clickOnCartLink();
		tp.clickOnProceedToButton();
	}
	
	@When("^add (.+) (.+) in cart page$")
	public void add_in_cart_page(Integer count, String productName) throws Exception {
	   
		homePage hp=testContextSetup.pom.getHomePage();
		hp.enterProduct(productName);
		hp.getHomePageProductName();
		hp.additems(count);
		System.out.println(hp.actualAmount(count)+"hp.actualAmount");
		hp.addProductOnCart();
		topDealsPage tp=testContextSetup.pom.gettopDealsPage();
		tp.clickOnCartLink();
		tp.clickOnProceedToButton();
	}
	
	@When("total no of links")
	public void total_no_of_links() throws IOException {
	
		WebDriver driver=testContextSetup.testBase.webDriverManager();
		driver.manage().window().maximize();
		int numofLinks=driver.findElements(By.tagName("a")).size();
		System.out.println(numofLinks);
	}
	
	@When("select the from and To place")
	public void select_the_from_and_to_place() throws IOException, InterruptedException {
	    
		WebDriver driver=testContextSetup.testBase.webDriverManager();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']")).click();
		Thread.sleep(2000);
		List<WebElement> values=driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));
		
		for(int i=0;i<values.size();i++)
		{
			if(values.get(i).getText().equalsIgnoreCase("Bengaluru"))
			{
				Thread.sleep(2000);
				values.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
		
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']")).click();
		Thread.sleep(2000);
		List<WebElement> values1=driver.findElements(By.xpath("//div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));
		for(int i=0;i<values1.size();i++)
		{
			if(values1.get(i).getText().equalsIgnoreCase("Hyderabad"))
			{
				Thread.sleep(2000);
				values1.get(i).click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	@Then("enter the month and date and select  two adult passangers")
	public void enter_the_month_and_date_and_select_two_adult_passangers() throws IOException, InterruptedException {
		
		WebDriver driver=testContextSetup.testBase.webDriverManager();
		
		driver.findElement(By.xpath("//div[@data-testid='departure-date-dropdown-label-test-id']")).click();
		List<WebElement>allMonths=driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']"));
//		for(int i=0;i<allMonths.size();i++)
//		{
//			if(allMonths.get(i).getText().equalsIgnoreCase("March 2023"))
//		}
		
		
		
		
		
		while(!driver.findElement(By.xpath("//div[@data-testid='undefined-month-March-2023']/div[@class='css-1dbjc4n r-k8qxaj']")).getText().equalsIgnoreCase("March 2023"));
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1loqt21 r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd r-eafdt9 r-1i6wzkk r-lrvibr r-184en5c']//*[name()='svg']//*[name()='g' and contains(@fill,'none')]//*[name()='circle' and contains(@cx,'24.5')]")).click();
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-travellers']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
	}
	
	@Then("it's text and link url of the greenkart.")
	public void it_s_text_and_link_url_of_the_greenkart() throws IOException {
		WebDriver driver=testContextSetup.testBase.webDriverManager();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		 for(WebElement link:allLinks){
			 System.out.println(link.getText() + " - " + link.getAttribute("href"));
		 }	 
	}
}
