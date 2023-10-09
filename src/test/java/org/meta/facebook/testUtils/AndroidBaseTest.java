package org.meta.facebook.testUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.meta.facebook.pageObject.android.SignupPage;
import org.meta.facebook.utils.AppiumUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {
	public AppiumDriverLocalService service;
	public SignupPage signupPage;

	@BeforeMethod
	public void ConfigureAppium() throws IOException {

		prop = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//org//meta//facebook//resources//data.properties");
		String ipAddress = System.getProperty("ipAddress") != null ? System.getProperty("ipAddress")
				: prop.getProperty("ipAddress");
		prop.load(fs);
		String port = prop.getProperty("port");

		service = startAppiumServer(ipAddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		options.setCapability("autoGrantPermissions", true);

		options.setApp(System.getProperty("user.dir")
				+ "\\src\\test\\java\\org\\meta\\facebook\\testResources\\Facebook_Android.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		signupPage = new SignupPage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
