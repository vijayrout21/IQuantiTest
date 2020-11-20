package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.HomePage;
import utils.Utils;

public class TestCaseUI extends Utils{


	//WebDriver driver;

	@BeforeTest
	public void BeforeTest() throws IOException {
		browser(readProperties("browser"),readProperties("url"));
	}

	@Test(enabled=false)
	public void test1() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickOurTopPicks();
		hp.clickPersonalLoans();
		hp.clickCompareDebt();
		hp.getHeaderValue();
		hp.enterAnnualIncome("20000");
		hp.verifyUpStart();
		hp.verifyProsper();
		hp.verifyOneMain();
	}

	@Test
	public void test2() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.clickOurTopPicks();
		hp.clickStudentLoans();
		hp.clickCompareRefinanceStudentLoans();
		Thread.sleep(3000);
		hp.selectStateOfResidence("New Jersey");
		hp.selectCreditScore("650-699");
		hp.enterAnnualIncomeStudent("50000");
		hp.selectHighestEducationLevel("Graduate");
		hp.enterLoanBalance("5000");
		hp.clickSeeYourOptions();
		Thread.sleep(3000);
		hp.getStudentHeaderValue();
		hp.enterLoanBalanceStudent("5000");
		hp.verifyEarnestPresent();
		hp.verifySofiPresent();
	}


}
