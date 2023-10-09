package org.meta.facebook.pageObject.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.meta.facebook.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignupPage extends AndroidActions {

	AndroidDriver driver;

	public SignupPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Create new account']")
	WebElement btnCreateNewAcc;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Get started']")
	WebElement btnGetStarted;

	@AndroidFindBy(xpath = "//android.view.View[@text='Next']")
	WebElement btnNext;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='']")
	List<WebElement> inputText;

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='android:id/numberpicker_input']")
	List<WebElement> datePicker;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='SET']")
	WebElement btnSet;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Male']")
	WebElement btnMale;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Female']")
	WebElement btnFemale;

	@AndroidFindBy(xpath = "//android.view.View[@text='Not now']")
	WebElement btnNotNow;

	@AndroidFindBy(xpath = "//android.view.View[@text='Save']")
	WebElement btnSave;

	@AndroidFindBy(xpath = "//android.view.View[@text='I agree']")
	WebElement btnAgree;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Clear Mobile number text']")
	WebElement btnClear;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.facebook.katana:id/(name removed)']")
	WebElement confirmText;



	public void clickCreateNewAcc() {
		btnCreateNewAcc.click();
	}

	public void clickGetStarted() {
		btnGetStarted.click();
	}

	public void clickSet() {
		btnSet.click();
	}

	public void clickNotNow() {
		btnNotNow.click();
	}

	public void clickSave() {
		btnSave.click();
	}

	public void clickGender() {
		btnMale.click();
	}

	public void clickAgree() {
		btnAgree.click();
	}

	public void setFirstName(String firstName){
		inputText.get(0).click();
		inputText.get(0).sendKeys(firstName);
	}

	public void setLastName(String lastName){
		inputText.get(1).click();
		inputText.get(1).sendKeys(lastName);
	}

	public void setMobileNumber(String mobileNumber){
		if(btnClear.isDisplayed()) {
			btnClear.click();
			inputText.get(0).click();
			inputText.get(0).sendKeys(mobileNumber);
		}
		else {
			inputText.get(0).click();
			inputText.get(0).sendKeys(mobileNumber);
		}
	}

	public void setPassword(String password){
		inputText.get(0).click();
		inputText.get(0).sendKeys(password);
	}

	public void clickNext() {
		btnNext.click();
	}

	public void swipeYear() throws InterruptedException {
		for (int i = 0; Integer.parseInt(datePicker.get(2).getText())> 2003; i++) {
			swipe(datePicker.get(2), 750, 1320);
			Thread.sleep(2000);
		}
	}

	public void swipeDay() throws InterruptedException {
		for (int i = 0; datePicker.get(1).getText().equals("23")!= true; i++) {
			swipe(datePicker.get(1), 525, 1320);
			Thread.sleep(2000);
		}
	}

	public void swipeMonth() throws InterruptedException {
		for (int i = 0; datePicker.get(0).getText().equals("Nov")!= true; i++) {
			swipe(datePicker.get(0), 310, 1320);
			Thread.sleep(2000);
		}
	}

	public String getConfirmText() {
		String[] mobile = confirmText.getText().split(" ");
		String fullName = mobile[5]+" "+ mobile[6];
		return fullName;
	}

}
