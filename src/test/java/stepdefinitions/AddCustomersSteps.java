package stepdefinitions;


import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import pages.AddCustomersPage;

public class AddCustomersSteps {
	
	private AddCustomersPage addCustomer;
	
	@Then("User can view the Dashboard")
	public void user_can_view_the_dashboard() {
		addCustomer = new AddCustomersPage(DriverFactory.getDriver());
		Assert.assertEquals("Dashboard / nopCommerce administration", addCustomer.getTitle());
	}

	@When("User clicks on Customers Menu")
	public void user_clicks_on_customers_menu() {
		addCustomer.clickCustomerMenu();	    
	}

	@When("Clicks on Customers Menu Item")
	public void clicks_on_customers_menu_item() {
		addCustomer.clickCustomerMenuItem();	
	}

	@When("Clicks on Add New button")
	public void clicks_on_add_new_button() {
		addCustomer.clickAddNewButton();
	}

	@Then("User can view Add New Customer Page")
	public void user_can_view_add_new_customer_page() {	    
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCustomer.getTitle());
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
	    String email = addCustomer.randomString() + "@gmail.com";
	    addCustomer.inputEmail(email);
	    addCustomer.inputPassword("test123");
	    
	    addCustomer.inputFirstName("Otong");
	    addCustomer.inputLastName("Surotong");
	    addCustomer.chooseGender("Male");
	    addCustomer.setDOB("1/1/1970");
	    addCustomer.inputCompanyName("Otong inc");
	    addCustomer.clickTaxExempt();
	    addCustomer.chooseNewsLetter("Test store 2");
	    addCustomer.chooseCustomerRoles("Guests");
	    addCustomer.chooseManagerVendor("Vendor 1");
	    addCustomer.setAdminComment("This is for Testing");
	}

	@When("Clicks on Save button")
	public void clicks_on_save_button() {
		addCustomer.clickOnSaveButton();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedMessage) {
	    Assert.assertTrue(DriverFactory.getDriver().findElement(By.tagName("body")).getText().contains(expectedMessage));
	}

}
