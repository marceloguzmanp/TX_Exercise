package com.exercise.selenium.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Handles Firefox driver.
 */
public class FireFox implements IDriver {

  @Override
  public WebDriver initDriver() {
    WebDriverManager.firefoxdriver().setup();
    return new FirefoxDriver();
  }
}
