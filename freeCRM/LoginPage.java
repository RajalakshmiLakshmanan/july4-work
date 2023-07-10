package freeCRM;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage extends BaseClass {
	@BeforeTest
	public void data() {
		dataSheetName = "login";
		
	}
	@Test(dataProvider="setData")
	public void runLoginPage(String email,String password) {
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals("Cogmento CRM", title);
		
		
	}

}
