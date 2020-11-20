package pageActions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends pageObjects.HomePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void clickOurTopPicks() throws InterruptedException {
		getOurTopPickLink().click();
	}

	public void clickPersonalLoans() {
		getPersonalLoanLink().click();
	}

	public void clickCompareDebt() throws InterruptedException {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", getCompareDebtLink());
	}

	public void getHeaderValue() {

		String s = getHeader1().getText();
		if(s.contains("Compare your personal loan options")&& s.contains("for")&& s.contains("credit in")&&s.contains("CA")) {
			System.out.println("Header Present");
		}
		else {
			System.err.println("Header Not Present");
			Assert.assertTrue(false);
		}


	}

	public void enterAnnualIncome(String annualIncome) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getAnnualIncome()));
		getAnnualIncome().click();
		for(int i=0;i<7;i++) {
			getAnnualIncome().sendKeys(Keys.BACK_SPACE);
		}
		getAnnualIncome().sendKeys(annualIncome);
	}

	public void verifyUpStart() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getUpStart()));
		String href = getUpStart().getAttribute("href").toString();
		Assert.assertTrue(href.contains("Upstart"));
		String ActualMoPayment=getUpStartMoPayment().getText();
		Assert.assertEquals(ActualMoPayment, "$381");	

	}

	public void verifyProsper() {

		String href=getProsper().getAttribute("href").toString();
		Assert.assertTrue(href.contains("Prosper"));
		String actualMoPayment=getProsperMoPayment().getText();
		Assert.assertEquals(actualMoPayment, "$338");
	}

	public void verifyOneMain() {
		String href=getOneMainF().getAttribute("href").toString();
		Assert.assertTrue(href.contains("OneMain"));
		String actualMoPayment=getOneMainFMoPayment().getText();
		Assert.assertEquals(actualMoPayment, "$408");
	}

	public void clickStudentLoans() {
		getStudentLoans().click();
	}

	public void clickCompareRefinanceStudentLoans() {
		getCompareRefinanceStudentLoans().click();
	}

	public void selectStateOfResidence(String state) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getStateDropdown()));
		Select sel = new Select(getStateDropdown());
		sel.selectByVisibleText(state);
	}

	public void selectCreditScore(String creditScore) {
		Select sel = new Select(getCreditScoreDropdown());
		sel.selectByVisibleText(creditScore);
	}

	public void enterAnnualIncomeStudent(String annualIncome) {
		getAnnualIncomeTextBox().click();
		for(int i=0;i<7;i++) {
			getAnnualIncomeTextBox().sendKeys(Keys.BACK_SPACE);
		}
		getAnnualIncomeTextBox().sendKeys(annualIncome);
	}

	public void selectHighestEducationLevel(String educationLevel) {
		Select sel = new Select(geteducationCompletedDropDown());
		sel.selectByVisibleText(educationLevel);
	}

	public void enterLoanBalance(String loanBalance) {
		getLoanAmountFilter().click();
		for(int i=0;i<10;i++) {
			getLoanAmountFilter().sendKeys(Keys.BACK_SPACE);
		}
		//getLoanAmountFilter().clear();
		getLoanAmountFilter().sendKeys(loanBalance);
	}

	public void clickSeeYourOptions() {
		getSeeYourOptionsBtn().click();
	}

	public void getStudentHeaderValue() {

		String s = getStudentHeader().getText();
		System.out.println(s);
		if(s.contains("Compare your student loan refi options")&& s.contains("for")&& s.contains("fair")&& s.contains("credit in")&&s.contains("NJ")) {
			System.out.println("Header Present");
		}
		else {
			System.err.println("Header Not Present");
			Assert.assertTrue(false);
		}


	}
	
	public void enterLoanBalanceStudent(String studentLoanBalance) {
		getLoanBalance().click();
		for(int i = 0; i<10; i++) {
			getLoanBalance().sendKeys(Keys.BACK_SPACE);
		}
		
		getLoanBalance().sendKeys(studentLoanBalance);
	}
	
	
	public void verifyEarnestPresent() {
		String actual=getEarnest().getAttribute("alt");
		String expected="Earnest Student Loan Refinance";
		Assert.assertEquals(actual, expected);
	}
	
	public void verifySofiPresent() {
		String actual = getSofi().getAttribute("alt");
		String expected="SoFi Student Loan Refinance ";
		Assert.assertEquals(actual, expected);
	}

}
