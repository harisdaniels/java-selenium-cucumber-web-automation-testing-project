package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchCustomersPage;

public class SearchCustomersSteps {
	
	private SearchCustomersPage searchCustomer;
	
	
	// Search Customer by Email
	@When("User enters Customer Email")
	public void user_enters_customer_email() {
		searchCustomer = new SearchCustomersPage(DriverFactory.getDriver());
		searchCustomer.searchByEmail("brenda_lindgren@nopCommerce.com");
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() {
		searchCustomer.clickSearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status = searchCustomer.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	
	// Search Customer by Name
	@When("User enters Customer First Name")
	public void user_enters_customer_first_name() {
		searchCustomer = new SearchCustomersPage(DriverFactory.getDriver());
		searchCustomer.searchByFirstName("Victoria");
	}

	@When("User enters Customer Last Name")
	public void user_enters_customer_last_name() {
		searchCustomer.searchByLastName("Terces");
	}

	@Then("User should found their Name in the Search table")
	public void user_should_found_their_name_in_the_search_table() {
	    boolean status = searchCustomer.searchCustomerByName("Victoria", "Terces");
	    Assert.assertEquals(true, status);
	}

}
