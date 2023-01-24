package pageObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class topDealsPage {
	WebDriver driver;
	
	public topDealsPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	
	By windowLink=By.linkText("Top Deals");
	By cartLink=By.xpath("//a[@class='cart-icon']");
	By checkoutButton=By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	By searchBar=By.xpath("//input[@id='search-field']");
	By GetName=By.cssSelector("tbody tr td:nth-child(1)");
	By dropdownButton=By.xpath("//select[@id='page-menu']");
	By tableOneDetails=By.xpath("//tbody/tr/td[1]");
	By tableTwoDetails=By.xpath("//tbody/tr/td[2]");
	By tableThreeDetails=By.xpath("//tbody/tr/td[3]");
	
	
	
	
	public void clickOnTopDeal()
	{
		driver.findElement(windowLink).click();
	}
	public void clickOnCartLink()
	{
		driver.findElement(cartLink).click();
	}
	public void clickOnProceedToButton()
	{
		driver.findElement(checkoutButton).click();
	}
	
	public void switchToChildWindow() throws InterruptedException
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		String parentWindow=it.next();
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		Thread.sleep(3000);
	}
	
	public void enterProduct(String name)
	{
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public String getTopDealsProductName()
	{
		return driver.findElement(GetName).getText();
	}
	
	
	
	public void clickOnDropdown() throws Exception
	{
		WebElement dropdown=driver.findElement(dropdownButton);
		Select se=new Select(dropdown);
		Thread.sleep(2000);
		se.selectByVisibleText("10");
		Thread.sleep(2000);
	}
	
	public void getTableDeatails()
	{
		List<WebElement> values=driver.findElements(By.xpath("//tbody/tr/td[1]"));
		
		for(int i=0;i<values.size();i++)
		{
			System.out.print(values.get(i).getText()+" price = ");
			List<WebElement> values2=driver.findElements(By.xpath("//tbody/tr/td[2]"));
			for(int j=0;j<values2.size();j++)
			{
				System.out.print(values2.get(j).getText()+", Discount price = ");
				List<WebElement> values3=driver.findElements(By.xpath("//tbody/tr/td[3]"));
				for(int k=0;k<values3.size();k++)
				{
					System.out.println(values3.get(k).getText());
					break;
				}
				break;
			}
			
		}
		
		 
	}
	
//	public void verify()
//	{
//		WebDriver driver=testContextSetup.testBase.webDriverManager();
//		WebElement dropdown=driver.findElement(By.xpath("//select[@id='page-menu']"));
//		Select se=new Select(dropdown);
//		Thread.sleep(2000);
//		se.selectByVisibleText("10");
//		Thread.sleep(2000);
//	}
	
}
