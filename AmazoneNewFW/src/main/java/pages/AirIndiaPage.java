package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import base.BasePage;

public class AirIndiaPage extends BasePage {
	public AirIndiaPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Air India')]")
	public WebElement airIndiaPageHeader;

	public void verifyAirIndiaPageHeader(String expectedHeader) {
		String actualHeader = airIndiaPageHeader.getText();
		//System.out.println(actualHeader);
		Assert.assertEquals(expectedHeader.trim(), actualHeader.trim(), "Page header mismatch");
	}

}
