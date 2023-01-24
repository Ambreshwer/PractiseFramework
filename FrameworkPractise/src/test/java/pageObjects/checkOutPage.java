package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkOutPage {
	WebDriver driver;
	
	public checkOutPage(WebDriver driver) {
		this.driver=driver;
	}

	//String getName=testContextSetup.testBase.webDriverManager().findElement(By.xpath("//p[@class='product-name']")).getText().split("-")[0].trim();
	//String productCount=driver.findElement(By.xpath("//p[@class='quantity']")).getText().trim();

	By getName=By.xpath("//p[@class='product-name']");
	By getCheckoutPageCount=By.xpath("//p[@class='quantity']");
	
	By amount=By.className("amount");
	
	public String checkOutPageGetName()
	{
		return driver.findElement(getName).getText().split("-")[0].trim();
	}
	
	public String getCheckoutPageCount()
	{
		return driver.findElement(getCheckoutPageCount).getText().trim().split(" ")[0];
	}

	public String checkoutPageTotalAmount()
	{
		return driver.findElement(amount).getText().trim();
	}
	
}
