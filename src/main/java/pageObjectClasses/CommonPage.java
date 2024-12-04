package pageObjectClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testData.DataFetch;

public class CommonPage {

	String baseurl = "https://demowebshop.tricentis.com/";

	WebDriver driver;
	DataFetch datafetch;

	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		datafetch = new DataFetch();

	}

	String registeredEmailID;

	@FindBy(css = ".ico-register")
	WebElement registerLink;

	@FindBy(css = ".ico-login")
	WebElement loginLink;

	@FindBy(css = ".ico-logout")
	WebElement logoutlink;

	@FindBy(css = ".header-links .account")
	WebElement registereduserEmailID;

	public void launchApp() {
		driver.get(baseurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickOnRegister() {
		registerLink.click();
	}

	public void clickOnLogin() {
		loginLink.click();
	}

	public void clickOnLogout() {
		logoutlink.click();
	}

	public void getRegisteredEmailID() {
		registeredEmailID = registereduserEmailID.getText();
		System.out.println(" The value of registered email ID is :  " + registeredEmailID);
	}

	public void writeRegisteredEmailExcel(String sheetname) throws IOException {
		datafetch.writeTOExcel(sheetname, registeredEmailID);
	}
}
