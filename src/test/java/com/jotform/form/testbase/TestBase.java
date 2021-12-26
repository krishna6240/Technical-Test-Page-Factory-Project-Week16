package com.jotform.form.testbase;



import com.jotform.form.propertyreader.PropertyReader;
import com.jotform.form.utility.Utility;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(groups = {"regression", "sanity", "smoke"})
    public void setUp() {
        selectBrowser(browser);
    }


    @AfterMethod(groups = {"regression", "sanity", "smoke"})
    public void tearDown() {
        closeBrowser();
    }
}

