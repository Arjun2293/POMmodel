package TestCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BasePage;
import pages.HomePage;
import utilities.DataUtill;

public class TC1 extends BasePage{
	HomePage homePage;

	@BeforeClass
	public void setup1() throws IOException {
		homePage = new HomePage();
	}

	@Test
	public void userSelectTravelType() {
		homePage.clickOnOneWayBtn();
	}

	@Test(dependsOnMethods = "userSelectTravelType",dataProviderClass = DataUtill.class, dataProvider = "dp1")
	public void userSelectTravelDetails(String source,String destination,String startDate,String adultCount) {
		homePage.enterFromLocation(source);
		homePage.enterToLocation(destination);
		homePage.clickOnStartDate();
		homePage.enterStartDate(startDate);
		homePage.selectAdultCount(adultCount);
		homePage.clickOnFindFlightsBtn();
	}

}
