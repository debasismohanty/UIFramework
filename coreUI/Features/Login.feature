Feature: Login into nopCommerce
		
		@Login
    Scenario Outline: Login with valid credentials using data driven
    And User Enter email as "<Uname>" and password as "<pw>"
    And Click on Login  
    Then Page title should be "<title>"     
   
    Examples:
    |RequiredURL																|Uname									|pw						|title																			  |
    |http://admin-demo.nopcommerce.com/login		|admin@yourstore.com		|admin  			|Dashboard / nopCommerce administrations			|
   #|http://admin-demo.nopcommerce.com/login		|admin@yourstore.com		|admin1	  		|Your store. Loginsss		  								  |