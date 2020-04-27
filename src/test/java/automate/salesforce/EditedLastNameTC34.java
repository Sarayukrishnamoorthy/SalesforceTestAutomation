package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditedLastNameTC34 extends BrowserUtitlity {
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		
		WebElement userNavBtn = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn);
		userNavBtn.click();
		Thread.sleep(2000);
		
		WebElement myProfile =  driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		waitForVisibility(myProfile);
		myProfile.click();
		Thread.sleep(2000);
		
		waitForVisibility(driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")));
		driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']//img")).click();
		Thread.sleep(2000);
		
		
		//WebElement aboutFrameEle = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame("contactInfoContentId");
		driver.findElement(By.id("aboutTab")).click();
		Thread.sleep(2000);
		
		WebElement lastNameEle = driver.findElement(By.id("lastName"));
		lastNameEle.click();
		lastNameEle.clear();
		lastNameEle.sendKeys("ABCD");
		
		WebElement saveAllEle = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveAllEle.click();
		Thread.sleep(2000);
		
		WebElement userNavBtn1 = driver.findElement(By.xpath("//div[@id='userNavButton']"));
		waitForVisibility(userNavBtn1);
		System.out.println("user Menu button text: " + userNavBtn1.getText());
		String userNameStr1 = (userNavBtn1.getText().split(" "))[1];
		Thread.sleep(2000);
		
		
		WebElement userNavlabel = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
		waitForVisibility(userNavlabel);
		System.out.println("userName text in MyProfile Page: " + userNavlabel.getText());
		String userNameStr2 = (userNavlabel.getText().split(" "))[1];
		
		Thread.sleep(2000);
		
		String updatedStr ="ABCD";
		System.out.println("updated name : " + updatedStr);
		if (userNameStr1.equals(updatedStr) && userNameStr2.equals(updatedStr) ) {
			System.out.println("Success : Last Name is updated in all places");
		} else {
			System.out.println("Failed : Last Name is not updated.");
		}
				
		
		Thread.sleep(2000);
		quitBrowser();
		
	}
}

