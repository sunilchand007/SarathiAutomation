package frameworkLibrary;

import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pageobjects.StateSelectionPage;
import pageobjects.StateSpecificHomePage;
import utility.DriverManager;
import utility.Utilitymethods;



public class BaseClass extends BasePage {
	public static LinkedHashMap<String, Boolean> allTestItems = new LinkedHashMap<String, Boolean>();
	public static int currentIteration = 0;
	public WebDriver driver;
	  StateSelectionPage stateSelectionPage;
		StateSpecificHomePage stateSpecificHomePage;
	//DataLibrary  datalibrary ;
	@BeforeSuite
	public void beforesuite()
	{
		
		CreateNewExtentReportInResultsFolderWithDateAndTimeStamp();

	}
	
	@BeforeMethod
	
	public void beforemethod(ITestContext context) throws IOException
	{
		//get all test methods and store in the form of key and value pairs, with key = ModuleName+MethodName+InvocationNumber and Value = isExecuted
		for(ITestNGMethod testMethod:context.getAllTestMethods())
		{
			String moduleName = testMethod.getTestClass().getRealClass().getSimpleName();
			String testMethodName = testMethod.getMethodName();
			int totalIterations = testMethod.getInvocationCount();
			for(int iteration = 1;iteration<=totalIterations;iteration++)
			{
				String key = moduleName + ";;" + testMethodName + ";;" + iteration;
				if(!allTestItems.containsKey(key))
				{
					allTestItems.put(key, false);
				}
			}
		}

		//get the key of the next method which is about to execute
		String currentKey = null;
		for(String key:allTestItems.keySet())
		{
			if(allTestItems.get(key)==false)
			{
				currentKey = key;
				allTestItems.put(key, true);
				break;
			}
		}
		
		if(currentKey==null) return;
		
		//from the current key, get current modulename,testname,invocation count
		String currentModuleName = currentKey.split(";;")[0];
		String currentTestMethodName = currentKey.split(";;")[1];
		String currentInvocationCount = currentKey.split(";;")[2];
		
		currentIteration = Integer.parseInt(currentInvocationCount);
		/*datalibrary = new DataLibrary();
		String Scenerio = datalibrary.getdata("Scenerio");
		*/
		FrameworkVariables.getInstance().setCurrentTestCaseName(currentTestMethodName);
		FrameworkVariables.getInstance().setCurrentModuleName(currentModuleName);
		FrameworkVariables.getInstance().setDataFilesPath(FrameworkVariables.getInstance().getCurrentFolderPath() + "\\DataFiles");
		FrameworkVariables.getInstance().setCurrentTestData();
		
		loadDataFromExceltoHashMap(currentIteration);
		
		startExtentTestForCurrentTestCase(currentIteration );
	
		
		
		
		/*
		 * driver = DriverManager.getDriver("chrome"); String env =
		 * getdata("ApplicationEnvironment");
		 * System.out.println("Testing environment is :  " + env);
		 * DriverManager.openUrl(prop.getProperty("SarathiCOV"));
		 */
		
		
		Utilitymethods	utilitymethods = new Utilitymethods(driver); 
		driver = utilitymethods.Launch_ApplicationUrl();
		
        stateSelectionPage = new StateSelectionPage(driver);
  	  stateSelectionPage.Selectstatename(getdata("State")); 
  	  stateSpecificHomePage = new StateSpecificHomePage(driver);
  	  stateSpecificHomePage.closeContactlessLicenceServicesPopup();
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result,ITestContext testmethod)
	{
		endExtentTestForCurrentTestCase();
		loadDataFromHashMaptoExcel(currentIteration);
	}
	
	@AfterSuite
	public void aftersuite() throws IOException, EmailException
	{
		closeExtentReport();
		BackupFile(FrameworkVariables.getInstance().getCurrentModuleName(), FrameworkVariables.getInstance().getCurrentModuleName()+"_TestBackupFile");
		launchResult();

	}
}
