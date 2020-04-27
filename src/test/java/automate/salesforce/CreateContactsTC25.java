package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateContactsTC25 extends BrowserUtitlity {
	//a[contains(text(),'Contacts')]

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		waitForVisibility(opportunitiesBtn);
		opportunitiesBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		//input[@name='new']
		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		waitForVisibility(newBtn);
		newBtn.click();
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
		String lName = ReadUserData.getUserData("lastName");
		lastName.sendKeys(lName);
		
		WebElement companyName = driver.findElement(By.xpath("//input[@id='con4']"));
		companyName.sendKeys("primary");
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		
		Thread.sleep(4000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}
