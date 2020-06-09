package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
      public WebDriver driver;
	
	  public LoginPage lp;
	  
	  public AddCustomerPage addCust;
	  
	  public SearchCustomerPage searchCust;
	  
	  
	  
	  //Created for generating random string for unique email ids
	  public static String randomstring() {
		  
		  String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		  return(generatedString1);
		  
	  }
	  
	  
	  
	  
	  

}
