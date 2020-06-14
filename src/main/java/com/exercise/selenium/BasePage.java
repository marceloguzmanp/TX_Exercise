package com.exercise.selenium;

import com.exercise.selenium.webdriver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage class.
 */
public abstract class BasePage {

  protected WebDriver driver;
  protected WebDriverWait wait;
  protected WebDriverTools driverTools;

  /**
   * Initializes the web driver, wait, web driver tools and web elements.
   */
  public BasePage() {
    driver = DriverFactory.getDriver();
    wait = new WebDriverWait(driver, WebDriverConfigReader.getInstance().getExplicitWaitTime(),
        WebDriverConfigReader.getInstance().getWaitSleepTime());
    driverTools = new WebDriverTools(driver, wait);
    PageFactory.initElements(driver, this);
    waitUntilPageObjectIsLoaded();
  }

  /**
   * Waits until page object is loaded.
   */
  public abstract void waitUntilPageObjectIsLoaded();
}
