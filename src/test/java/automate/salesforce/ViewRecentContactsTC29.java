package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ViewRecentContactsTC29 extends BrowserUtitlity {

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
		
		//List<WebElement> li_rows =driver.findElements(By.xpath("//table[contains(@class,'list')]//tbody/tr"));
		//System.out.println("rows count" +li_rows.size());
		//first contact link
		waitForVisibility(driver.findElement(By.xpath("//table/tbody/tr[2]/th[1]")));
		String str = driver.findElement(By.xpath("//table/tbody/tr[2]/th[1]")).getText();
		System.out.println("contact Name in link : " + str);

		driver.findElement(By.linkText(str)).click();
		Thread.sleep(5000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
	}

}

