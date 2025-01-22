package com.ui.utilities;

import java.util.Locale;
import com.github.javafaker.Faker;
import com.ui.pojos.MyAddressPOJO;

public class FakeDataGenerateUtility {
	
	public static MyAddressPOJO getFakeAddress() {
		Faker faker=new Faker(Locale.US);
		MyAddressPOJO addressPOJO= new MyAddressPOJO(faker.company().name(),
				faker.address().buildingNumber(),
				faker.address().streetAddress(),
				faker.address().city(),
				faker.numerify("#####"),/*with numerify() we can control with how many digits we want*/
				faker.phoneNumber().cellPhone(),
				faker.phoneNumber().cellPhone(),
				"other",
				"office address",
				faker.address().state());
		return addressPOJO;
		
		/*
		 *we can also use MyAddressPOJOWithListConstructor class to pass the data to that class
		 * List<String> data=new ArrayList<>();
		data.add(faker.company().name());
		MyAddressPOJOWithListConstructor lc=new MyAddressPOJOWithListConstructor(data);
		return lc;
		*/
	}

}
