package TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BasePage;
import pages.AirIndiaPage;
import pages.HomePage;
import utilities.DataUtill;

public class TC2 extends BasePage {
	HomePage homePage;
	AirIndiaPage airIndiaPage;

	@BeforeClass
	public void setup1() throws IOException {
		homePage = new HomePage();
		airIndiaPage = new AirIndiaPage();
	}

	@Test(dataProviderClass = DataUtill.class, dataProvider = "dp1")
	public void verifyNavigationToAirIndiaPage(String pageTitle) {
		String parentWindow = homePage.clickOnAirIndiaLink();
		System.out.println("Parent window = " + parentWindow);
		switchToChildWindow();
		airIndiaPage.verifyAirIndiaPageHeader(pageTitle);
		driver.close();
		switchToParentWindow(parentWindow);
	}

}
