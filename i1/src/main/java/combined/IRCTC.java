package combined;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class IRCTC {

	WebDriver driver;
	JavascriptExecutor js;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement okbutton;
	
	@FindBy(xpath="//app-header/div[1]/div[2]/a[1]/i[1]")
	WebElement panel;
	
	@FindBy(xpath="//button[contains(text(),'LOGIN')]")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[contains(@formcontrolname,'userid') and contains(@placeholder,'User Name')]")
	WebElement uname;
	
	@FindBy(xpath="//*[contains(@formcontrolname,'password') and contains(@placeholder,'Password')]")
	WebElement pass;
	
	@FindBy(xpath="//*[@id=\"login_header_disable\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/form/span/button")
	WebElement signin;
	
		
	@FindBy(xpath="//*[contains(@aria-controls,'pr_id_1_list') and contains(@role,'searchbox')]")
	WebElement source;
	
	@FindBy(xpath="//*[contains(@class,'ng-star-inserted') and contains(text(),'KALYAN JN - KYN')]")
	WebElement sourcelist;
	
	@FindBy(xpath="//*[contains(@aria-controls,'pr_id_2_list') and contains(@role,'searchbox')]")
	WebElement destination;
	
	@FindBy(xpath="//*[contains(@class,'ng-tns-c57-9 ng-star-inserted') and contains(text(),'PUNE JN - PUNE')]")
	WebElement destinationlist;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement searchbutton;
	
	@FindBy(xpath="//*[contains(@class,'ng-tns-c17-0 ui-toast ui-widget ui-toast-top-right')]")
	WebElement emptyerror;
	
	
	@FindBy(css="body")
	WebElement tab;
	
	@FindBy(id="inputPnrNo")
	WebElement inputpnrno;
	
	@FindBy(id="modal1")
	WebElement pnrbut;
	
	@FindBy(id="submitPnrNo")
	WebElement captchasubmitbutton;
	
	@FindBy(xpath="//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")
	WebElement pnrenquirybutton;
	
	@FindBy(xpath="//*[@id=\"psgnDetailsTable\"]/tbody/tr/td[3]")
	WebElement pnrmsg;
	
	@FindBy(id="errorMessage")
	WebElement errormsg;
	
	
	
	@FindBy(xpath="//*[@id=\"divMain\"]/div/app-train-list/div[4]/div[1]/div[5]/div[1]/div[1]/app-train-avl-enq/div[1]/div[5]/div[1]/table/tr/td[3]/div/div[2]/span")
	WebElement tier;
	
	@FindBy(xpath="//*[@id=\"divMain\"]/div/app-train-list/div[4]/div[1]/div[5]/div[1]/div[1]/app-train-avl-enq/div[1]/div[7]/div[1]/div[3]/table/tr/td[2]/div")
	WebElement clavailable;
	
	@FindBy(xpath="//*[contains(@type,'button') and contains(@class,'btnDefault train_Search ng-star-inserted')]")
	WebElement bookbutton;
	
	@FindBy(xpath="//span[contains(text(),'I Agree')]")
	WebElement iagreebutton;
	
		
	@FindBy(xpath="//*[@id=\"ui-panel-12-content\"]/div/div[1]/div[2]/div/app-passenger/div/div[1]/span/div[1]/p-autocomplete/span/input")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"ui-panel-12-content\"]/div/div[1]/div[2]/div/app-passenger/div/div[1]/span/div[2]/input")
	WebElement age;
	
	@FindBy(xpath="//*[@id=\"ui-panel-12-content\"]/div/div[1]/div[2]/div/app-passenger/div/div[1]/span/div[3]/select")
	WebElement gender;
	
	@FindBy(xpath="//*[@id=\"ui-panel-12-content\"]/div/div[1]/div[2]/div/app-passenger/div/div[1]/div[1]/select")
	WebElement birthpref;
	
	@FindBy(id="mobileNumber")
	WebElement mobileno;
	
	@FindBy(xpath="//*[@id=\"psgn-form\"]/form/div/div[1]/div[14]/div/button[2]")
	WebElement submitbooking;
	
	@FindBy(xpath="//*[@id=\"review\"]/div[1]/form/div[3]/div/button[2]")
	WebElement review;
	
	@FindBy(xpath="//*[@id=\"divMain\"]/div/app-review-booking/p-toast/div/p-toastitem/div/div/div/div[2]")
	WebElement Wocaptcha;
	
		
	@FindBy(xpath="//*[@id=\"slide-menu\"]/p-sidebar/div/nav/ul/li[3]/label/span[1]/strong")
	WebElement trains;
	
	@FindBy(xpath="//*[@id=\"slide-menu\"]/p-sidebar/div/nav/ul/li[3]/ul/li[5]/label/span[1]")
	WebElement cticket;
	
	@FindBy(xpath="//*[@id=\"slide-menu\"]/p-sidebar/div/nav/ul/li[3]/ul/li[5]/ul/li[1]/a/span")
	WebElement eticket;

	public void searchButton() {
		searchbutton.click();
	}
	
	public void tierButton() {
		tier.click();
	}
	
	public void clAvailableButton() {
		clavailable.click();
	}
	
	public void bookButton() {
		bookbutton.click();
	}
	
	public void iAgreeButton() {
		iagreebutton.click();
	}
	
	public void setUsername(String username)
	{
		uname.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		pass.sendKeys(password);
	}
	
	public void signin() {
		signin.click();
	}
	
	public void passengerName(String pname) {
		name.sendKeys(pname);
	}
	
	public void passengerAge(String page) {
		age.sendKeys(page);
	}
		
	public void Gender() {
		Select genderCategory= new Select(gender);
		genderCategory.selectByVisibleText("Male");
	}
	
	public void Birth() {
		Select birthprefCategory= new Select(birthpref);
		birthprefCategory.selectByVisibleText("Lower");
	}
	
	public void mobileNumber(String mno) {
		mobileno.sendKeys(mno);
	}
	
	public void submitButton() {
		submitbooking.click();
	}
	
	public void pnrSubmit() {
		pnrbut.click();
	}
	
	public void reviewButton() {
		review.click();
	}
	
	public String withoutCaptcha() {
		return Wocaptcha.getText();
	}
	
	public IRCTC(WebDriver driver) {
		this.driver=driver;
		this.js = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void okButton() {
		okbutton.click();
	}
	
	public void panelClick() {
		panel.click();
	}
	
	public void loginButton() {
		loginbutton.click();
	}
	
	
	
		
	public void source(String src) {
		source.sendKeys(src);
	}
	
	public void sourceList() {
		sourcelist.click();
	}
	
	public void destination(String dest) {
		destination.sendKeys(dest);
	}
	
	public void destinationList() {
		destinationlist.click();
	}
	
	public boolean sourceAvailable() {
		return sourcelist.isDisplayed();
	}
	
	public boolean destinationAvailable() {
		return destinationlist.isDisplayed();
	}
	
	
	public String error() {
		return emptyerror.getText();
	}
	
	public void tabSwitch() {
		tab.sendKeys(Keys.CONTROL + "t");
	}
	
	public void pnrInput(String pnrno) {
		inputpnrno.sendKeys(pnrno);
	}
	
	public void tabSwitch1() {
		tab.sendKeys(Keys.CONTROL + "\t");
	}
	
	
	
	public void captchaSubmitButton() {
		captchasubmitbutton.click();
	}
	
	public void pnrEnquiryButton() {
		pnrenquirybutton.click();
	}
	
	public String confirmPnrMsg() {
		return pnrmsg.getText();
	}
	
	public String WaitingPnrMsg() {
		return pnrmsg.getText();
	}
	
	public String errorMsg() {
		return errormsg.getText();
	}
	
	public void js250() {
		js.executeScript("window.scrollBy(0,250)", "");
	}
	
	public void js500() {
		js.executeScript("window.scrollBy(0,500)", "");
	}
	
	public void js550() {
		js.executeScript("window.scrollBy(0,550)", "");
	}
	public void trains() {
		js.executeScript("arguments[0].click();",trains);
	}
	
	public void cTicket() {
		js.executeScript("arguments[0].click();",cticket);
	}
	public void eTicket() {
		js.executeScript("arguments[0].click();",eticket);	
		}
	
	public void afterPanel() {
		js.executeScript("arguments[0].click();",panel);
	}
}
