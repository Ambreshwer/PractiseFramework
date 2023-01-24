package stepDefinations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.checkOutPage;
import pageObjects.homePage;
import pageObjects.pageObjectManager;
import utils.TestContextSetup;

public class checkOutPagestepDefination {
	
TestContextSetup testContextSetup;

	
	public checkOutPagestepDefination(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("verify the product in checkout page")
	public void verify_the_product_in_checkout_page() throws IOException {
		//String getName=testContextSetup.testBase.webDriverManager().findElement(By.xpath("//p[@class='product-name']")).getText().split("-")[0].trim();
		checkOutPage cp=testContextSetup.pom.checkOutPage();
		System.out.println(cp.checkOutPageGetName());
		homePage hp=testContextSetup.pom.getHomePage();
		Assert.assertEquals(hp.getHomePageProductName(), cp.checkOutPageGetName());
	}
	
	@Then("verify the {int} added quantity of product in checkout page")
	public void verify_the_added_quantity_of_product_in_checkout_page(Integer count) throws IOException {
		checkOutPage cp=testContextSetup.pom.checkOutPage();
		System.out.println(cp.getCheckoutPageCount());
		System.out.println(cp.checkoutPageTotalAmount()+"cp.checkoutPageTotalAmount()");
		Assert.assertEquals(count, cp.getCheckoutPageCount());
		homePage hp=testContextSetup.pom.getHomePage();
		Assert.assertEquals(hp.actualAmount(count), cp.checkoutPageTotalAmount());
	}
}
