Feature: Customers

Background: Below are the common steps for every scenario

   Given user launch chrome browser
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then User can view Dashboard


Scenario: Add a new Customer

   When User click on customers Menu
   And Click on Customers Menu Item
   And Click on Add new button
   Then User can view add new customer page
   When User enter Customer info
   And Click on Save button
   Then User can view confirmation message "The new customer has been added successfully."
   And close browser
   
   
   Scenario: Search cutomer by EmailID
  
   When User click on customers Menu
   And Click on Customers Menu Item
   And Enter customer Email
   When Click on search button
   Then User should find Email in the Search table
   And close browser
   
   
   
   Scenario: Search Customer by EmailID
 
   When User click on customers Menu
   And Click on Customers Menu Item
   And Enter customer firstName
   And Enter customer LastName
   When Click on search button
   Then User should find Name in the Search table
   And close browser
    
    
    
    
    
    
    
    
    
    
    
    
    