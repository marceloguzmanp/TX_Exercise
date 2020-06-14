package com.exercise.pages;

import com.exercise.selenium.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Represents the main page.
 */
public class MainPage extends BasePage {

  @FindBy(css = "a[class='blockbestsellers']")
  private WebElement bestSellersLink;

  @FindBy(css = "a[title='View my shopping cart']")
  private WebElement cartDropDown;

  @FindBy(id = "button_order_cart")
  private WebElement checkoutButton;

  private static String BEST_SELLERS_ACTIVE_LINK = "//li[@class='active']/a[text()='%s']";
  private static String ITEM_DISCOUNT = "//*[contains(@class,'tab-pane active')]/li/div//a[contains(text(),'%s')]/../following-sibling::div/span[@class='price-percent-reduction']";
  private static String ITEM_IMAGE = "//*[contains(@class,'tab-pane active')]/li/div//img[@title='%s']";
  private static String ITEM_ADD_TO_CART_BUTTON = "//*[contains(@class,'tab-pane active')]/li/div//a[contains(text(),'%s')]/../following-sibling::div/a[@title='Add to cart']";

  @Override
  public void waitUntilPageObjectIsLoaded() {
  }

  /**
   * Clicks 'Best Sellers' link.
   *
   * @return MainPage instance.
   */
  public MainPage clickBestSellersLink(final String tab) {
    driverTools.clickElement(bestSellersLink);
    wait.until(ExpectedConditions
        .visibilityOfElementLocated(By.xpath(String.format(BEST_SELLERS_ACTIVE_LINK, tab))));
    return this;
  }

  /**
   * Gets the item discount
   *
   * @param itemName the item name.
   * @return item discount value.
   */
  public String getItemDiscount(final String itemName) {
    return driverTools.getElementTextBySelector(By.xpath(String.format(ITEM_DISCOUNT, itemName)))
        .replaceAll("-", "");
  }

  /**
   * Clicks 'Add to Cart' button.
   *
   * @param itemName the item name.
   * @return LayerCart instance.
   */
  public LayerCart addToCart(final String itemName) {
    driverTools.hoverElement(By.xpath(String.format(ITEM_IMAGE, itemName)));
    driverTools.clickElement(By.xpath(String.format(ITEM_ADD_TO_CART_BUTTON, itemName)));
    return new LayerCart();
  }

  /**
   * Clicks 'Checkout' button.
   *
   * @return ShoppingCart instance.
   */
  public ShoppingCart checkoutCart() {
    driverTools.hoverElement(cartDropDown);
    driverTools.clickElement(checkoutButton);
    return new ShoppingCart();
  }
}
