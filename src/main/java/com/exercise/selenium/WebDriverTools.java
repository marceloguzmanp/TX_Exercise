package com.exercise.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to manage Web Driver tools.
 */
public class WebDriverTools {

  private WebDriver driver;
  private WebDriverWait wait;
  private static final Logger LOGGER = Logger.getLogger(WebDriverTools.class);


  /**
   * Class constructor.
   *
   * @param driver driver.
   * @param wait driver wait time.
   */
  public WebDriverTools(final WebDriver driver, final WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  /**
   * Waits and click on the webElement.
   *
   * @param webElement WebElement to wait and click.
   */
  public void clickElement(WebElement webElement) {
    wait.until(ExpectedConditions.elementToBeClickable(webElement));
    webElement.click();
  }

  /**
   * Waits and click on the webElement.
   *
   * @param by By to wait and click.
   */
  public void clickElement(By by) {
    wait.until(ExpectedConditions.elementToBeClickable(by));
    driver.findElement(by).click();
  }
}
