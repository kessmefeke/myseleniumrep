package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {
	
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
		
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	 
	 driver=new ChromeDriver();
		
		lp=new LoginPage(driver);
	  
	}

	@When("user opens URL {string}")
	public void user_opens_URL(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	    
	}

	@When("user enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    
		
		lp.setUsername(email);
		lp.setPassword(password);
		
		
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		
		lp.clickLogin();
		Thread.sleep(3000);
		
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		
		if(driver.getPageSource().contains("Login was Unsuccesful.")){
			driver.quit();
			Assert.assertTrue(false);
	
			
		}else{
			Assert.assertEquals(title, driver.getTitle());
			
		}
		Thread.sleep(3000);
	}
		
	

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
		
		lp.clickLogout();
		
		Thread.sleep(3000);
	   
	}

	
	/*
	
	 @Then("page Title should be \"your store. Login{string}")
	public void page_Title_should_be_your_store_Login(String title) {
			
			if(driver.getPageSource().contains("Login was Unsuccesful.")){
				driver.close();
				Assert.assertTrue(false);
				
			}else{
				Assert.assertEquals(title, driver.getTitle());
				
			}
	   
	}
   */
	

	
	@And("close browser")
	public void close_browser() {
		
		driver.quit();
	
	}


	
	// Customer_features step definitions.....

	
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {  // basically a verification
		
		addCust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	  
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.ClickOnCustomersMenu();
	}

	
	
	@When("Click on Customers Menu Item")
	public void click_on_Customers_Menu_Item() throws InterruptedException {
		Thread.sleep(2000);
		addCust.ClickOnCustomersMenuItem();
	    
	}

	
	
	@When("Click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		
		addCust.ClickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	   
		
	}

	
	
	@When("User enter Customer info")
	public void user_enter_Customer_info() throws InterruptedException {
		
		String email=randomstring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		
		// Registered - default
		// The customer cannot be in both 'Guests' and 'Registered' customer roles
		//Add the customer to 'Guests' or 'Registered' customer role
		
		addCust.setCustomerRoles("Registered");
		Thread.sleep(3000);
		
		
		addCust.setManagerofVendor("Vendor 2");
		addCust.setGender("Male");
		addCust.setFirstName("John");
		addCust.setLastName("Doe");
		addCust.setDob("7/05/1985"); // Format:  D/MM/YYYY
		addCust.setCompanyName("Blackdot");
		addCust.setAdminContent("Testing testing testing etc......");
		
		
		
	}

	
	
	@When("Click on Save button")
	public void click_on_Save_button() throws InterruptedException {
		
		addCust.clickOnSave();
		Thread.sleep(2000);
	}

	
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
			.contains("The new customer has been added successfully."));
		
	}

	
	
	// Steps for searching Customer using Email ID.
	
	
	
	@When("Enter customer Email")
	public void enter_customer_Email() {
    searchCust=new SearchCustomerPage(driver);
    
    searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}
	
	
	

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCust.clickSearch();
		
	   Thread.sleep(3000);
	}

	
	
	
	@Then("User should find Email in the Search table")
	public void user_should_find_Email_in_the_Search_table() {
	    
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		
		Assert.assertEquals(true, status);
	}


	
	
	
	// Steps for searching customer by using their first or last name
	
	
	@When("Enter customer firstName")
	public void enter_customer_firstName() {
	    
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	}

	
	
	
	@When("Enter customer LastName")
	public void enter_customer_LastName() {
		
		searchCust.setLastName("Terces");
	 
	}

	
	
	
	@Then("User should find Name in the Search table")
	public void user_should_find_Name_in_the_Search_table() {
		
		
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		
		Assert.assertEquals(true, status);
		
	    
	}

	
}
