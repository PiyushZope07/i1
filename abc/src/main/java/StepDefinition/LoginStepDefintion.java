package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;

public class LoginStepDefintion {
WebDriver driver;

	@Given("^User is already on Login Page$")
	public void User_Already_On_Login_Page() {
		
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com");
}
	
	@When("^title of login page is Free CRM $")
	public void titlelogin() {
		String title=driver.getTitle();
		System.out.println(title);
	}
}
