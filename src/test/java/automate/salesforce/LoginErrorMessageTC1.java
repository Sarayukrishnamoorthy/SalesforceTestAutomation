package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginErrorMessageTC1 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		WebDriver driver = BrowserUtitlity.driver;
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle);
		String username = ReadUserData.getUserData("username");
		usernameEle.sendKeys(username);
		
		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));
		passwordEle.clear();
		
		WebElement loginEle = driver.findElement(By.xpath("//input[@id='Login']"));
		loginEle.click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='error']")).getText());
		Thread.sleep(3000);
		
		quitBrowser();
	}
}
