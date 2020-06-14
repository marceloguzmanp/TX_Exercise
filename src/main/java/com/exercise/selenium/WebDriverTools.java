package com.exercise.selenium;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class to manage Web Driver tools.
 */
public class WebDriverTools {

  private WebDriver driver;
  private WebDriverWait wait;
  private static final Logger log = Logger.getLogger(WebDriverTools.class);


  /**
   * Class constructor.
   *
   * @param driver driver.
   * @param wait   driver wait time.
   */
  public WebDriverTools(final WebDriver driver, final WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  /**
   * Waits and click on the webElement.
   *
   * @param webElement the WebElement to wait and click.
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

  /**
   * Waits and gets the text of a WebElement.
   *
   * @param webElement WebElement to wait and get the text.
   * @return the WebElement text.
   */
  public String getElementText(WebElement webElement) {
    wait.until(ExpectedConditions.visibilityOf(webElement));
    return webElement.getText();
  }

  /**
   * Gets the text given and By selector.
   *
   * @param by By selector to get the text value.
   * @return the selector text.
   */
  public String getElementTextBySelector(By by) {
    return driver.findElement(by).getText();
  }

  /**
   * Hover over an element.
   *
   * @param element the WebElement.
   */
  public void hoverElement(WebElement element) {
    Actions builder = new Actions(driver);
    builder.moveToElement(element).build().perform();
  }

  /**
   * Hover over an element By selector.
   *
   * @param by By selector to hover.
   */
  public void hoverElement(By by) {
    Actions builder = new Actions(driver);
    WebElement element = driver.findElement(by);
    builder.moveToElement(element).build().perform();
  }

  /**
   * Waits until a WebElement is not present.
   *
   * @param by the By selector.
   */
  public void waitUntilElementNotPresent(By by) {
    try {
      wait.until(invisibilityOfElementLocated(by));
    } catch (NoSuchElementException | TimeoutException e) {
      log.info(format("Exception when waiting for element invisibility: %s", by));
    }
  }
}
