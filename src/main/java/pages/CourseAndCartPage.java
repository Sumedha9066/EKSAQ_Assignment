package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseAndCartPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@FindBy(xpath = "//*[@id=\"primary-menu\"]/li[4]/a")
	WebElement courseLink;

	@FindBy(xpath = "//*[@id=\"organizations\"]/div[8]/div/div/div[1]/figure/a")
	WebElement courseSelection;

	@FindBy(xpath = "//*[@id=\"product-8268\"]/div[1]/div[2]/div[1]/div/form/p[1]/input")
	WebElement numberOfStudents;

	@FindBy(xpath = "//*[@id=\"product-8268\"]/div[1]/div[2]/div[1]/div/form/p[2]/input")
	WebElement numberOfTeacher;

	@FindBy(xpath = "//*[@id=\"product-8268\"]/div[1]/div[2]/div[1]/div/form/button")
	WebElement subscribeButton;

	@FindBy(xpath = "//*[@id=\"apus-header\"]/div/div/div/section/div/div/div[2]/div/div/div[2]/div")
	WebElement addToCartBotton;

	@FindBy(linkText = "Checkout")
	WebElement checkOutButton;

	@FindBy(id = "billing_first_name")
	WebElement billingFirstName;

	@FindBy(id = "billing_last_name")
	WebElement billingLastName;

	@FindBy(id = "billing_address_1")
	WebElement billingAddress1;

	@FindBy(id = "billing_city")
	WebElement billingCity;

	@FindBy(id = "billing_postcode")
	WebElement billingPostCard;

	@FindBy(id = "billing_phone")
	WebElement billingPhonenumber;

	@FindBy(id = "billing_email")
	WebElement billingemail;

	@FindBy(id = "place_order")
	WebElement placeOrder;

	@FindBy(id = "payment_method_billdesk")
	WebElement billDesk;

	@FindBy(id = "cnumber")
	WebElement cardNumber;

	@FindBy(id = "expmon")
	WebElement cardexpireMonth;

	@FindBy(id = "expyr")
	WebElement cardexpireYear;

	@FindBy(id = "cvv2")
	WebElement cardcvvNumber;

	@FindBy(id = "chname")
	WebElement cardHolderNumber;

	public CourseAndCartPage(WebDriver driver) {
		wait = new WebDriverWait(driver, 10);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clickOnCouse() {
		wait.until(ExpectedConditions.elementToBeClickable(courseLink));
		courseLink.click();
	}

	public void clickOnSixthCouse() {
		scrollToElement(driver, courseSelection);
		wait.until(ExpectedConditions.elementToBeClickable(courseSelection));
		courseSelection.click();
	}

	public void numberOfTeachersAndStudents() {
		wait.until(ExpectedConditions.visibilityOf(numberOfStudents)).sendKeys("20");
		wait.until(ExpectedConditions.visibilityOf(numberOfTeacher)).sendKeys("2");

	}

	public void subscribebutton() {
		scrollToElement(driver, subscribeButton);
		wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();

	}

	public void clickOnAddToCart() {
		addToCartBotton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scrollToElement(driver, checkOutButton);
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButton)).click();

	}

	public void enterDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(billingFirstName)).clear();
		billingFirstName.sendKeys("perry");

		billingLastName.clear();
		billingLastName.sendKeys("lisa");

		billingAddress1.clear();
		billingAddress1.sendKeys("13-2-5/21 vijaynagar");

		billingCity.clear();
		billingCity.sendKeys("Bengaluru");

		billingPostCard.clear();
		billingPostCard.sendKeys("560040");

		billingPhonenumber.clear();
		billingPhonenumber.sendKeys("1234565438");

		billingemail.clear();
		billingemail.sendKeys("abcd123@gmail.com");

		scrollToElement(driver, placeOrder);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.elementToBeClickable(placeOrder));
		placeOrder.click();

	}

	public void enterCardDetailsAndPayment() {

		wait.until(ExpectedConditions.visibilityOf(cardNumber)).sendKeys("5425233430109903");
		cardexpireMonth.sendKeys("06(Apr)");
		cardexpireYear.sendKeys("2026");
		cardcvvNumber.sendKeys("345");
		//cardHolderNumber.sendKeys("perry");

	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
}