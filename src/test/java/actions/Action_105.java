package actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworkLibrary.BasePage;
import pageobjects.LLPrintpage;

public class Action_105 extends BasePage{

	WebDriver driver;
	LLPrintpage LLPrint;
	public void LLPrint() throws InterruptedException {
		LLPrint = new LLPrintpage(driver);
		LLPrint.ClickonLLLink();
		LLPrint.ClickonLLPrinting();
		LLPrint.ClickonRadiobutton();
		LLPrint.Set_Application_Number(getdata("ApplicationNo"));
		LLPrint.Clickon_ViewApplications();
		LLPrint.ClickonLicNummbertoPrint();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		int size = tabs.size();
		System.out.println("Size of windows" + size);
		if (size > 1) {
			driver.switchTo().window(tabs.get(1));
			if (driver.getPageSource()
					.contains("No Complete Details Available like(Images/Personal Data/Licence Data)")) {
				System.out.println("New Error window opened");
				driver.switchTo().window(tabs.get(1)).close();
				driver.switchTo().window(tabs.get(0));
				LLPrint.Clickon_Logout_Button();
				try {
					UpdateLLValidities();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("There is no new window opened.");
			

			Robot bot;
			try {
				bot = new Robot();
				wait(1);
				bot.keyPress(KeyEvent.VK_CONTROL);
				bot.keyPress(KeyEvent.VK_J);
				bot.keyRelease(KeyEvent.VK_CONTROL);
				bot.keyRelease(KeyEvent.VK_J);
//				bot.keyPress(KeyEvent.VK_ENTER);
//		        bot.keyRelease(KeyEvent.VK_ENTER);
				String winHandleBefore = driver.getWindowHandle();
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
					closeWindowByTitle("Downloads", driver);
					driver.switchTo().window(winHandleBefore);
				}
			} catch (AWTException e) {
				e.printStackTrace();
			}
			LLPrint.ClickonHome();
			LLPrint.Clickon_Logout_Button();
			try {
				UpdateLLValidities();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	WebElement Logout;
	public void UpdateLLValidities() throws IOException, InterruptedException {
		
		clickElement(Logout);
		wait(2);
		driver.navigate().to("https://sarathicov.nic.in:8443/LLValidityUpdater/home");
		driver.findElement(By.xpath("//input[@id='getLLDetails_llno']")).sendKeys(getdata("LLNumber"));
		driver.findElement(By.xpath("//input[@id='getLLDetails_dob']")).sendKeys(getdata("DateofBirth"));
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		String txtdata = driver.findElement(By.xpath("(//table[@class='table'])[1]/tbody/tr[3]/td[1]")).getText();
		if (txtdata.equals(getdata("LLNumber"))) {
			scrooldown(driver);
			try {
				driver.findElement(By.xpath("//button[@name='confirmDate']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='Yes']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
			//	Login();
				//RTOLevel_Status();
			} catch (ElementClickInterceptedException e) {
				driver.findElement(By.xpath("//button[@name='confirmDate']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='Yes']")).click();
				wait(1);
				driver.findElement(By.xpath("//button[text()='OK']")).click();
				//Login();
				//RTOLevel_Status();
			}

		}
	}
	
	
	
	
	
	
	
	
}
