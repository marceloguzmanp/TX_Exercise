package com.exercise.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.exercise.selenium.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the Layer Cart page.
 */
public class LayerCart extends BasePage {

  @FindBy(id = "layer_cart")
  private WebElement closeCart;

  @FindBy(css = "span[title='Continue shopping']")
  private WebElement continueShoppingButton;

  @Override
  public void waitUntilPageObjectIsLoaded() {
    wait.until(visibilityOf(closeCart));
  }

  /**
   * Clicks 'Continue shopping' button.
   *
   * @return MainPage instance.
   */
  public MainPage clickContinueShoppingButton() {
    driverTools.clickElement(continueShoppingButton);
    return new MainPage();
  }
}
