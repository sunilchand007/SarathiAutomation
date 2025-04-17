package pageobjects;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.GetTitle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import frameworkLibrary.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;
	boolean stepstatus;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement Username;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//input[@id='logmode']")
	WebElement Captcha;

	@FindBy(how = How.XPATH, using = "//input[@id='frmsubmt']")
	WebElement Next;

	@FindBy(how = How.XPATH, using = "//input[@name='submit']")
	WebElement Singin;

	// related methods to perform operation on webelements
	public void setUserName(String Strusername) {
		stepstatus = setText(Username, Strusername);
		// reportEvent(stepstatus, "Able to enter username", "Unable to enter username",
		// driver);
	}

	public void setpassword(String Strpassword) {
		stepstatus = setText(Password, Strpassword);
		// reportEvent(stepstatus, "Able to enter password", "Unable to enter password",
		// driver);
		if (driver.getPageSource().contains("Next")) {
			ClickonNext();
			// SetCaptcha();
			JFrame Dialog = new JFrame();
			String name = JOptionPane.showInputDialog(Dialog, "Enter Captcha");
			driver.findElement(By.xpath("//input[@id='logmode']")).sendKeys(name);
		} else {
			SetCaptcha();
		}

	}

	@FindBy(how = How.XPATH, using = "//div[@id='servervalid']/span")
	WebElement ifalreadySingin;
	@FindBy(how = How.XPATH, using = "//input[@value='LOGOUT']")
	WebElement Logout;
	@FindBy(how = How.XPATH, using = "//input[@value='Go to Login']")
	WebElement gotoLogin;
	@FindBy(how = How.XPATH, using = "//input[@value='LOGIN']")
	WebElement gotoLogin1;

	public void ClickonLogin() {
		stepstatus = clickElement(Singin);
		if (isDisplayed(ifalreadySingin) == true)
		{
			if (isDisplayed(gotoLogin1)==true)
			{	
				clickElement(gotoLogin1);
			
			}
			else if(isDisplayed(Logout)==true)
			{
				clickElement(Logout);
				clickElement(gotoLogin);
				LoginPage RTO = new LoginPage(driver);
				RTO.setpassword(getdata("Password"));
				RTO.ClickonLogin();
			}
			
				
			// stepstatus = clickElement(Singin);
		}

		VerifyRTOSelection();
	}

	public void SetCaptcha() {
		stepstatus = setText(Captcha, "123456");

		// reportEvent(stepstatus, "Able to Enter Captcha", "Unable to Enter Captcha",
		// driver, true);
	}

	public void ClickonNext() {
		stepstatus = clickElement(Next);
		// reportEvent(stepstatus, "Able to click on Next BUtton", "Unable to click on
		// Next Button", driver, true);
	}

	public void VerifyRTOSelection() {

		String rtoselectiontitle = driver.getTitle();

		if (rtoselectiontitle.equalsIgnoreCase("UserRTOLogin")) {
			code = getdata("RTOCode");
			System.out.println(code);
			List<WebElement> camplst = driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[6]"));
			int camplstsize = camplst.size();

			for (int i = 0; i < camplstsize; i++) {

				String text = driver
						.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[6]"))
						.getText();
				if (text.equalsIgnoreCase("--------")) {
					System.out.println("Non Camp Details Matched");
					String rtotxt = driver.findElement(By.xpath(
							"//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[5]/preceding-sibling::td[3]"))
							.getText();

					String categorytext = driver
							.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i + "]/td[4]"))
							.getText();

					if (categorytext.equalsIgnoreCase("RTO AUTHORITY")) {
						System.out.println("RTO AUTHORITY Details Matched");
						categorytext = driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
								+ "]/td[5]/preceding-sibling::td[1]")).getText();

						if (rtotxt.equalsIgnoreCase(code)) {
							System.out.println("RTO Code Matched");
							driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i
									+ "]/td[5]/preceding-sibling::td[4]/input")).click();
							break;

						}
					}

				}

			}
			driver.findElement(By.xpath("//input[@value='Login']")).click();
		} else if (rtoselectiontitle.equalsIgnoreCase("Home")) {
			System.out.println("There is no RTO Selection Page");
		} else {
			System.out.println("Title Mismatched");
		}

		/*
		 * if (driver.getPageSource().contains("User RTO Login")) { code =
		 * getdata("RTOCode"); List<WebElement> camplst =
		 * driver.findElements(By.xpath("//table[@id='tblAcctTo']/tbody/tr/td[5]")); int
		 * camplstsize = camplst.size();
		 * 
		 * for (int i = 0; i < camplstsize; i++) {
		 * 
		 * String text = driver
		 * .findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" + i +
		 * "]/td[5]")) .getText(); if (text.equalsIgnoreCase("--------")) {
		 * System.out.println("Camp Details Matched"); String rtotxt =
		 * driver.findElement(By.xpath( "//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" +
		 * i + "]/td[5]/preceding-sibling::td[3]")) .getText(); if
		 * (rtotxt.equalsIgnoreCase(code)) { System.out.println("RTO Code Matched");
		 * driver.findElement(By.xpath("//table[@id='tblAcctTo']/tbody/tr[" + 1 + "+" +
		 * i + "]/td[5]/preceding-sibling::td[4]/input")).click(); break; }
		 * 
		 * }
		 * 
		 * } driver.findElement(By.xpath("//input[@value='Login']")).click(); } else {
		 * System.out.println("There is no RTO Selection"); }
		 */
	}

}
