package automate.salesforce;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MergeAccountsTC13 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception{
		launchBrowser("ch");
		login(false);
		Thread.sleep(2000);
		
		
		
		// Click on Account Tab
		WebElement accountsTab = driver.findElement(By.xpath("//a[contains(text(),'Accounts')]"));
		waitForVisibility(accountsTab);
		accountsTab.click();
		//Thread.sleep(2000);
		
		// Dismiss prompt window for switch to lightening experience
		WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
		if (promptEle.isDisplayed()) {
			waitForVisibility(promptEle);
			promptEle.click();
		}
		
		
		//click on merge accounts link
		WebElement mergeAccounts = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
		waitForVisibility(mergeAccounts);
		mergeAccounts.click();
		//Thread.sleep(2000);
		
		//Enter the account name to search
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='srch']"));
		waitForVisibility(searchBox);
		searchBox.sendKeys("primary");
		//Thread.sleep(2000);
		
		//click on find accounts
		WebElement findAccounts = driver.findElement(By.xpath("//input[contains(@name,'srchbutton')]"));
		waitForVisibility(findAccounts);
		findAccounts.click();
		//Thread.sleep(2000);
		
		
		//Select first two records to merge
		////table/tbody/tr[2]/th[1]
		List<WebElement> li_rows =driver.findElements(By.xpath("//table[contains(@class,'list')]//tbody/tr"));
		System.out.println("rows count" +li_rows.size());
		for(int count = 1; count < li_rows.size(); count++) {
			System.out.println("row " +li_rows.get(count).getText());
			String str = driver.findElement(By.xpath("//table/tbody/tr[" +(count+1)+"]/td[1]")).getText();
			System.out.println("str " + str);
			if(li_rows.get(count).isSelected() && count <= 2) {
				driver.findElement(By.xpath("//table/tbody/tr[" +(count+1)+"]/th[1]")).click();
			} else if(!li_rows.get(count).isSelected() && count > 2) {
				driver.findElement(By.xpath("//table/tbody/tr[" +(count+1)+"]/th[1]")).click();
			}
		}
		
		Thread.sleep(2000);
		
		
		WebElement nextBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'goNext')]"));
		waitForVisibility(nextBtn);
		nextBtn.click();
		Thread.sleep(2000);
		
		WebElement mergeBtn = driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[contains(@name,'save')]"));
		waitForVisibility(mergeBtn);
		mergeBtn.click();
		Thread.sleep(2000);
		
		Alert al = driver.switchTo().alert();
		System.out.println("alert after merge : " + al.getText());
		al.accept();
		
		Thread.sleep(4000);
		quitBrowser();
	}
}
