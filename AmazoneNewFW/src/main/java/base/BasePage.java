package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import base.BaseTest;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest  {

	/// <summary>
		/// To insert data into text box
		/// </summary>
		public void insertTextData(WebElement element, String dataToInsert) {
			element.clear();
			element.sendKeys(dataToInsert);
		}

		/// <summary>
		/// To select value from dropdown
		/// </summary>
		public void selectDdByValue(WebElement element, String value) {
			Select dropDown = new Select(element);
			dropDown.selectByValue(value);
		}

		/// <summary>
		/// To switch to ChildWindow
		/// </summary>
		public void switchToChildWindow() {
			for (String window : driver.getWindowHandles()) {
				driver.switchTo().window(window);
			}
		}

		/// <summary>
		/// To switch to ParentWindow
		/// </summary>
		public void switchToParentWindow(String parent) {
			driver.switchTo().window(parent);
		}

		/// <summary>
		/// To drag an drop
		/// </summary>
		public void dragAndDrop(WebElement element1, WebElement element2) {
			Actions act = new Actions(driver);
			act.dragAndDrop(element1, element2);
		}

		/// <summary>
		/// To defineExplicitwait
		/// </summary>
		public void waitTillElementVisible(WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
		

		/// <summary>
		/// To get screenshot
		/// </summary>
		
}
