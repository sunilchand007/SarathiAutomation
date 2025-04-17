package frameworkLibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class BasePage extends ReportLibrary {
	public static Properties prop;
	FileReader reader;
	public static String s1, s2, s3, s4, s5, s6, s7, s10, s11, s12, s13, s14, CLApplicationnumber, CLDateofBirth,
			CLLicencenumber, CLBadgenumber, ChangeofnameinDLAppliationno, ChangeofAddressApplicationNo,
			ChangeofAddressDOB, RenewalofDLApplicationNo, DL_Service_IssueofDuplicateDLApplicationNo,
			DL_Service_ReplacementofDLApplicationNo, DL_Service_IssueofNOCApplicationNo, DL_ExtractApplicationNo,
			Issueof_International_Driving_PermitApplicationNo, Change_of_Biometrics_in_DLApplicationNo,
			DL_Service_Issue_Of_PSVBadge_to_DriverApplicationNo, HolidingforeignDLApplicationNo,
			HolidingforeignDLDateofBirth, Renewal_with_ReTestApplicationNo,
			Endorsement_to_drive_in_Hill_regionApplicationNo , cl01,cl02;

	/* New Global Strings */
	public static String AppNum, DOB, NewLLNumber, LLBacklogNumber, NewDLApplicationNo, NewDLNumber, pinnumber,
			question=null, code=null,selectionString;
	public static String otptextineKYCform;
	public static String stcode="";
	public static SimpleDateFormat df = new SimpleDateFormat();
	protected Connection conn = null;
	Statement st;
	protected ResultSet rs;
	protected ResultSetMetaData meta;
	int columnnumber;
	public static String outcome = null;

	static XSSFWorkbook wb1;
	static XSSFSheet ws1;
	static FileInputStream fis;

	public boolean navigate(WebDriver driver, String URL) {
		boolean stepstatus;
		try {
			driver.navigate().to(URL);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean setText(WebElement ele, String StrValue) {
		boolean stepstatus;
		try {
			ele.clear();
			ele.sendKeys(StrValue);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SetTextAndEscape(WebElement ele, String Value) {
		Boolean stepStatus;
		try {

			ele.clear();
			ele.sendKeys(Value);
			ele.sendKeys(Keys.ESCAPE);
			String Enteredvalue = "";
			Enteredvalue = ele.getAttribute("value");
			if (!Enteredvalue.equalsIgnoreCase(Value)) {
				stepStatus = false;
			}
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}

	public boolean SetTextAndTAB(WebElement ele, String Value) {
		Boolean stepStatus;
		try {

			ele.clear();
			ele.sendKeys(Value);
			ele.sendKeys(Keys.RETURN);
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}

	public boolean clickElement(WebElement ele) {
		boolean stepstatus;
		try {
			ele.click();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean clickifElementTextEquals(List<WebElement> allitems, String TextValue) {
		boolean stepstatus;
		try {
			for (WebElement ele : allitems) {
				if (ele.getText().equals(TextValue)) {
					ele.click();
				}
			}
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean clickifElementAttributeValueEquals(List<WebElement> allitems, String AttributeName,
			String AttributeValue) {
		boolean stepstatus;
		try {
			for (WebElement ele : allitems) {
				if (ele.getAttribute(AttributeName).equals(AttributeValue)) {
					ele.click();
				}
			}
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean setOptionInSelectBox(WebElement ele, String eleOption) {
		boolean stepstatus = false;
		try {
			new Select(ele).selectByVisibleText(eleOption);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean setValueInSelectBox(WebElement ele, String eleOption) {
		boolean stepstatus = false;
		try {
			new Select(ele).selectByValue(eleOption);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean setIndexValueInSelectBox(WebElement ele, int eleOption) {
		boolean stepstatus = false;
		try {
			new Select(ele).selectByIndex(eleOption);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean setCheckBox(WebElement ele, String ONorOFF) {
		boolean stepstatus = false;
		try {

			switch (ONorOFF.toLowerCase()) {
			case "on":
				if (!ele.isSelected()) {
					ele.click();
				}
				stepstatus = true;
				break;
			case "off":
				if (ele.isSelected()) {
					ele.click();
				}
				stepstatus = true;
				break;
			default:
				stepstatus = false;
				break;
			}

		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}
	

	public String getLinkText(WebElement ele) {
		String value = "";
		try {

			if (exists(ele)) {
				value = ele.getText();
			}
		} catch (Exception e) {
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}

	public String getAttributeValue(WebElement ele, String AttributeName) {
		String value = "";
		try {

			if (exists(ele)) {
				value = ele.getAttribute(AttributeName);
			}
		} catch (Exception e) {
			value = "";
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return value;
	}

	public void waitForPageToLoad(WebDriver driver) {
		String pageLoadStatus;
		do {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");
		} while (!pageLoadStatus.equals("complete"));
	}

	public boolean exists(WebElement ele) {
		boolean stepstatus;
		try {

			stepstatus = ele.isDisplayed();
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean isEnabled(WebElement ele) {
		boolean stepstatus;
		try {
			stepstatus = ele.isEnabled();
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean isSelected(WebElement ele) {
		boolean stepstatus;
		try {
			stepstatus = ele.isSelected();
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean isDisplayed(WebElement ele) {
		boolean stepstatus;
		try {
			stepstatus = ele.isDisplayed();
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean iselementExist(WebDriver driver, String ObjectXpath) {
		boolean stepStatus = true;
		try {
			driver.findElement(By.xpath(ObjectXpath));
		} catch (Exception e) {
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}

	public boolean mouseHover(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.moveToElement(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean rightClick(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.contextClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean doubleClick(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.doubleClick(ele);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean dragAndDrop(WebElement drag, WebElement drop, WebDriver driver) {
		boolean stepstatus;
		try {
			Actions a1 = new Actions(driver);
			a1.dragAndDrop(drag, drop);
			a1.build().perform();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean JsclickElement(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean JssetText(WebElement ele, String StrValue, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='" + StrValue + ";", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean JsScrollToWebElement(WebElement ele, WebDriver driver) {
		boolean stepstatus;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", ele);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean acceptAlert(WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.accept();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean dismissAlert(WebDriver driver) {
		boolean stepstatus;
		try {
			Alert a1 = driver.switchTo().alert();
			a1.dismiss();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean alertExist(WebDriver driver) {
		boolean stepstatus;
		try {
			driver.switchTo().alert();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public String alertGetText(WebDriver driver) {
		String StrValue = "";
		try {
			Alert a1 = driver.switchTo().alert();
			StrValue = a1.getText();
		} catch (Exception e) {
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return StrValue;
	}

	public boolean isWindowExistsByURL(String URL, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean isWindowExistsByTitle(String Title, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SwitchtoWindowByURL(String URL, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean Closeandcheckchildwindows(WebDriver driver, String Parentwindow, String ChildWindow) {
		boolean isclosedflag = false;
		Set<String> allwindoes = driver.getWindowHandles();
		try {

			for (String str : allwindoes) {

				if (!(str.equals(Parentwindow) && !(str.equalsIgnoreCase(ChildWindow)))) {

					driver.close();
					isclosedflag = true;
				}

			}
			return isclosedflag;
		} catch (Exception e) {

		}
		return isclosedflag;

	}

	public boolean SwitchtoWindowByTitle(String Title, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) {
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean closeWindowByURL(String URL, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getCurrentUrl();
				if (CurrentURL.contains(URL)) {
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean closeWindowByTitle(String Title, WebDriver driver) {
		boolean stepstatus = false;
		try {
			Set<String> allhandles = driver.getWindowHandles();
			for (String handle : allhandles) {
				driver.switchTo().window(handle);
				String CurrentURL = driver.getTitle();
				if (CurrentURL.contains(Title)) {
					driver.close();
					stepstatus = true;
					break;
				}
			}
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SwitchtoFrameByElementReference(WebElement FrameRef, WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.switchTo().frame(FrameRef);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SwitchtoFrameByName(String FrameName, WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.switchTo().frame(FrameName);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SwitchtoFrameByIndex(int FrameIndex, WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.switchTo().frame(FrameIndex);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean SwitchtoMainDocument(WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.switchTo().defaultContent();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean RobotKeysFileUpload(String Filepath) {
		boolean stepstatus;
		try {
			wait(2);
			StringSelection selection = new StringSelection(Filepath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_V);
			robo.keyRelease(KeyEvent.VK_CONTROL);

			wait(2);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			wait(2);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean clickifElementAttributeValueContains(List<WebElement> allitems, String AttributeName,
			String AttributeValue) {
		boolean stepstatus;
		try {
			for (WebElement ele : allitems) {
				if (ele.getAttribute(AttributeName).contains(AttributeValue)) {
					ele.click();
				}
			}
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean wait(int timeInSec) {
		boolean stepStatus;
		try {
			Thread.sleep(timeInSec * 1000);
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;
	}

	public boolean dynamicWait(By by, int waittimeinsec, WebDriver driver) {
		boolean status = false;
		int counter = 0;
		while (counter <= waittimeinsec) {
			try {
				driver.findElement(by);
				status = true;
				break;
			} catch (Exception e) {
				wait(1);
			}
			counter = counter + 1;
		}
		if (counter > waittimeinsec) {
			status = false;
		}
		return status;
	}

	public boolean quitdriver(WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.quit();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean closedriver(WebDriver driver) {
		boolean stepstatus = false;
		try {
			driver.close();
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;
	}

	public boolean scrooldown(WebDriver driver) {
		boolean stepstatus = false;

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,1000)", "");
			stepstatus = true;
		} catch (Exception e) {

			stepstatus = false;
			System.out.println("Scroll down not working");
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepstatus;

	}

	public boolean Upload(String filepath) {
		boolean stepstatus;
		try {
			//
			// ProcessBuilder p = new ProcessBuilder(filepath);
			// p.start();
			Runtime.getRuntime().exec(filepath);
			stepstatus = true;
		} catch (Exception e) {
			stepstatus = false;
			System.out.println("Upload file is failed");
			FrameworkVariables.getInstance().setExceptionDescription(e);

		}
		return stepstatus;

	}

	public Boolean CaptureSignature(WebDriver driver, WebElement ele, String ObjectXpath) {
		boolean stepStatus;
		try {

			WebElement text = driver.findElement(By.cssSelector(ObjectXpath));
			Actions actionBuilder = new Actions(driver);
			Action drawAction = actionBuilder.moveToElement(text, 300, 40).click().clickAndHold(text)
					.moveByOffset(80, 80).moveByOffset(40, 40).moveByOffset(-70, -70).release(text).build();
			drawAction.perform();
			stepStatus = true;

		} catch (Exception e) {

			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);

		}
		return stepStatus;
	}

	public boolean Random_Datepicker(WebDriver driver) {
		boolean stepStatus;

		String str;
		try {
			/* 1st Random */
			Random r = new Random();
			int low = 1;
			int high = 30;
			int result = r.nextInt(high - low) + low;
			// System.out.println("Random Number is " + result);

			/* 2nd Random */
			Random r1 = new Random();
			int low1 = 29;
			int high1 = 30;
			int result1 = r1.nextInt(high1 - low1) + low1;
			// System.out.println("Random Number is " + result1);

			/* 3rd Random */
			Random r2 = new Random();
			int low2 = 29;
			int high2 = 30;
			int result2 = r2.nextInt(high2 - low2) + low2;
			// System.out.println("Random Number is " + result2);

			List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
			// int sa = ele.size();
			// System.out.println("Size is "+sa);
			for (WebElement ele1 : ele) {
				str = ele1.getText();
				if (str.contains(Integer.toString(result))) {
					System.out.println("Selected Date is in result :" + result);
					ele1.click();
					break;
				} else if (str.contains(Integer.toString(result1))) {
					System.out.println("Selected Date is in result1:" + result1);
					ele1.click();
					break;
				} else if (str.contains(Integer.toString(result2))) {
					System.out.println("Selected Date is in result2 :" + result2);
					ele1.click();
					break;
				} else {

					System.out.println("Selected date is Holoday.Please Try again");
				}
			}
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);

		}
		return stepStatus;
	}

	public String App_NO(WebDriver driver, String ObjectXpath) {
		@SuppressWarnings("unused")
		boolean stepStatus;
		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			AppNum = ele.getText();
			System.out.println("Application Number is :" + AppNum.substring(3).trim());
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			System.out.println("*******Application Number Not Stored.Please Check**********");
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return AppNum;

	}

	public String DOB(WebDriver driver, String ObjectXpath) {
		@SuppressWarnings("unused")
		boolean stepStatus;
		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			DOB = ele.getText();
			System.out.println("Date of Birth is :" + DOB.substring(3).trim());
			stepStatus = true;
		} catch (Exception e) {
			stepStatus = false;
			System.out.println("**************DateofBirth Not Stored.Please Check***************");
			FrameworkVariables.getInstance().setExceptionDescription(e);

		}
		return DOB;
	}

	public String LL_No(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			NewLLNumber = ele.getText();
		} catch (Exception e) {
			System.out.println("NewLLNumber not Generated.Please Check");
		}
		return NewLLNumber;

	}

	public String DL_App_NO(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			NewDLApplicationNo = ele.getText();
			System.out.println("DL Application Number is :" + NewDLApplicationNo);
		} catch (Exception e) {
			System.out.println("Not allowed");
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return NewDLApplicationNo;

	}

	public String DL_No(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));

			NewDLNumber = ele.getText();
			System.out.println(NewDLNumber);
		} catch (Exception e) {
			System.out.println("LL no Not Allowd");

		}
		return NewDLNumber;

	}

	public String LL_Backlog_App_NO(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));

			s6 = ele.getText();
			System.out.println(s6);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return s6;

	}

	public String LL_Backlog_LL_NO(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));

			s7 = ele.getText();
			System.out.println(s7);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return s7;

	}

	public String DL_Backlog(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));
			s10 = ele.getText();
			System.out.println(s10);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return s10;

	}

	public String DL_Approvedappno(WebDriver driver, String ObjectXpath) {

		try {
			WebElement ele = driver.findElement(By.xpath(ObjectXpath));

			s11 = ele.getText();
			System.out.println(s11);

		} catch (Exception e) {
			System.out.println("Not allowed");
		}
		return s11;

	}

	public void DB_Check(String DBQuery, String Value, String Uservalue)
			throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver Loaded");
		Connection c = DriverManager.getConnection("jdbc:postgresql://10.249.163.118:5432/sow4stgcov", "readonly",
				"readonly");
		System.out.println("Connection Established");
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(DBQuery);
		System.out.println("statement created");

		/*
		 * ResultSetMetaData meta = rs.getMetaData(); int colcount
		 * =meta.getColumnCount(); String[] columnnames =new String[colcount]; for (int
		 * i = 1; i <= colcount; i++) { columnnames[i-1] = meta.getColumnName(i);
		 * System.out.println(columnnames[i-1]); }
		 */

		while (rs.next()) {
			String s = rs.getString(Value);
			System.out.println(s);
			if (s.contains(Uservalue)) {
				System.out.println("User value & Database value both are MATCHES.");
			} else {

				System.out.println("User value & Database value both are NOT MATCHES Please check again.");

			}
		}
	}

	public void Download() {

	}

	@SuppressWarnings("unused")
	public boolean Slot_booking(WebDriver driver, String ObjectXpath, String ObjectXpath1) {

		boolean stepStatus = true;
		try {

			List<WebElement> n = driver.findElements(By.xpath(ObjectXpath));
			int size1 = n.size();
			// System.out.println(size1);
			for (int j = 0; j <= size1; j++) {

				String slot = n.get(j).getText();
				System.out.println("Total slots available : " + slot);

				if (slot.equals("0")) {

					System.out.println("Slots is Zero for your given date please select another day");
					String str;
					/* 1st Random */
					Random r = new Random();
					int low = 1;
					int high = 31;
					int result = r.nextInt(high - low) + low;
					// System.out.println("Random Number is " + result);
					List<WebElement> ele = driver.findElements(By.xpath("//table/tbody/tr/td[@class='cal_green']"));
					int s = ele.size();
					System.out.println("Size is " + s);
					for (WebElement ele1 : ele) {
						str = ele1.getText();
						if (str.contains(Integer.toString(result))) {
							System.out.println("Selected Date is in result :" + result);
							ele1.click();
							break;
						} else {

							System.out.println("Please Try again.slotbooking section date also have zero slots.");
						}
					}
					driver.findElement(By.xpath(ObjectXpath1)).click();
					System.out.println("Your slot is booked sucessfully in slotbooking statement");
					break;
				} else {
					driver.findElement(By.xpath(ObjectXpath1)).click();
					System.out.println("Your slot is booked sucessfully");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Try Again in slot booking");
			stepStatus = false;
			FrameworkVariables.getInstance().setExceptionDescription(e);
		}
		return stepStatus;

	}

	public void Highlight(WebDriver driver, String ObjectXpath) {
		try {
			WebElement element = driver.findElement(By.xpath(ObjectXpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			for (int iCnt = 0; iCnt < 2; iCnt++) {
				js.executeScript("arguments[0].style.border='solid 3px red'", element);
				Thread.sleep(200);
				js.executeScript("arguments[0].style.border=''", element);
				Thread.sleep(200);
			}
		} catch (Exception e) {

		}
	}

	public void loaddata() throws IOException {
		reader = new FileReader("DataFiles\\Application.properties");
		prop = new Properties();
		prop.load(reader);
	}

	public static String ParentFolder(String path) {

		File theDir = new File("/u01/" + path);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			theDir.mkdir();
		} else {
			System.out.println("Automation Backup Folder is already exist");
		}
		return path;

	}

	public static String GetCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("_dd-MMM-yyyy_HH:mm a");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static String GetCurrentDate() {

		Date myDate = new Date();
		File dir = new File(new SimpleDateFormat("dd-MM-yyyy").format(myDate));
		String str = dir.getName();
		return str;
	}

	public static String CreateFolder(String path) {

		File theDir = new File("C:\\AutomationBackup\\" + path);
		if (!theDir.exists()) {
			System.out.println("creating directory: " + theDir.getName());
			theDir.mkdir();
		} else {
			System.out.println("Folder Exist");
		}
		return path;

	}

	@SuppressWarnings("resource")
	public static void BackupFile(String SourceFileName, String DestinationFileName) throws IOException {

		String Filesource = "DataFiles\\" + SourceFileName + ".xlsx";
		File Source = new File(Filesource);
		File Destination = new File("C:\\" + ParentFolder("AutomationBackup") + "\\" + CreateFolder(GetCurrentDate())
		+ "\\" + DestinationFileName + GetCurrentTimeStamp().replace(":", "_").replace(".", "_") + ".xlsx");
		if (!Source.exists()) {
			return;
		}
		if (!Destination.exists()) {
			Destination.createNewFile();
		}
		FileChannel SourceFile = null;
		FileChannel DestinationFile = null;
		SourceFile = new FileInputStream(Source).getChannel();
		DestinationFile = new FileOutputStream(Destination).getChannel();
		if (DestinationFile != null && SourceFile != null) {
			DestinationFile.transferFrom(SourceFile, 0, SourceFile.size());
		}

		if (SourceFile != null) {
			SourceFile.close();
		}
		if (DestinationFile != null) {
			DestinationFile.close();
		}

	}

	public void ArrangeDataSet() {

		Faker faker = new Faker(new Locale("en-IND"));
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String relationfirstname = faker.name().firstName();
		String relationlastname = faker.name().lastName();

		setdata("FN", firstname);
		setdata("LN", lastname);
		setdata("RF", relationfirstname);
		setdata("RL", relationlastname);

	}

	public String ConnectDB(String DBQuery, String Uservalue) throws ClassNotFoundException, SQLException {
		
		
		System.out.println(" Inside bage page connectDB method");
		try {
			System.out.println("Connecting to Database..." + "\n" + df.format(new Date()) + ""
					+ "\n-----------------------------------------------------------------------------");
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://10.249.163.118:5432/sow4stgcov", "readonly",
					"readonly");
			System.out.println("Connected to Database");
		} catch (SQLException | ClassNotFoundException ex) {
			System.err.println("Failed to connect to DB");
			ex.printStackTrace();
		}
		st = conn.createStatement();
		rs = st.executeQuery(DBQuery);
		meta = rs.getMetaData();
		columnnumber = meta.getColumnCount();
		while (rs.next()) {
			String[] columnnames = new String[columnnumber];
			for (int i = 1; i <= columnnumber; i++) {
				columnnames[i - 1] = meta.getColumnName(i);
				// System.out.println(columnnames[i - 1]);
				if ((columnnames[i - 1]).contains(Uservalue)) {
					outcome = rs.getString(Uservalue);
					System.out.println("Fetched value from DB for UserInput is: " + outcome);
				}
			}
		}
		if (conn != null) {

			conn.close();
			System.out.println("Disconnected from Database..." + "\n" + df.format(new Date()) + ""
					+ "\n-----------------------------------------------------------------------------");
		}
		
		
		return outcome;
		
	}

	public void ConnecttoExcel(String Check, String Filename) {

		try {

			String FilePath = "Database\\" + Filename + ".xlsx";
			File f1 = new File(FilePath);
			fis = new FileInputStream(f1);
			wb1 = new XSSFWorkbook(fis);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
			ws1 = wb1.getSheetAt(0);
			getoutput(Check);
			fis.close();
			wb1.close();
		} catch (Exception e) {
			
			System.out.println(" Inside connect to excel exception");
			e.printStackTrace();
		}

	}

	public Map<String, String> getfielddata(String stname) {

		Map<String, String> data = new HashMap<>();
		if (!data.isEmpty()) {

			data.clear();
		}
		try {
			int rowcount = ws1.getLastRowNum();
			System.out.println("Row Count: " + rowcount);
			int colcount = ws1.getRow(rowcount).getLastCellNum();
			System.out.println("Column Count: " + colcount);
			for (int i = 0; i <= rowcount; i++) {
				String stcde = ws1.getRow(i).getCell(0).getStringCellValue();

				/*System.out.println("The value of stcde is "+stcde);
				System.out.println("The value of stname is "+stname);*/

				//System.out.println("The value of stcde is "+stcde);
				//System.out.println("The value of stname is "+stname);
				//System.out.println("The value of stcde is "+stcde);
				//System.out.println("The value of stname is "+stname);

				if (stcde.equalsIgnoreCase(stname)) {

					for (int j = 0; j < colcount; j++) {
						//System.out.println("On row "+ i+ "on coulmn "+ j);
						String header = ws1.getRow(0).getCell(j).getStringCellValue();
						String coldata = ws1.getRow(i).getCell(j).getStringCellValue();
						data.put(header, coldata);
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Inside getfielddata exception ");
			e.printStackTrace();
		}
		return data;

	}

	public String getoutput(String Check) {

		try {
			Map<String, String> data = getfielddata(getdata("State"));
			//System.out.println("Data in Map is " + data);
			//System.out.println("The value of check is " + Check);
			outcome = data.get(Check);
			System.out.println("Outcome is :"+ outcome );
		} catch (Exception e) {
			System.out.println(" Inside getoutput method  exception ");
			e.printStackTrace();
		}

		return outcome;

	}

	// ===========================Stall Exam=================================

	public Map<String, String> getfielddataforStall(String qno) {

		Map<String, String> data = new HashMap<>();
		if (!data.isEmpty()) {
			data.clear();
		}
		try {
			int rowcount = ws1.getLastRowNum();
			// System.out.println("Row Count: " + rowcount);
			int colcount = ws1.getRow(rowcount).getLastCellNum();
			// System.out.println("Column Count: " + colcount);
			for (int i = 0; i <= rowcount; i++) {
				String qnno = ws1.getRow(i).getCell(0).getStringCellValue();
				if (qnno.equalsIgnoreCase(qno.trim())) {
					for (int j = 0; j < colcount; j++) {
						String header = ws1.getRow(0).getCell(j).getStringCellValue();
						String coldata = ws1.getRow(i).getCell(j).getStringCellValue();
						data.put(header, coldata);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	public void ConnecttoExcelforStallExamAnswer(String QuestionNumber, String Filename) {

		try {

			String FilePath = "Database\\" + Filename + ".xlsx";
			File f1 = new File(FilePath);
			fis = new FileInputStream(f1);
			wb1 = new XSSFWorkbook(fis);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
			ws1 = wb1.getSheetAt(0);
			getAnswer(QuestionNumber);
			fis.close();
			wb1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAnswer(String Check) {

		try {
			Map<String, String> data = getfielddataforStall(question.trim());
			outcome = data.get(Check);
			System.out.println("Answer for the Question number " + question.trim() + " is: " + outcome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outcome;

	}

	public Date yesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(dateFormat.format(yesterday()));
		return dateFormat.format(yesterday());
	}

	/* =============================== */

	public Map<String, String> getfield(String rtocode) {

		Map<String, String> data = new HashMap<>();
		if (!data.isEmpty()) {
			data.clear();
		}
		try {
			int rowcount = ws1.getLastRowNum();
			// System.out.println("Row Count: " + rowcount);
			int colcount = ws1.getRow(rowcount).getLastCellNum();
			// System.out.println("Column Count: " + colcount);
			for (int i = 0; i <= rowcount; i++) {
				String rtcode = ws1.getRow(i).getCell(1).getStringCellValue();
				// System.out.println(rtcode);
				if (rtcode.equalsIgnoreCase(rtocode.trim())) {
					for (int j = 0; j < colcount; j++) {
						String header = ws1.getRow(0).getCell(j).getStringCellValue();
						String coldata = ws1.getRow(i).getCell(j).getStringCellValue();
						data.put(header, coldata);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;

	}

	public void ConnecttoExcelforS4customrto(String rcode, String Filename) {

		try {

			String FilePath = "Database\\" + Filename + ".xlsx";
			File f1 = new File(FilePath);
			fis = new FileInputStream(f1);
			wb1 = new XSSFWorkbook(fis);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
			ws1 = wb1.getSheetAt(0);
			getAnswerforotpcheck(rcode);
			fis.close();
			wb1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getAnswerforotpcheck(String Check) {

		try {
			Map<String, String> data = getfield(code.trim());
			outcome = data.get(Check);
			System.out.println("RTO Code is " + code.trim() + " is: " + outcome);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outcome;

	}

	public String getIPAddress() {
		String systemipaddress = "";
		try {
//			InetAddress IP = InetAddress.getLocalHost();
//			System.out.println("IP of my system is := " + IP.getHostAddress());
//			systemipaddress = IP.getHostAddress();
			URL url_name = new URL("http://bot.whatismyipaddress.com");
			BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
			// reads system IPAddress
			systemipaddress = sc.readLine().trim();
		} catch (Exception e) {
			systemipaddress = "Cannot Execute Properly";
		}
		// Print IP address
		System.out.println("Public IP Address: " + systemipaddress + "\n");
		return systemipaddress;
	}

	public void waitforAlerttobepresent(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			if (alertExist(driver)) {
				System.out.println("Alert Present");
				acceptAlert(driver);
			} else {
				System.out.println("There is no Alert present");
			}
		} catch (NoAlertPresentException noAlert) {
			noAlert.getMessage();
		}
	}
	
	 public static String showMenu(){
	        JFrame frame = new JFrame();
	        frame.setAlwaysOnTop(true);
	        Object[] options = {"Different Applicant", "Same Applicant"};
	        Object selectionObject = JOptionPane.showInputDialog(frame, "Choose", "Menu", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	        selectionString = selectionObject.toString();
	        return selectionString;
	    }
	 

}
