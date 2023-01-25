package combined;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FlightsLoginPage {
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement okbutton;
	
	@FindBy(xpath="//app-header/div[1]/div[2]/a[1]/i[1]")
	WebElement panel;
	
	@FindBy(xpath="//img[@id='disha-banner-close']")
	WebElement add;
	
	@FindBy(xpath="//app-header/div[@id='slide-menu']/p-sidebar[1]/div[1]/nav[1]/ul[1]/li[5]/a[1]/label[1]")
	WebElement flight;
	
	@FindBy(xpath="//button[contains(text(),'Allow')]")
	WebElement later;

	//@FindBy(xpath="//header/nav[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/a[1]")
	@FindBy(linkText="Login")
	WebElement Flogin;

	@FindBy(xpath="//input[@id='loginuserid']")
	WebElement Funame;
	
	@FindBy(xpath="//body/app-root[1]/app-index[1]/app-login[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")
	WebElement Fpass;
			

	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement Flogin2;
	
	//@FindBy(xpath="//input[@id='stationFrom'] and contains(@placeholder,'origin')")
//	WebElement from;
	
	@FindBy(id="stationFrom")
	WebElement from;
	
	@FindBy(xpath="//*[contains(@class,'ui-menu-item-wrapper') and contains(text(),'Mumbai (BOM)')]")
	WebElement fromclick;
	
	@FindBy(id="stationTo")
	WebElement to;
	
	@FindBy(xpath="//*[contains(@class,'ui-menu-item-wrapper') and contains(text(),'Bengaluru (BLR)')]")
	WebElement toclick;
	
	@FindBy(id="originDate")
	WebElement date;
	
	@FindBy(xpath="//tbody/tr[4]/td[5]/span[1]")
	WebElement dateclick;
	
	@FindBy(xpath="//body/app-root[1]/app-index[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[6]/button[1]")
	WebElement search;
	
	@FindBy(xpath="//body/app-root[1]/app-oneway[1]/div[1]/main[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[6]/button[1]")
	WebElement disp;
	
	@FindBy(xpath="//body/app-root[1]/app-bookingdetail[1]/section[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
	WebElement Bfname;
	
	@FindBy(xpath="/html/body/app-root/app-bookingdetail/section/div[2]/div/div[1]/form/div[1]/div[2]/div[1]/div[3]/input")
	WebElement Blname;
	
	@FindBy(id="loginuserid")WebElement Busername;
	
	@FindBy(xpath="//body/app-root[1]/app-bookingdetail[1]/section[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/select[1]")
	WebElement nselec1;
	
	@FindBy(xpath="//option[contains(text(),'Mr.')]")
	WebElement nselec2;
	
	@FindBy(xpath="//select[@id='State']")
	WebElement sselec1;
	
	@FindBy(xpath="//option[contains(text(),'Delhi')]")
	WebElement sselec2;
	
	@FindBy(xpath="//a[@id='dropdown11']")
	WebElement profile;
	
	
	@FindBy(xpath="//app-header/p-dialog[2]/div[1]")
	WebElement profile2;
	
	@FindBy(xpath="//a[contains(text(),'My Account')]")
	WebElement myacc;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//a[@id='bookedticket-tab']")
	WebElement bookedticket;
	
	@FindBy(xpath="//a[@id='cancellation-tab']")
	WebElement cancelation;
	
	@FindBy(xpath="//a[@id='profileDetail-tab']")
	WebElement fullprofile;
	
	public FlightsLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void okbutton() {
		okbutton.click();
	}
	
	public void panel() {
		panel.click();
	}
	
	public void add(){
		add.click();
	}
	
	public void flight() {
		flight.click();
	}
	
	public void later() {
		later.click();
	}
	
	public void Flogin() {
		Flogin.click();
	}
	
	public void Funame(String src1) {
		Funame.sendKeys(src1);
	}
	public void Fpass(String src2) {
		Fpass.sendKeys(src2);
	}
	public void Flogin2() {
		Flogin2.click();
	}
	
	//test case 2
	public void from(String src3) {
		from.click();
		from.sendKeys(src3);
	}
	public void fromclick() {
		fromclick.click();
	}
	public void to(String src4) {
		from.click();
		to.sendKeys(src4);
	}
	public void toclick() {
		toclick.click();
	}
	public void date() {
		date.click();
	}
	public void dateclick() {
		dateclick.click();
	}
	public void search() {
		search.click();
	}
	public void disp() {
		disp.isDisplayed();
	}
	public void book() {
		disp.click();
	}
	public void Bfname(String src5) {
		Bfname.sendKeys(src5);
	}
	public void Blname(String src6) {
		Blname.sendKeys(src6);
	}
	public void Busername(String src7) {
		Busername.sendKeys(src7);
	}
	public void nselec1() {
		nselec1.click();
	}
	public void nselec2() {
		nselec2.click();
	}
	public void sselec1() {
		sselec1.click();
	}
	public void sselec2() {
		sselec2.click();
	}
	public void profile() {
		profile.click();
	}
	public void myacc() {
		myacc.click();
	}
	public void logout() {
		logout.click();
	}
	public void bookedticket() {
		bookedticket.click();
	}
	public void cancelation() {
		cancelation.click();
	}
	public void fullprofile() {
		fullprofile.click();
	}
	public void profile2() {
		profile2.click();
	}
}
