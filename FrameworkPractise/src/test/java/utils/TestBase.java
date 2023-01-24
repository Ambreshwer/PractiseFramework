package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException
	{
	
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		prop.load(fis);
		String url=prop.getProperty("QaUrl");
		String dropdownPractiseUrl=prop.getProperty("newUrl");
		if(driver==null)
		{
		System.setProperty("webdriver.chrome.driver", "D://Driver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(dropdownPractiseUrl);
		driver.manage().window().maximize();
		}
		return driver;
	}
}
