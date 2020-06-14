package com.exercise.selenium;

import static com.exercise.constants.PropertiesInput.BROWSER;
import static com.exercise.constants.PropertiesInput.EXPLICIT_WAIT_TIME;
import static com.exercise.constants.PropertiesInput.IMPLICIT_WAIT_TIME;
import static com.exercise.constants.PropertiesInput.WAIT_SLEEP_TIME;

import com.exercise.utils.PropertiesManager;
import org.apache.log4j.Logger;

/**
 * Manages Web Driver configuration.
 */
public class WebDriverConfigReader {

  private Logger log = Logger.getLogger(getClass());
  private static WebDriverConfigReader instance;
  private static PropertiesManager properties = PropertiesManager.getInstance();
  private String browser;
  private int implicitWaitTime;
  private int explicitWaitTime;
  private int waitSleepTime;

  /**
   * Class constructor.
   */
  private WebDriverConfigReader() {
    initialize();
  }

  /**
   * Constructor of WebDriverConfigReader. Gets WebDriverConfigReader as Singleton.
   *
   * @return WebDriverConfigReader instance.
   */
  public static WebDriverConfigReader getInstance() {
    if (instance == null) {
      instance = new WebDriverConfigReader();
    }
    return instance;
  }

  /**
   * Initializes according properties.
   */
  private void initialize() {
    log.info("WebDriverConfigReader initialize.");
    browser = properties.getProperty(BROWSER);
    implicitWaitTime = Integer.parseInt(properties.getProperty(IMPLICIT_WAIT_TIME));
    explicitWaitTime = Integer.parseInt(properties.getProperty(EXPLICIT_WAIT_TIME));
    waitSleepTime = Integer.parseInt(properties.getProperty(WAIT_SLEEP_TIME));
  }

  /**
   * Gets the browser in which the tests are being executed.
   *
   * @return Browser.
   */
  public String getBrowser() {
    return browser;
  }

  /**
   * Gets the implicit wait time set for the WebDriver.
   *
   * @return The implicit time.
   */
  public int getImplicitWaitTime() {
    return implicitWaitTime;
  }

  /**
   * Gets the explicit wait time set for the WebDriver.
   *
   * @return The explicit time.
   */
  public int getExplicitWaitTime() {
    return explicitWaitTime;
  }

  /**
   * Gets the sleep time wait set for the WebDriver.
   *
   * @return Sleep time wait.
   */
  public int getWaitSleepTime() {
    return waitSleepTime;
  }
}
