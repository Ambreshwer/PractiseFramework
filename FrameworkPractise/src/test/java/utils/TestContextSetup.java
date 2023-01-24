package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.pageObjectManager;

public class TestContextSetup {
	
	public WebDriver driver;
	public String topDealsPageExtractedName;
	public String homePageExtractedName;
	public pageObjectManager pom;
	public TestBase testBase;
	
	public TestContextSetup() throws IOException 
	{
		testBase=new TestBase();
		pom=new pageObjectManager(testBase.webDriverManager());
	}
}
