package qaclickacdemy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.commonUtilis.BaseClass;
import com.pageObjects.HomePage;

public class TestClass extends BaseClass {
	private static Logger log = LogManager.getLogger(TestClass.class.getName());
	public WebDriver driver;
	HomePage pg;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialize ");
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));
		log.info("Navigated to the Url ");

	}

	@Test
	public void RegistraationFlow() {
		HomePage home = new HomePage(driver);
		home.AllowCookies().click();
		home.AccountIocn().click();
//		home.CreateAnAcccount().click();

	}

//	@AfterTest
//	public void tearDown() {
//		driver.close();
//
//	}
}