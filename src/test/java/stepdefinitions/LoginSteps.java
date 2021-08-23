package stepdefinitions;

import org.junit.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("User opens URL {string}")
	public void user_opens_url(String url) {
		DriverFactory.getDriver().get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    loginPage.enterEmail(email);
	    loginPage.enterPassword(password);
	}

	@When("Clicks on Login button")
	public void click_on_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    
		if(DriverFactory.getDriver().getPageSource().contains("Login was unsuccessful.")) {
			DriverFactory.getDriver().close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(expectedTitle, DriverFactory.getDriver().getTitle());
		}
		
	}

	@When("User clicks on Logout link")
	public void user_clicks_on_logout_link() {
		loginPage.clickLogoutLink();
	}

}
