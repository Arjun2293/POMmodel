package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class HomePage extends BasePage {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	//setting page Objects
	@FindBy(xpath = "//label[contains(text(),'One way')]")
	public WebElement oneWayBtn;
	@FindBy(xpath = "//input[@name='Origin']")
	public WebElement frmLocation;
	@FindBy(xpath = "//input[@name='Destination']")
	public WebElement toLocation;
	@FindBy(xpath = "//input[@name='StartDate']")
	public WebElement startDate;
	@FindBy(xpath = "//select[@name='AdultsFlight']")
	public WebElement adultCountDD;
	@FindBy(xpath = "//i[contains(text(),'Find flights')]")
	public WebElement findFlightBtn;
	@FindBy(xpath="//a[contains(text(),'Air India')]")
	public WebElement airIndiaLink;

	// Defining Functions
	public void clickOnOneWayBtn() {
		oneWayBtn.click();
	}

	public void enterFromLocation(String dataFrmLocation) {
		insertTextData(frmLocation, dataFrmLocation);
	}

	public void enterToLocation(String dataToLocation) {
		insertTextData(toLocation, dataToLocation);
	}

	public void clickOnStartDate() {
		startDate.click();
	}

	public void enterStartDate(String dataStartDate) {
		insertTextData(startDate, dataStartDate);
	}

	public void selectAdultCount(String dataAdultCount) {
		selectDdByValue(adultCountDD, dataAdultCount);

	}

	public void clickOnFindFlightsBtn() {
		findFlightBtn.click();
	}
	//returning parent window since it launches new window
	public String clickOnAirIndiaLink() {
		String parent=null;
		parent=driver.getWindowHandle();
		airIndiaLink.click();
		return parent;
	}
}
