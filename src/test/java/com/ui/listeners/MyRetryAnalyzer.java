package com.ui.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import static com.constants.Environment.*;
import com.ui.utilities.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private int currentAttempt = 1;
	
	private static final int MAX_NUMBER_OF_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(QA,"MAX_NUMBER_OF_ATTEMPTS"));
	
	@Override
	public boolean retry(ITestResult result) {
		if (currentAttempt <= MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}
}
