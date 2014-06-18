package com.custommade.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.custommade.utility.EmailUtility;

/**
 * 
 * @author anokh ClassName: CustomMadeListener Description: This class is
 *         implementing the listener interface of testng. This class provides
 *         the status such as high priority tests run, failed, passed, skipped,
 *         etc.
 */
public class CustomMadeListener implements ISuiteListener, ITestListener {
	private int testRun = 0;
	private int testPassed = 0;
	private int testFailed = 0;
	private int testSkipped = 0;
	private int highPriorityPass = 0;
	private int highPriorityFail = 0;
	private int highPrioritySkip = 0;
	private int normalPriorityRun = 0;
	private int normalPriorityPass = 0;
	private int normalPriorityFail = 0;
	private int normalPrioritySkip = 0;
	private int lowPriorityPass = 0;
	private int lowPriorityFail = 0;
	private int lowPrioritySkip = 0;
	private int lowPriorityRun;
	private String priorityStatus;
	private static String priority;

	/*
	 * Method Name: onStart() Description: This function will be called just
	 * before the test suite is executed.
	 */
	@Override
	public void onStart(ISuite suite) {

	}

	/*
	 * Method Name: setPriority() Description: This function is for setting the
	 * priority of the test case.
	 */
	public static void setPriority(String testPriority) {
		priority = testPriority;
	}

	/*
	 * Method Name: getPriorityStart() Description: This function is for getting
	 * the priority of the test case.
	 */
	public static String getPriority() {
		return priority;
	}

	/*
	 * Method Name: onTestStart() Description: This function will be called just
	 * before the test case is executed.
	 */
	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("Started " + iTestResult.getTestContext().getName() + "->" + iTestResult.getName());
		testRun++;
	}

	/*
	 * Method Name: onTestSuccess() Description: This function will be called
	 * when a test case is successfully executed.
	 */
	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println(iTestResult.getTestContext().getName() + "->" + iTestResult.getName() + " passed");
		priorityStatus = getPriority();
		testPassed++;
		if (priority == "high") {
			highPriorityPass++;
		} else if (priority == "normal") {
			normalPriorityPass++;
		} else if (priority == "low") {
			lowPriorityPass++;
		}
	}

	/*
	 * Method Name: onTestFailure() Description: This function will be called
	 * when a test case fails.
	 */
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println(iTestResult.getTestContext().getName() + "->" + iTestResult.getName() + " failed");
		testFailed++;
		if (priority == "high") {
			highPriorityFail++;
		} else if (priority == "normal") {
			normalPriorityFail++;
		} else if (priority == "low") {
			lowPriorityFail++;
		}
	}

	/*
	 * Method Name: onTestSkipped() Description: This function will be called
	 * when a test case execution is skipped.
	 */
	@Override
	public void onTestSkipped(ITestResult arg0) {
		testSkipped++;
		if (priority == "high") {
			highPrioritySkip++;
		} else if (priority == "normal") {
			normalPrioritySkip++;
		} else if (priority == "low") {
			lowPrioritySkip++;
		}
	}

	/*
	 * Method Name: onFinish() Description: This function will be called after a
	 * test suite is executed.
	 */
	@Override
	public void onFinish(ISuite suite) {
	}

	/*
	 * Method Name: onFinish() Description: This function will be called after
	 * all the test cases are executed. This method will also send a mail
	 * regarding the execution status.
	 */
	@Override
	public void onFinish(ITestContext arg0) {
		String testsRun = "Total Tests run: " + testRun;
		String testsPassed = "Tests passed: " + testPassed;
		String testsFailed = "Tests failed: " + testFailed;
		String testsSkipped = "Tests skipped: " + testSkipped;
		String highPriorityTestsPassed = "High priority test passed is : "
				+ highPriorityPass;
		String highProrityTestsFailed = "High priority test failed is : "
				+ highPriorityFail;
		String highPriorityTestsSkipped = "High priority test skipped is : "
				+ highPrioritySkip;
		String mailText = testsRun + "\n" + testsPassed + "\n" + testsFailed
				+ "\n" + testsSkipped + "\n\n" + highPriorityTestsPassed + "\n"
				+ highProrityTestsFailed + "\n" + highPriorityTestsSkipped;
		EmailUtility emailUtilityObj = new EmailUtility();
		emailUtilityObj.sendEmailForPriority(mailText);
	}

	/*
	 * Method Name: onStart() Description: This function will be called after
	 * the test cases are started.
	 */
	@Override
	public void onStart(ITestContext arg0) {
	}

	/*
	 * Method Name: onTestFailedButWithinSuccessPercentage() Description: This
	 * function will be called when the test case execution fails but lies
	 * within success percentage.
	 */
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

}