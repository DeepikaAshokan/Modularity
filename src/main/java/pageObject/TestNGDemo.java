package pageObject;

import org.testng.annotations.*;

public class TestNGDemo {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("From the --- @BeforeSuite method ");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("From the --- @BeforeTest method ");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("From the --- @BeforeClass method ");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("From the --- @BeforeMethod method ");
	}

	@Test
	public void app1test1() {
		System.out.println("From the --- @app1tes01t method ");
	}

	@Test
	public void app1test2() {
		System.out.println("From the --- @app1test2 method ");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("From the --- @AeforeMethod method ");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("From the --- @AfterClass method ");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("From the --- @AfterTest method ");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("From the --- @AfterSuite method ");
	}

}
