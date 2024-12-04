package pageObjectClasses;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testData.DataFetch;
import testData.DatabaseHelper;

public class RegisterPage extends DataFetch {

	WebDriver driver;
	DatabaseHelper db ;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		db = new DatabaseHelper();

	}

	@FindBy(id = "gender-female")
	WebElement gender;

	@FindBy(id = "FirstName")
	WebElement firstname;

	@FindBy(id = "LastName")
	WebElement lastname;

	@FindBy(id = "Email")
	WebElement email;

	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpassword;

	@FindBy(id = "register-button")
	WebElement register;

	public void doUserRegisteration(String fname, String lname, String emailid, String pass, String confirmpass) {
		gender.click();
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		email.sendKeys(emailid);
		password.sendKeys(pass);
		confirmpassword.sendKeys(confirmpass);
		register.click();

	}

	public void doUserRegDatafromExcel(String sheetname, int rowno) throws IOException {

		List<String> UserData = fetchSpecificDataExcel(sheetname, rowno);
		gender.click();
		firstname.sendKeys(UserData.get(0));
		lastname.sendKeys(UserData.get(1));
		email.sendKeys(UserData.get(2));
		password.sendKeys(UserData.get(3));
		confirmpassword.sendKeys(UserData.get(4));
		register.click();
	}

	public void doUserRegDataFromDB() throws ClassNotFoundException, SQLException {
		List<String> UserData = db.fetchdbData1();
		gender.click();
		firstname.sendKeys(UserData.get(0));
		lastname.sendKeys(UserData.get(1));
		email.sendKeys(UserData.get(2));
		password.sendKeys(UserData.get(3));
		confirmpassword.sendKeys(UserData.get(4));
		register.click();

	}
	public void selectGender() {
		gender.click();
	}

	public void enterFname(String fname) {
		firstname.sendKeys(fname);
	}

	public void enterLname(String lname) {
		lastname.sendKeys(lname);
	}

	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}

	public void enterPass(String pass) {
		password.sendKeys(pass);
	}

	public void enterCPass(String confirmpass) {
		confirmpassword.sendKeys(confirmpass);
	}

	public void clickRegister() {
		register.click();
	}

	
}
