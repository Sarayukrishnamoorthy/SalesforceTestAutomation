package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateNewLeadTC24 extends BrowserUtitlity {
	
	

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		WebElement opportunitiesBtn = driver.findElement(By.xpath("//a[contains(text(),'Leads')]"));
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
		
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
		lastName.sendKeys("ABCD");
		
		WebElement companyName = driver.findElement(By.xpath("//input[@id='lea3']"));
		companyName.sendKeys("ABCD");
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		
		Thread.sleep(3000);
		logout();
		Thread.sleep(2000);
		quitBrowser();
	}
}
