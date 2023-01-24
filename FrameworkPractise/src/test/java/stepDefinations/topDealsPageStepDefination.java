package stepDefinations;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.topDealsPage;
import utils.TestContextSetup;

public class topDealsPageStepDefination {
	TestContextSetup testContextSetup;
	topDealsPage tp;
	
	public topDealsPageStepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}

	@When("^Enter the same name (.+) in Top deals page$")
    public void enter_the_same_name_something_in_top_deals_page(String productName) throws Throwable {
	   
		
		tp=testContextSetup.pom.gettopDealsPage();
		tp.clickOnTopDeal();
		tp.switchToChildWindow();
		tp.enterProduct(productName);
		tp.getTopDealsProductName();
	}
	
	@Then("Verify both the names")
	public void verify_both_the_names() {
	   
		Assert.assertEquals(testContextSetup.homePageExtractedName, testContextSetup.topDealsPageExtractedName);
	}
	
	@When("switch to top deals page and sort the page by {int}")
	public void switch_to_top_deals_page_and_sort_the_page_by(int int1) throws Exception {
		
		tp=testContextSetup.pom.gettopDealsPage();
		tp.clickOnTopDeal();
		tp.switchToChildWindow();
	}
	@Then("print all the {int} item details")
	public void print_all_the_item_details(Integer int1) throws Exception {
	    
		tp.clickOnDropdown();
		tp.getTopDealsProductName();
	}
}
