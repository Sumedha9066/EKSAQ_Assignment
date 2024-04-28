package logintests;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.CourseAndCartPage;
import pages.LogInPage;

public class Checkoutproduct {

	WebDriver wd;
	WebDriverWait wait;
	JavascriptExecutor js;
	LogInPage loginPage;

	public Checkoutproduct() {

	}

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sumedha\\OneDrive\\Desktop\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary(new File("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe"));
		wd = new ChromeDriver(options);
		wd.get("https://uat.eksaqonline.com/");
		wd.manage().window().maximize();

		loginPage = new LogInPage(wd);

		loginPage.clickOnLoginLink();
		loginPage.enterUserName("testorguat1@mailinator.com");
		loginPage.enterPassword("Abcd@123 ");
		loginPage.clickOnLoginButton();

		wait = new WebDriverWait(wd, 10);

	}

	@Test
	public void addCourseToCart() {
		CourseAndCartPage courseAndCartPage = new CourseAndCartPage(wd);

		courseAndCartPage.clickOnCouse();
		courseAndCartPage.clickOnSixthCouse();
		courseAndCartPage.numberOfTeachersAndStudents();
		courseAndCartPage.subscribebutton();
		courseAndCartPage.clickOnAddToCart();
		courseAndCartPage.enterDetails();
		courseAndCartPage.enterCardDetailsAndPayment();

	}

	@AfterSuite
	public void cleanup() {
		wd.quit();

	}

}
