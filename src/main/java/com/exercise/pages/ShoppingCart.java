package com.exercise.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.exercise.selenium.BasePage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the Shopping Cart page.
 */
public class ShoppingCart extends BasePage {

  @FindBy(id = "cart_title")
  private WebElement cartTitle;

  @FindBy(css = "#total_price")
  private WebElement totalAmount;

  private static By ITEM_LIST_LOCATOR = By.xpath("//*[@id='cart_summary']/tbody");
  private static String DELETE_ITEM_BUTTON_LOCATOR = "//a[text()='%s']/../../following-sibling::td//a[@title='Delete']";

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(visibilityOf(cartTitle));
  }

  /**
   * Gets a list with all the items present on Cart.
   *
   * @return list of lists with the item values.
   */
  public List<List<String>> getCartItemList() {
    return getTableValues(ITEM_LIST_LOCATOR);
  }

  /**
   * Removes an item from Cart.
   *
   * @param itemName the item name.
   * @return ShoppingCart instance.
   */
  public ShoppingCart removeItem(final String itemName) {
    driverTools.clickElement(By.xpath(String.format(DELETE_ITEM_BUTTON_LOCATOR, itemName)));
    driverTools
        .waitUntilElementNotPresent(By.xpath(String.format(DELETE_ITEM_BUTTON_LOCATOR, itemName)));
    return this;
  }

  /**
   * Gets Total Amount value.
   *
   * @return the total amount.
   */
  public String getTotalAmount() {
    return driverTools.getElementText(totalAmount);
  }
}
