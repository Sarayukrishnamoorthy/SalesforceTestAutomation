package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestForgotPasswordTC4A extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		
		WebElement usernameEle = driver.findElement(By.id("username"));
		waitForVisibility(usernameEle);
		String username = ReadUserData.getUserData("username");
		usernameEle.sendKeys(username);
		
		WebElement forgotPwd = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		forgotPwd.click();

		waitForVisibility(driver.findElement(By.xpath("//input[@id='un']")));
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys(username);
		Thread.sleep(1000);
		
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id='continue']"));
		waitForVisibility(continueBtn);
		continueBtn.click();
		Thread.sleep(1000);
		
		WebElement linkSentMsg = driver.findElement(By.xpath("//p[contains(text(),'ve sent you an email with a link to finish rese')]"));
		waitForVisibility(linkSentMsg);
		System.out.println(linkSentMsg.getText());
		
		Thread.sleep(1000);
		quitBrowser();

	}

}
