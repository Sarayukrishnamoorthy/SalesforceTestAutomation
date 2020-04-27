package automate.salesforce;


public class LogoutTC09 extends BrowserUtitlity {

	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		login(false);
		Thread.sleep(2000);
		logout();
		
		Thread.sleep(2000);
		quitBrowser();
		
	}
}
