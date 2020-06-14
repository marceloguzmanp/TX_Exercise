package com.exercise.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

/**
 * Handles Chrome driver.
 */
public class Chrome implements IDriver{

  @Override
  public WebDriver initDriver() {
    WebDriverManager.chromedriver().setup();
    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("profile.default_content_settings.popups", 0);
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    chromeOptions.setExperimentalOption("prefs", chromePrefs);
    chromeOptions.addArguments("disable-popup-blocking");
    DesiredCapabilities cap = DesiredCapabilities.chrome();
    cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
    cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    return new ChromeDriver(chromeOptions);
  }
}
