package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {

	
	public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
		
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	
	   // Locators
	
	By lnkCustomers_menu=By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a/span");

	By lnkCustomers_menuitem=By.xpath ("//li[4]//ul[1]//li[1]//a[1]//span[1]");
	

	By btnAddnew=By.xpath("//a[@class='btn bg-blue']");  // add new
	

	By txtEmail=By.xpath("//input[@id='Email']");

	By txtPassword=By.xpath("//input[@id='Password']");
	

	By txtcustomerRoles=By.xpath("//div[10]//div[2]//div[1]//div[1]//div[1]");

	By lstitemsAdministrators=By.xpath("//li[contains(text(), 'Administrators')]");

	By lstitemsRegistered=By.xpath("//li[contains(text(), 'Registered')]");

	By lstitemsGuests=By.xpath("//li[contains(text(), 'Guests')]");

	By lstitemsVendors=By.xpath("//li[contains(text(), 'Vendors')]");
	

	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	

	By rdMaleGender=By.id("Gender_Male");

	By rdFemaleGender=By.id("Gender_Female");
	

	By txtFirstName=By.xpath("//input[@id='FirstName']");

	By txtLastName=By.xpath("//input[@id='LastName']");

	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	

	By txtCompanyName=By.xpath("//input[@id='Company']");

	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");

	By btnSave=By.xpath("//button[@name='save']");




	 
	// Need to perform the action methods below
	
	

	public String getPageTitle(){
		return ldriver.getTitle();
	}
	
	
	public void ClickOnCustomersMenu(){
		ldriver.findElement(lnkCustomers_menu).click();
	}
	

	public void ClickOnCustomersMenuItem(){
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	
	public void ClickOnAddnew(){
		ldriver.findElement(btnAddnew).click();
	}
	
		
		public void setEmail(String email){
			
			ldriver.findElement(txtEmail).sendKeys(email);
		
		}
		
		
		
		public void setPassword(String password){
			
			ldriver.findElement(txtPassword).sendKeys(password);
			
		}
		
		
		public void setCustomerRoles(String role) throws InterruptedException{
			
			if(!role.equals("Vendors"))// if role is vendors should not delete Register
			{
				ldriver.findElement(By.xpath("//div[10]//div[2]//div[1]//div[1]//div[1]"));
				
			}
			
			ldriver.findElement(txtcustomerRoles).click();
			
			WebElement listitem;
			
			Thread.sleep(3000);
			
			
			if(role.equals("Administrators"))
			{
				
				listitem=ldriver.findElement(lstitemsAdministrators);
			}
			else if(role.equals("Guests"))
				
			{
				listitem=ldriver.findElement(lstitemsGuests);
				
			}
			else if(role.equals("Registered"))
				
			{
				listitem=ldriver.findElement(lstitemsRegistered);
				
			}
			else if(role.equals("Vendors"))
				
			{
				listitem=ldriver.findElement(lstitemsVendors);
				
			}
			else
			{
				listitem=ldriver.findElement(lstitemsGuests);
				
				
				//listitem.click();
				//Thread.sleep(3000)
				
				JavascriptExecutor js = (JavascriptExecutor)ldriver;
					js.executeScript("arguments[0].click();", listitem);
			}
		}
		
			
			
			
			public void setManagerofVendor(String value){
				
				Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
				drp.selectByVisibleText(value);
			
			}
			
			public void setGender(String gender){
				
				
				if(gender.equals("male"))
					
				{
					ldriver.findElement(rdMaleGender).click();
				}
				else if(gender.equals("Female"))
					
				{
					ldriver.findElement(rdFemaleGender).click();
			
			  }
			 
				else
				{
					ldriver.findElement(rdMaleGender).click();  //Default choice
				}
			
	
			}
			

			public void setFirstName(String fname){
				
				ldriver.findElement(txtFirstName).sendKeys(fname);
			
			}
			  
			
			
			
                public void setLastName(String lname){
				
				ldriver.findElement(txtLastName).sendKeys(lname);
			
			}
                
                
                public void setDob(String dob){
    				
    				ldriver.findElement(txtDob).sendKeys(dob);
    			
    			}
                
                
                public void setCompanyName(String comname){
    				
    				ldriver.findElement(txtCompanyName).sendKeys(comname);
    			
    			}
			
                
               public void setAdminContent(String content){
    				
    				ldriver.findElement(txtCompanyName).sendKeys(content);
    			
    			}
               
               
               public void clickOnSave(){
   				
   				ldriver.findElement(btnSave).click();
   			
   			}
			
}
