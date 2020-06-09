Feature: Login

Scenario: Successful Login with Valid Credentials

   Given user launch chrome browser
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then Page Title should be "Dashboard / nopCommerce administration"
   When User click on Log out link
   #Then page Title should be "your store. Login"
   And close browser
   
   
   Scenario Outline: Login Data Driven
    Given user launch chrome browser
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And user enters email as "<email>" and password as "<password>"
   And Click on Login
   Then Page Title should be "Dashboard / nopCommerce administration"
   When User click on Log out link
   #Then page Title should be "your store. Login"
   And close browser
   
    Examples: 
      | email  | password |
      | admin@yourstore.com |   admin    |
      | admin1@yourstore.com |     admin123   |

   