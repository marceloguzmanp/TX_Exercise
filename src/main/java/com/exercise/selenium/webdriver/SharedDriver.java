package com.exercise.selenium.webdriver;

import com.exercise.constants.Browser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.exercise.selenium.WebDriverConfigReader;

/**
 * Creates a driver and adds it to the thread.
 */
public class SharedDriver {

  /**
   * Creates the driver, maximize it and manage its timeouts.
   */
  public SharedDriver() {
    if (DriverFactory.getDriver() == null) {
      String browser = WebDriverConfigReader.getInstance().getBrowser();
      WebDriver driver = BrowserFactory.getDriver(Browser.valueOf(browser));
      driver.manage().window().maximize();
      driver.manage().timeouts().
          implicitlyWait(WebDriverConfigReader.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
      DriverFactory.addDriver(driver);
    }
  }
}
