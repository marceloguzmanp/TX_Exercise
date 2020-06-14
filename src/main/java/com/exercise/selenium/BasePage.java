package com.exercise.selenium;

import com.exercise.selenium.webdriver.DriverFactory;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  public List<List<String>> getTableValues(By tableBy) {
    WebElement tableElements = driver.findElement(tableBy);
    List<List<String>> elementListOfLists = new ArrayList<>();
    List<WebElement> tableRows = tableElements.findElements(By.tagName("tr"));
    for (WebElement tableRow : tableRows) {
      List<WebElement> columnsRow = tableRow.findElements(By.tagName("td"));
      ArrayList<String> columnList = new ArrayList<>();
      // Gets only the second and third columns (Description, AVail.)
      for (int column = 1; column <= 2; column++) {
        String celtext = columnsRow.get(column).getText();
        columnList.add(celtext);
      }
      elementListOfLists.add(columnList);
    }
    return elementListOfLists;
  }
}
