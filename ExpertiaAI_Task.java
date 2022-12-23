package ExpertiaAI;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ExpertiaAI_Task {
	public static WebDriver driver;

	public static void browserLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\eclipse-workspace\\Selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expertia.ai/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Access For Free']")).click();
		driver.findElement(By.xpath("//button[text()='Post a Job!']")).click();
	}

	public static void companyDetails() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Company Name']")).sendKeys("Gmail");
		driver.findElement(By.xpath("//label[text()='Enter Company Name ']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Head Quarter']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@placeholder='Industry Type']")).sendKeys("Software");
		driver.findElement(By.xpath("//input[@placeholder='Site Url']")).sendKeys("www.gmail.com");
		driver.findElement(By.xpath("//textarea[@placeholder='Company Description']"))
				.sendKeys("Famous mailing website");
		WebElement companysize = driver.findElement(By.xpath("//div[@role='listbox']"));
		companysize.click();
		driver.findElement(By.xpath("//span[text()='11-50 employees']")).click();
		JavascriptExecutor stpage = (JavascriptExecutor) driver;
		stpage.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Confirm Details']")).click();
	}

	public static void jobDetails(String filepath) throws InterruptedException, AWTException {
		driver.findElement(By.xpath("//input[@placeholder='Job Title']")).sendKeys("QA tester");
		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		driver.findElement(By.xpath("//span[text()='Junior: 1 to 3 years']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Job Location']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//div[text()='Chennai']")).click();
		driver.findElement(By.xpath("//div[text()='Remote']")).click();
		driver.findElement(By.xpath("//div[text()='Freelance']")).click();
// for uploading job description in pdf
//		StringSelection ss = new StringSelection(filepath);
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//		Robot robot = new Robot();
//		Thread.sleep(5000);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		Thread.sleep(2000);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		Thread.sleep(5000);
		JavascriptExecutor stppage = (JavascriptExecutor) driver;
		stppage.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys(
				"We are looking for a results-driven software tester to be responsible for designing and running tests on software usability. The software tester will conduct tests, analyze the results, and report observations to the design team. You may also interact with clients in order to understand the requirements of the product"
						+ "	To be successful as a software tester, you should have a working knowledge of software and test design, the capability to run through tests, and the ability to analyze the results. Ultimately, the software tester should be result-driven, have good communication skills, and up-to-date knowledge of software programming and software test design");
		JavascriptExecutor sttpage = (JavascriptExecutor) driver;
		sttpage.executeScript("window.scrollBy(0,250)", "");
		driver.findElement(By.xpath("//button[text()='Next']")).click();
	}

	public static void additionalDetails() {
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//div[text()='Selenium WebDriver']")).click();
		driver.findElement(By.xpath("//div[text()='Add +']")).click();
		driver.findElement(By.xpath("//input[@class='prompt']")).sendKeys("Cucumber");
		driver.findElement(By.xpath("//div[text()='Cucumber']")).click();
		driver.findElement(By.xpath("//div[text()='2. What is your expected ctc?']")).click();
		driver.findElement(By.xpath("//div[text()='4. What is your total Experience?']")).click();
		driver.findElement(By.xpath("//div[text()='3. What is your Notice Period?']")).click();
		driver.findElement(By.xpath("//button[text()='Next']")).click();
	}

	public static void signUp() {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Devanathan");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Sengu");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9898421860");
		driver.findElement(By.xpath("//input[@placeholder='Work Email']")).sendKeys("Testing@sttingmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Pass!234");
		driver.findElement(By.xpath("//button[@class='global-button']")).click();
	}

	public static void verifyEmail() {
		driver.findElement(By.xpath("//input[@placeholder='Enter OTP']")).sendKeys("569874");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[text()='Resend Verification Code']")).click();
	}

	public static void main(String[] args) throws InterruptedException, AWTException {
		browserLaunch();
		companyDetails();
		jobDetails(null);
		additionalDetails();
		signUp();
		verifyEmail();
	}
}
