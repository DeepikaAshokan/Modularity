package pageObject;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjectClasses.CommonPage;
import pageObjectClasses.LoginPage;
import pageObjectClasses.RegisterPage;
import testData.DatabaseHelper;

public class DemoWebTest {

	WebDriver driver = new ChromeDriver();

	CommonPage common = new CommonPage(driver);
	LoginPage login = new LoginPage(driver);
	RegisterPage register = new RegisterPage(driver);
	DatabaseHelper dbhelper = new DatabaseHelper();

	public void runRegisterTest() {
		common.launchApp();
		common.clickOnRegister();
		register.doUserRegisteration("Siana", "haran", "sianaharan@123.com", "123456", "123456");
	}

	public void runLoginTest() {
		common.launchApp();
		common.clickOnLogin();
		login.doUserLogin("hari@123.com", "987654");
	}

	public void runRegisterdatafromExcel() throws IOException {
		common.launchApp();
		common.clickOnRegister();
		register.doUserRegDatafromExcel("Marks", 3);
		common.getRegisteredEmailID();
		common.writeRegisteredEmailExcel("RegisteredData");

	}

	public void fetchdatafromDatabase() throws ClassNotFoundException, SQLException {
		//dbhelper.fetchdbData1();
		dbhelper.task();
	}

	public void runRegisterdatafromdb() throws ClassNotFoundException, SQLException, IOException {
		common.launchApp();
		common.clickOnRegister();
		register.doUserRegDataFromDB();
		common.getRegisteredEmailID();
		common.writeRegisteredEmailExcel("RegisteredData");

	}

	public static void main(String[] args)
			throws InterruptedException, IOException, ClassNotFoundException, SQLException {
		DemoWebTest demo = new DemoWebTest();
		// demo.runRegisterTest();
		// demo.runLoginTest();
		// demo.runRegisterdatafromExcel();
		demo.fetchdatafromDatabase();
		//demo.runRegisterdatafromdb();
	}

}
