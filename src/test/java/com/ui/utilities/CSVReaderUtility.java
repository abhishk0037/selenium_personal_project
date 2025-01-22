package com.ui.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojos.UserTestData;

public class CSVReaderUtility {

	public static Iterator<UserTestData > readCSVFile(String fileName) {
		
		File csvFile = new File(System.getProperty("user.dir") + "/testData/" + fileName);
		FileReader fileReader = null;
		CSVReader reader = null;
		String[] lineData; 
		
		
		List<UserTestData > userList = new ArrayList<UserTestData >();
		
		
		UserTestData  userTestData=null;

		
		try {
			fileReader = new FileReader(csvFile);
			reader = new CSVReader(fileReader);
			reader.readNext();
			
			while ((lineData = reader.readNext()) != null) {
				
				userTestData = new UserTestData(lineData[0], lineData[1]);
				userList.add(userTestData);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();

	}

}
