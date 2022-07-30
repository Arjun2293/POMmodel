package base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	private static Properties config = new Properties();
	private static FileInputStream fis;
	public static WebDriver driver;
	

	/// <summary>
	/// To Start Browser
	/// </summary>
	@BeforeTest
	public  void setup() throws IOException {
		// Loading the Config Properties
		String filePath = System.getProperty("user.dir") + "\\Resources\\Config.property";
		fis = new FileInputStream(filePath);
		config.load(fis);
		if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (config.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
