package automate.salesforce;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class BlockDateForEventTC36 extends BrowserUtitlity {
	
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement homeBtn = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
		waitForVisibility(homeBtn);
		homeBtn.click();
		Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		WebElement todaysDate =  driver.findElement(By.xpath("//span[contains(@class,'pageDescription')]"));
		waitForVisibility(todaysDate);
		System.out.println("username date link : " + todaysDate.getText());
		driver.findElement(By.linkText(todaysDate.getText())).click();
		Thread.sleep(2000);
		
		
		WebElement eightpmBtn = driver.findElement(By.xpath("//a[contains(text(),'8:00 PM')]"));
		waitForVisibility(eightpmBtn);
		eightpmBtn.click();
		Thread.sleep(2000);
		
		
		WebElement comboboxBtn = driver.findElement(By.xpath("//img[contains(@class,'comboboxIcon')]"));
		waitForVisibility(comboboxBtn);
		comboboxBtn.click();
		Thread.sleep(2000);
		String handleWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		String[] window = windows.toArray(new String[windows.size()]);
		driver.switchTo().window(window[1]);
		
		driver.manage().window().maximize();
		
		waitForVisibility(driver.findElement(By.xpath("//a[contains(text(),'Other')]")));
		Thread.sleep(1000);
		WebElement secondWindEle = driver.findElement(By.xpath("//a[contains(text(),'Other')]"));
		String OtherText = secondWindEle.getText();
		driver.close();
		driver.switchTo().window(handleWindow);
		Thread.sleep(3000);
		
		WebElement subjectEle = driver.findElement(By.xpath("//input[@id='evt5']"));
		waitForVisibility(subjectEle);
		subjectEle.sendKeys(OtherText);
		Thread.sleep(2000);
		
		
		//System.out.println(driver.getTitle());
		WebElement EndDate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		waitForVisibility(EndDate);
		EndDate.click();
		Thread.sleep(2000);
		
		WebElement Enddatadropdown = driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
		waitForVisibility(Enddatadropdown);
		Enddatadropdown.click();
		
		
		WebElement saveBtn = driver.findElement(By.xpath("//div[@id='ep']//div[contains(@class,'pbHeader')]//input[1]"));
		waitForVisibility(saveBtn);
		saveBtn.click();
		Thread.sleep(2000);

		Thread.sleep(3000);
		quitBrowser();
	}

}