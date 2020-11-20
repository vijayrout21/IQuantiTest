package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	protected WebDriver driver;
	public HomePage(WebDriver driver) 
	{           
	   this.driver = driver; 
	   PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h5[normalize-space()='Our top picks']")
	private WebElement ourTopPickLink;
	
	public WebElement getOurTopPickLink() {
		return ourTopPickLink;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Personal loans']")
	private WebElement personalLoanLink;
	
	public WebElement getPersonalLoanLink() {
		return personalLoanLink;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Compare debt consolidation loans']")
	private WebElement compareDebtLink;
	
	public WebElement getCompareDebtLink() {
		return compareDebtLink;
	}
	
	@FindBy(xpath="//div/h1[@class='_1fKjQ _7NymO']")
	private WebElement header1;
	
	public WebElement getHeader1() {
		return header1;
	}
	
	@FindBy(xpath="//input[@id='offer-shopping-experience-1-3-input']")
	private WebElement annualIncome;
	
	public WebElement getAnnualIncome() {
		return annualIncome;
	}
	
	@FindBy(xpath="//div[@id='PL-14-undefined-0']/div/a")
	private WebElement upStart;
	
	public WebElement getUpStart() {
		return upStart;
	}
	
	@FindBy(xpath="//div[@id='PL-14-undefined-0']//span[contains(text(),'$')]")
	private WebElement upStartMoPayment;
	
	public WebElement getUpStartMoPayment() {
		return upStartMoPayment;
	}
	
	@FindBy(xpath="//div[@id='PL-12-undefined-1']/div/a")
	private WebElement prosper;
	
	public WebElement getProsper() {
		return prosper;
	}
	
	@FindBy(xpath="//div[@id='PL-12-undefined-1']//span[contains(text(),'$')]")
	private WebElement prosperMoPayment;
	
	public WebElement getProsperMoPayment() {
		return prosperMoPayment;
	}
	
	@FindBy(xpath="//div[@id='PL-8-undefined-2']/div/a")
	private WebElement oneMainF;
	
	public WebElement getOneMainF() {
		return oneMainF;
	}
	
	@FindBy(xpath="//div[@id='PL-8-undefined-2']//span[contains(text(),'$')]")
	private WebElement oneMainFMoPayment;
	
	public WebElement getOneMainFMoPayment() {
		return oneMainFMoPayment;
	}
	
	@FindBy(xpath="//span[contains(text(),'Student loans')]")
	private WebElement studentLoans;
	
	public WebElement getStudentLoans() {
		return studentLoans;
	}
	
	@FindBy(xpath="//span[contains(text(),'Compare refinance student loans')]")
	private WebElement compareRefinanceStudentLoans;
	
	public WebElement getCompareRefinanceStudentLoans() {
		return compareRefinanceStudentLoans;
	}
	
	@FindBy(id="stateFilter")
	private WebElement stateDropdown;
	
	public WebElement getStateDropdown() {
		return stateDropdown;
	}
	
	@FindBy(id="creditScoreFilter")
	private WebElement creditScoreDropdown;
	
	public WebElement getCreditScoreDropdown() {
		return creditScoreDropdown;
	}
	
	@FindBy(id="annualIncomeFilter")
	private WebElement annualIncomeTextBox;
	
	public WebElement getAnnualIncomeTextBox() {
		return annualIncomeTextBox;
	}
	
	@FindBy(id="educationCompletedFilter")
	private WebElement educationCompletedDropDown;
	
	public WebElement geteducationCompletedDropDown() {
		return educationCompletedDropDown;
	}
	
	@FindBy(id="loanAmountFilter")
	private WebElement loanAmountFilter;
	
	public WebElement getLoanAmountFilter() {
		return loanAmountFilter;
	}
	
	@FindBy(xpath="//button[contains(text(),'See your options')]")
	private WebElement seeYourOptionsBtn;
	
	public WebElement getSeeYourOptionsBtn() {
		return seeYourOptionsBtn;
	}
	
	@FindBy(xpath="//h1[@class='_1fKjQ _7NymO']")
	private WebElement studentHeader;
	
	public WebElement getStudentHeader() {
		return studentHeader;
	}
	
	@FindBy(id="offer-shopping-experience-1-1-input")
	private WebElement loanBalance;
	
	public WebElement getLoanBalance() {
		return loanBalance;
	}
	
	@FindBy(xpath="//img[@src='https://www.nerdwallet.com/cdn/img/Loans/EarnestLogo.svg']")
	private WebElement earnest;
	
	public WebElement getEarnest() {
		return earnest;
	}
	
	@FindBy(xpath="//img[@src='https://www.nerdwallet.com/cdn/loans/edu/SoFi_horz_RGB_Turquoise_CircleR_Upward.png']")
	private WebElement sofi;
	
	public WebElement getSofi() {
		return sofi;
	}
	
	
}
