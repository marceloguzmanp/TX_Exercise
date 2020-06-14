package com.exercise.selenium.webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Contains methods to add, get or remove the driver of a thread.
 */
public class DriverFactory {

  private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

  // To quit the drivers and browsers at the end of the execution.
  private static List<WebDriver> storedDrivers = new ArrayList<>();

  static {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> storedDrivers.forEach(WebDriver::quit)));
  }

  /**
   * Class constructor.
   */
  private DriverFactory() {
  }

  /**
   * Gets the current driver.
   *
   * @return Webdriver.
   */
  public static WebDriver getDriver() {
    return drivers.get();
  }

  /**
   * Adding driver.
   *
   * @param driver WebDriver.
   */
  public static void addDriver(final WebDriver driver) {
    storedDrivers.add(driver);
    drivers.set(driver);
  }
}
