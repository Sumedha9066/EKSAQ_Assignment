package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	@FindBy(id="wdm_username")
	WebElement userNameInputField;
	
	@FindBy(id="wdm_password")
	WebElement passwordInputField;
	
	@FindBy(name="wdm_login")
	WebElement loginButton;
	
	
	public LogInPage(WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginLink() {
		wait.until(ExpectedConditions.elementToBeClickable(loginLink));
		loginLink.click();
	}
	
	public void enterUserName(String userName) {
		wait.until(ExpectedConditions.visibilityOf(userNameInputField));
		userNameInputField.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		wait.until(ExpectedConditions.visibilityOf(passwordInputField));
		passwordInputField.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	
}
