package freeCRM;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	ChromeDriver driver;
	public String dataSheetName;
	@BeforeMethod
	public void runPreCondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		driver.get("https://in.freecrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	}
	
	@AfterMethod
	public void runPostCondition() {
		
		driver.close();
	}
	@DataProvider
	public Object[][] setData() throws IOException {
			return DataExcel.readData(dataSheetName);
		
	}
	

}
