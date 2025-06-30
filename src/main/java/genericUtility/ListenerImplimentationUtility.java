package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
 * This class provides implimentation to ITestListner interface of Testing
 * @author Bniprava Swain
 */
public class ListenerImplimentationUtility  implements  ITestListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		// capture the mewthodName
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"test execution Started");
		
		//Create test in ExtentReport
		test =report.createTest(methodName);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// capture the method Name
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"-Test Pass");
		//Log the Test Status as PASS in Ecxtent Reports
		test.log(Status.PASS, methodName+"-TestPASS");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// capture the mewthodName
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Test Fail");
		
		//Log the Test Status as FAIL in Ecxtent Reports
	     test.log(Status.PASS, methodName+"-TestFAIL");

		
		//Capture the Exception
		System.out.println(result.getThrowable());	
		
		//Log the EXtent reoprts
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the screenshot
		SeleniumUtility s =new SeleniumUtility();
		javaUtility j =new javaUtility();
		
		//Configure screenshot name
		String screenshotName = methodName+"-"+j.getSystemData();
		try {
			s.captureScreenShot(BaseClass.sDriver, screenshotName);
			
			//Attach the SCreenshot to extent report
			test.addScreenCaptureFromBase64String(screenshotName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// capture the mewthodName
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"Test Skip");
		
		//Log the test status as SKIP in extent reports
		test.log(Status.SKIP, methodName+"-Test Skip");
		
		//Capture the Exception
		System.out.println(result.getThrowable());	
		
		//Log the exception in Extent reports
		test.log(Status.WARNING, result.getThrowable());
	
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite execution Started");
		
		//Basic setting of extentReporets
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new javaUtility().getSystemData()+".html");
		esr.config().setDocumentTitle("Swag Labs Auitomation Framework Execution");
		//Configure Eaxtent Reports
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Microsoft edge");
		report.setSystemInfo("Base env", "Test Env");
		report.setSystemInfo("Reporter Name", "Baniprava");
			}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite execution finished");
		//Generate Extent Reporets
		report.flush();
	}
	

}
