package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsSaveandNewTC32 extends BrowserUtitlity {

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
		
		WebElement newView = driver.findElement(By.xpath("//input[contains(@name,'new')]"));
		waitForVisibility(newView);
		newView.click();
		Thread.sleep(1000);
		
		WebElement lastName = driver.findElement(By.id("name_lastcon2"));
		waitForVisibility(lastName);
		lastName.sendKeys("Indian");
		Thread.sleep(1000);
		
		WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
		//accountName.sendKeys("Global Media");
		accountName.sendKeys("primary");
		Thread.sleep(3000);
		
		WebElement saveAndNew = driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@name='save_new']"));
		waitForVisibility(saveAndNew);
		saveAndNew.click();
		
		WebElement errorMsg = driver.findElement(By.xpath("//div[@id='errorDiv_ep']"));
		System.out.println("ContactsSaveandNewTC32 Error : " + errorMsg.getText());
		
		Thread.sleep(4000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}
