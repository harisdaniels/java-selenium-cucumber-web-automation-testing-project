package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.WaitHelper;

public class LoginPage {
	
	private WebDriver driver;
	private WaitHelper waitHelper;
	
	//1. By Locators
	private By emailField = By.id("Email");
	private By passwordField = By.id("Password");
	private By loginButton = By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	private By logoutLink = By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");
	
	
	//2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		waitHelper = new WaitHelper(driver);
	}
	
	//3. Page Actions
	
	public void enterEmail(String email) {
		waitHelper.waitForElement(driver.findElement(emailField), 30);
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		waitHelper.waitForElement(driver.findElement(passwordField), 30);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(pass);
	}
	
	public void clickLoginButton() {
		waitHelper.waitForElement(driver.findElement(loginButton), 30);
		driver.findElement(loginButton).click();
	}
	
	public void clickLogoutLink() {
		waitHelper.waitForElement(driver.findElement(logoutLink), 30);
		driver.findElement(logoutLink).click();
	}
	
	public AddCustomersPage doLogin(String email, String password) {
		System.out.println("Login with doLogin Function: " + email + " and " + password);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(loginButton).click();
		return new AddCustomersPage(driver);
	}

}
