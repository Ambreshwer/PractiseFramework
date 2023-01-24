package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	WebDriver driver;
	
	public homePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//driver.findElement(By.xpath("//p[@class='product-price']"))
	
	By searchBar=By.xpath("//input[@type='search']");
	By ProductName=By.cssSelector("h4.product-name");
	By addToCartButton=By.xpath("//button[text()='ADD TO CART']");
	By amount=By.xpath("//p[@class='product-price']");
	
	public void enterProduct(String name)
	{
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public String getHomePageProductName()
	{
		return driver.findElement(ProductName).getText().split("-")[0].trim();
		
	}
	
	public void addProductOnCart()
	{
		driver.findElement(addToCartButton).click();
	}
	
	public void additems(Integer count) throws Exception {
		Thread.sleep(2000);
		for(int i=1;i<=count-1;i++)
		{
			driver.findElement(By.xpath("//a[@class='increment']")).click();
		}
		Thread.sleep(2000);
	}
	public int actualAmount(int count1)
	{
		String homePageAmount=driver.findElement(amount).getText().trim();
		int a=Integer.parseInt(homePageAmount);
		int finalAmount=(a)*(count1);
		return finalAmount;
	}

	
	
}
