package org.meta.facebook.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.meta.facebook.testUtils.AndroidBaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Signup extends AndroidBaseTest {

	@Test(dataProvider = "getData", groups = { "Regression" })
	public void SignupTest(HashMap<String, String> input) throws InterruptedException {
		signupPage.clickCreateNewAcc();
		signupPage.clickGetStarted();
		signupPage.setFirstName(input.get("firstName"));
		signupPage.setFirstName(input.get("lastName"));
		signupPage.clickNext();
		signupPage.swipeYear();
		signupPage.clickSet();
		signupPage.clickNext();
		signupPage.clickGender();
		signupPage.clickNext();
		signupPage.setMobileNumber(input.get("mobile"));
		signupPage.clickNext();
		signupPage.setPassword(input.get("password"));
		signupPage.clickNext();
		signupPage.clickNotNow();
		signupPage.clickAgree();
		Thread.sleep(30000);

		Assert.assertEquals(signupPage.getConfirmText(), input.get("firstName")+" "+input.get("lastName"));


	}


	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "//src//test//java//org//meta//facebook//testData//dataFacebook.json");

		return new Object[][] { { data.get(0) } };
	}

}
