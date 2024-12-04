package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "Email")
	WebElement email;
	@FindBy(id = "Password")
	WebElement pass;
	@FindBy(css = ".login-button")
	WebElement login;

	public void doUserLogin(String emailaddr, String passwd) {
		email.sendKeys(emailaddr);
		pass.sendKeys(passwd);
		login.click();
	}

	public void enterEmail(String emailaddr) {
		email.sendKeys(emailaddr);
	}

	public void enterpasswd(String passwd) {
		pass.sendKeys(passwd);

	}
	public void clickLogin() {
		login.click();

	}
}