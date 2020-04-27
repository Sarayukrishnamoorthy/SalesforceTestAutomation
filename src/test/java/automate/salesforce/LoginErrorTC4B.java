package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginErrorTC4B extends BrowserUtitlity{
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		WebDriver driver = BrowserUtitlity.driver;
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle);
		//userData = new ReadUserData();
		//String username = userData.getUserData("username");
		usernameEle.sendKeys("12324234");
		Thread.sleep(500);
		
		WebElement passwordEle = driver.findElement(By.xpath("//input[@id='password']"));
		passwordEle.sendKeys("123");
		Thread.sleep(500);
		
		WebElement loginEle = driver.findElement(By.xpath("//input[@id='Login']"));
		loginEle.click();
		
		System.out.println("Please check your user name : \n"+ driver.findElement(By.xpath("//div[@id='error']")).getText());
		Thread.sleep(1000);
		
		quitBrowser();
	}
}
