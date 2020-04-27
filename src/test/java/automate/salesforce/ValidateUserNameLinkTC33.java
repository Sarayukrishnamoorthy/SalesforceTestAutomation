package automate.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateUserNameLinkTC33 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		//span[@id='userNavLabel']
				launchBrowser("ch");
				WebDriver driver = BrowserUtitlity.driver;
				login(false);
//				ReadUserData userData = BrowserUtility.userData;
				String firstName = ReadUserData.getUserData("firstName");
				String lastName = ReadUserData.getUserData("lastName");
				Thread.sleep(3000);
				
				//<a id="tryLexDialogX" title="Close" tabindex="0" onmouseover="this.className = 'dialogCloseOn'" onmouseout="this.className = 'dialogClose'" onclick="var dlg = sfdcPage.getDialogById('tryLexDialog');dlg.closeButtonAction();dlg.cancel()" href="javascript:void(0)" class="dialogClose">Close</a>
				
				WebElement homeEle = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
				homeEle.click();
				Thread.sleep(3000);
				WebElement promptEle = driver.findElement(By.id("tryLexDialogX"));
				if (promptEle.isDisplayed()) {
					waitForVisibility(promptEle);
					promptEle.click();
				}
				
				//span[@id='userNavLabel']
				WebElement usernameLink = driver.findElement(By.linkText(firstName + " " + lastName));
				waitForVisibility(usernameLink);
				usernameLink.click();
				
				Thread.sleep(3000);
				quitBrowser();
	}

}
