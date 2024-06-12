import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class myTestcases {

	WebDriver driver = new ChromeDriver();
	String URL = "https://www.saucedemo.com/";
	String userName = "standard_user";
	String password = "secret_sauce";

	@BeforeTest
	public void mySetup() {
		driver.get(URL);

	}

	@Test(priority = 1)
	public void loginTest() {

		WebElement userNameinput = driver.findElement(By.id("user-name"));
		userNameinput.sendKeys(userName);
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);
		WebElement button = driver.findElement(By.id("login-button"));
		button.click();

	}

	@Test(priority = 2, enabled = false)
	public void addAllitems() {

		List<WebElement> myAddtoCartButtons = driver.findElements(By.className("btn"));

//		System.out.println(myAddtoCartButtons.size());

		for (int i = 0; i < myAddtoCartButtons.size(); i++) {
			myAddtoCartButtons.get(i).click();
		}
	}

	@Test(priority = 3, enabled = false)
	public void addAllitemsexceptNumber3() {

		List<WebElement> myAddtoCartButtons = driver.findElements(By.className("btn"));

//		System.out.println(myAddtoCartButtons.size());

		for (int i = 0; i < myAddtoCartButtons.size(); i++) {
			if (i == 2) {
				continue;
			}
			myAddtoCartButtons.get(i).click();
		}
	}

	@Test(priority = 4)
	public void addItemsHasTextLabs() {

		List<WebElement> myAddtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> myItemsname = driver.findElements(By.className("inventory_item_name"));

//		System.out.println(myAddtoCartButtons.size());

		for (int i = 0; i < myItemsname.size(); i++) {

			String itemsName = myItemsname.get(i).getText();
			if (itemsName.contains("Labs")) {
				myAddtoCartButtons.get(i).click();
			}

		}
	}

}
