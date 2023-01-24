package pageObjects;

import org.openqa.selenium.WebDriver;

public class pageObjectManager {
	WebDriver driver;
	homePage hp;
	topDealsPage tp;
	checkOutPage cp;
	
	public pageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public homePage getHomePage()
	{
		hp=new homePage(driver);
		return hp;		
	}
	
	public topDealsPage gettopDealsPage()
	{
		topDealsPage tp=new topDealsPage(driver);
		return tp;		
	}
	
	public checkOutPage checkOutPage()
	{
		cp=new checkOutPage(driver);
		return cp;
	}

}
