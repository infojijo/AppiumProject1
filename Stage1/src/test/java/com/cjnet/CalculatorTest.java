package com.cjnet;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CalculatorTest {

	private AndroidDriver<MobileElement> androidDriver;
	private String output;

	@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("newCommandTimeout", 600);
		desiredCapabilities.setCapability("autoGrantPermissions", true);
		//desiredCapabilities.setCapability("app", "G:\\Android SDK\\build-tools\\27.0.0\\calculator.innovit.com.calculatrice.apk");
		//desiredCapabilities.setCapability("app-activity", "'calculator.innovit.com.calculatrice.MainActivity");
		desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		// This package name of your app (you can get it from apk info app)
		desiredCapabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");

		URL remoteUrl = new URL("http://localhost:4723/wd/hub");

		androidDriver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
	}

	@AfterTest
	public void tearDown() {
		androidDriver.quit();
	}


	@Test(priority = 1)
	public void addition() throws InterruptedException {

		List<MobileElement> calcButtons = 
				androidDriver
				.findElementsByXPath("//android.widget.RelativeLayout[@resource-id='com.sec.android.app.popupcalculator.Calculator']//android.widget.LinearLayout//android.widget.Button");

		androidDriver.findElementById("com.sec.android.app.popupcalculator:id/bt_01").click();
		System.out.println("Click on : 1");
        Thread.sleep(1000);
		androidDriver.findElementById("com.sec.android.app.popupcalculator:id/bt_add").click();
		System.out.println("Click on : add");
        Thread.sleep(1000);
		androidDriver.findElementById("com.sec.android.app.popupcalculator:id/bt_02").click();
		System.out.println("Click on : 233");
        Thread.sleep(1000);
		androidDriver.findElementById("com.sec.android.app.popupcalculator:id/bt_equal").click();
		System.out.println("Click on : Equal");
        Thread.sleep(1000);	
		output = androidDriver.findElementById("com.sec.android.app.popupcalculator:id/txtCalc").getText();
		

		//calcButtons.get(0).click();
		System.out.println("PRINTING THE RESULT");
		Thread.sleep(1000);

		/*  calcButtons.get(10).click();
        System.out.println("Click on : 6");
        Thread.sleep(1000);
        calcButtons.get(15).click();
        System.out.println("Click on : Plus");
        Thread.sleep(1000);
        calcButtons.get(13).click();
        System.out.println("Click on : 2");
        Thread.sleep(1000);
        calcButtons.get(19).click();
        System.out.println("Click on : Equal");
        Thread.sleep(1000);
		 */

		//output = androidDriver.findElementByXPath("//android.widget.Button[@content-desc=\"Equal\"]").getText();

		System.out.println("Result : " + output);

		assert output.equals("3") : "Wrong Calculation, Actual Output : " + output + "Expected : 3";

	}

	/* @Test(priority = 2)
    public void subtraction() throws InterruptedException {

        List<MobileElement> calcButtons = androidDriver.findElementsByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.Button");

        calcButtons.get(0).click();
        System.out.println("Start with 0");
        Thread.sleep(1000);

        calcButtons.get(10).click();
        System.out.println("Click on : 6");
        Thread.sleep(1000);
        calcButtons.get(11).click();
        System.out.println("Click on : Minus");
        Thread.sleep(1000);
        calcButtons.get(13).click();
        System.out.println("Click on : 2");
        Thread.sleep(1000);
        calcButtons.get(19).click();
        System.out.println("Click on : Equal");
        Thread.sleep(1000);

        output = androidDriver.findElementByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.TextView").getText();

        System.out.println("Result : " + output);

        assert output.equals("4") : "Wrong Calculation, Actual Output : " + output + "Expected : 4";

    }

    @Test(priority = 3)
    public void multiplication() throws InterruptedException {

        List<MobileElement> calcButtons = androidDriver.findElementsByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.Button");

        calcButtons.get(0).click();
        System.out.println("Start with 0");
        Thread.sleep(1000);

        calcButtons.get(10).click();
        System.out.println("Click on : 6");
        Thread.sleep(1000);
        calcButtons.get(7).click();
        System.out.println("Click on : Multiplication");
        Thread.sleep(1000);
        calcButtons.get(13).click();
        System.out.println("Click on : 2");
        Thread.sleep(1000);
        calcButtons.get(19).click();
        System.out.println("Click on : Equal");
        Thread.sleep(1000);

        output = androidDriver.findElementByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.TextView").getText();

        System.out.println("Result : " + output);

        assert output.equals("12") : "Wrong Calculation, Actual Output : " + output + "Expected : 12";

    }

    @Test(priority = 4)
    public void division() throws InterruptedException {

        List<MobileElement> calcButtons = androidDriver.findElementsByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.Button");

        calcButtons.get(0).click();
        System.out.println("Start with 0");
        Thread.sleep(1000);

        calcButtons.get(10).click();
        System.out.println("Click on : 6");
        Thread.sleep(1000);
        calcButtons.get(3).click();
        System.out.println("Click on : Division");
        Thread.sleep(1000);
        calcButtons.get(13).click();
        System.out.println("Click on : 2");
        Thread.sleep(1000);
        calcButtons.get(19).click();
        System.out.println("Click on : Equal");
        Thread.sleep(1000);

        output = androidDriver.findElementByXPath("//android.widget.RelativeLayout[@resource-id='calculator.innovit.com.calculatrice:id/MainCalculator']//android.widget.LinearLayout//android.widget.TextView").getText();

        System.out.println("Result : " + output);

        assert output.equals("3") : "Wrong Calculation, Actual Output : " + output + "Expected : 3";

    }
	 */

}
