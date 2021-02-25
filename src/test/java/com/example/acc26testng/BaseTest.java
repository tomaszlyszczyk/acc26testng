package com.example.acc26testng;

import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    //Declare ThreadLocal Driver (ThreadLocalMap) for ThreadSafe Tests
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private final FirefoxOptions firefoxOptions = new FirefoxOptions();

    public ChromeOptions setupChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-position=2000,0");
        return options;
    }

    @BeforeMethod
    @Parameters(value={"browser"})
    public void setup (String browser) throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        if (browser.equals("chrome")) {
//            driver.set(new ChromeDriver(setupChromeOptions()));
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), setupChromeOptions()));
        } else if (browser.equals("firefox")) {
            driver.set(new FirefoxDriver());
//            driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions));
        }
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    @AfterClass void terminate () {
        driver.remove();
    }
}