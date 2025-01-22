package com.ui.dataProviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojos.UserTestData;
import com.ui.utilities.CSVReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<UserTestData> loginCSVDataprovider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
}
