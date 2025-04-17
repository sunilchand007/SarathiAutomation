package frameworkLibrary;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReportLibrary extends DataLibrary
{
		protected  void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,WebDriver driver) 
		{
			if (stepstatus == true) 
			{
				System.out.println("	<<PASS>> " + PassMessage);
				FrameworkVariables.getInstance().getExtentTest().log(LogStatus.PASS, PassMessage);
			} 
			else 
			{
				System.out.println("	<<FAIL>> " + FailMessage);
				System.out.println("");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				FrameworkVariables.getInstance().getExceptionDescription().printStackTrace();
				FrameworkVariables.getInstance().getExtentTest().log(LogStatus.FAIL, FailMessage + FrameworkVariables.getInstance().getExtentTest().addScreenCapture(getScreenshot(driver)));
			}
			//Hard assertion
			Assert.assertEquals(stepstatus, true);
		}
		
		protected  void reportEvent(boolean stepstatus,String PassMessage, String FailMessage,WebDriver driver,boolean takescrrenshot) 
		{
			if (stepstatus == true) 
			{
				System.out.println("	<<PASS>> " + PassMessage);
				if (takescrrenshot==true) 
				{
					FrameworkVariables.getInstance().getExtentTest().log(LogStatus.PASS, PassMessage  + FrameworkVariables.getInstance().getExtentTest().addScreenCapture(getScreenshot(driver)));
				} 
				else 
				{
					FrameworkVariables.getInstance().getExtentTest().log(LogStatus.PASS, PassMessage);
				}
			} 
			else 
			{
				System.out.println("	<<FAIL>> " + FailMessage);
				System.out.println("");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Exception description  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				FrameworkVariables.getInstance().getExceptionDescription().printStackTrace();
				if (takescrrenshot==true) 
				{
					FrameworkVariables.getInstance().getExtentTest().log(LogStatus.FAIL, FailMessage + FrameworkVariables.getInstance().getExtentTest().addScreenCapture(getScreenshot(driver)));
				} 
				else 
				{
					FrameworkVariables.getInstance().getExtentTest().log(LogStatus.FAIL, FailMessage);
				}
			}
			Assert.assertEquals(stepstatus, true);
		}
			public  void CreateNewExtentReportInResultsFolderWithDateAndTimeStamp()
			{
				// get current folder path
				FrameworkVariables.getInstance().setCurrentFolderPath(System.getProperty("user.dir"));

				// create folder with date and time stamp
				DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
				String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
				DateTimeStamp = DateTimeStamp.replace(",", "");
				DateTimeStamp = DateTimeStamp.replace(" ", "_");
				DateTimeStamp = DateTimeStamp.replace(":", "-");
				FrameworkVariables.getInstance().setCurrentResultPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\Results\\");
				File dir = new File(FrameworkVariables.getInstance().getCurrentResultPath());
				dir.mkdir();
				
				//create folder with name as Scrrenshots
				File dir1 = new File(FrameworkVariables.getInstance().getCurrentResultPath() + "\\Screenshots");
				dir1.mkdir();

				// create extent report
				FrameworkVariables.getInstance().setExtentReports(new ExtentReports(FrameworkVariables.getInstance().getCurrentResultPath() + "\\Summary.html", true));
				
			}
			
			public  void startExtentTestForCurrentTestCase(int CurrentIteration)
			{
				FrameworkVariables.getInstance().setExtentTest(FrameworkVariables.getInstance().getExtentReports().startTest("Test Case Description--->"+ ": "+getdata("Scenerio")));
				System.out.println("<<TestStart>>" + FrameworkVariables.getInstance().getCurrentTestCaseName() + " Iteration:" + CurrentIteration + "_"+ getdata("Scenerio")  );
			}
		
			public  void endExtentTestForCurrentTestCase()
			{
				FrameworkVariables.getInstance().getExtentReports().endTest(FrameworkVariables.getInstance().getExtentTest());
				System.out.println("<<TestCompleted>>" + FrameworkVariables.getInstance().getCurrentTestCaseName());
			}
			
			public  void closeExtentReport()
			{
				FrameworkVariables.getInstance().getExtentReports().close();
			}
			
			public  void launchResult() throws IOException, EmailException
			{
				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.get(FrameworkVariables.getInstance().getCurrentResultPath()+ "//Summary.html");
				System.out.println("launched the result ");
				/*driver.get("https://sarathi.parivahan.gov.in/sarathisupport/login?back_url=http%3A%2F%2Fsarathi.parivahan.gov.in%2Fsarathisupport%2F");
				driver.manage().window().maximize();
				driver.findElement(By.xpath("//input[@id='username']")).sendKeys("sarprg6");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("nic12345");
				driver.findElement(By.id("login-submit")).click();
				driver.findElement(By.xpath("(//a[text() = 'TestData from Automation Team'])[1]")).click();
				driver.findElement(By.xpath("(//a[text() = 'Edit'])[1]")).click();
				driver.findElement(By.xpath("//textarea[@id = 'issue_notes']")).sendKeys("Plz find the Test report");
				driver.findElement(By.xpath("//input[@type= 'file']")).sendKeys("D:/SarathiSeleniumPOMWork/POMFramework_Sarathi/test-output/emailable-report.html\r\n" + 
						"");
				*/
				//driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
				/*
				 * String zip = Zip.zip(new
				 * File("D:\\SarathiAutomation_Execution\\POMFramework_Sarathi\\Results"));
				 * BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(
				 * "D:\\SarathiAutomation_Execution\\POMFramework_Sarathi\\Results.zip"),10000);
				 * byte[] decode = Base64.getDecoder().decode(zip); stream.write(decode);
				 * stream.close(); System.out.println("zip completed ");
				 */
					System.out.println("Email started");
					DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
					String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
					 // Create the attachment
						
						  EmailAttachment attachment = new EmailAttachment(); 
						  attachment.setPath("D:\\SarathiAutomation\\POMFramework_Sarathi\\DataFiles\\Transaction_501.xlsx");
						  attachment.setDisposition(EmailAttachment.ATTACHMENT);
						  attachment.setDescription("Test report");
						  attachment.setName("Automation TestReport"+ " " + DateTimeStamp);
						 
					  // Create the email message
					  MultiPartEmail email1 = new MultiPartEmail();
					  email1.setHostName("smtp.gmail.com");
					  email1.setSmtpPort(465);
					  email1.setAuthenticator(new DefaultAuthenticator("sunilchand700@gmail.com", "kdlf ukeg hueg tiby"));
					
					  email1.setSSLOnConnect(true);
					  email1.setFrom("sunilchand700@gmail.com");
					  email1.setSubject("Automation TestReport"+ " _ " + DateTimeStamp);
					  email1.setMsg("Dear Team , This email is for testing --- Thanks and Regards Automation Team ");
					  email1.addTo("sarprg11.hyd@supportgov.in","sarprg6@nic.in","sarprg20@nic.in","sarprg5@nic.in","sarprg2@nic.in");
					  // add the attachment
					  email1.attach(attachment);
					  // send the email
					  email1.send();
					System.out.println("Email sent");
			}

			public  String  getScreenshot(WebDriver driver){
				
			String Dest = FrameworkVariables.getInstance().getCurrentResultPath() + "\\Screenshots\\";
				 //String Dest = System.getProperty("user.dir")+"/ExtentReports/"; 
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			String DateTimeStamp = dateTimeInstance.format(Calendar.getInstance().getTime());
				try 
				{
					DateFormat dateTimeInstance1 = SimpleDateFormat.getDateTimeInstance();
					String DateTimeStamp1 = dateTimeInstance.format(Calendar.getInstance().getTime());
					DateTimeStamp = DateTimeStamp.replace(",", "");
					DateTimeStamp = DateTimeStamp.replace(" ", "_");
					DateTimeStamp = DateTimeStamp.replace(":", "-");

					Dest = Dest + FrameworkVariables.getInstance().getCurrentTestCaseName() + DateTimeStamp + ".png";

					TakesScreenshot ts = (TakesScreenshot) driver;
					File source = ts.getScreenshotAs(OutputType.FILE);
					File destinationfile = new File(Dest);
					FileUtils.copyFile(source, destinationfile);

					// Get entire page screenshot
					File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
					ImageIO.write(ImageIO.read(screenshot), "png", screenshot);

					// Copy the element screenshot to disk
					FileUtils.copyFile(screenshot, new File(Dest));
				} 
				catch (Exception e) 
				{
					System.out.println("Exception occured while taking Scrrenshot");
				}
				
				Dest = "./Screenshots/" + FrameworkVariables.getInstance().getCurrentTestCaseName() + DateTimeStamp + ".png";

				return Dest;
			}
			
}
