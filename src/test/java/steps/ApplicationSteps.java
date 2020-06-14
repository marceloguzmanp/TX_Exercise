package steps;

import static com.exercise.constants.PropertiesInput.BASE_URL;
import static com.exercise.utils.ListUtils.containsSubList;
import static com.exercise.utils.ListUtils.removeListOfListsEmptyValues;
import static com.exercise.utils.ListUtils.removeTextListOfList;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import com.exercise.pages.LayerCart;
import com.exercise.pages.MainPage;
import com.exercise.pages.ShoppingCart;
import com.exercise.selenium.webdriver.DriverFactory;
import com.exercise.selenium.webdriver.SharedDriver;
import com.exercise.utils.PropertiesManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import java.util.List;

/**
 * Application steps class.
 */
public class ApplicationSteps {

  private static PropertiesManager properties = PropertiesManager.getInstance();
  private MainPage mainPage;
  private LayerCart layerCart;
  private ShoppingCart shoppingCart;

  public ApplicationSteps(SharedDriver sharedDriver) {
    mainPage = new MainPage();
  }

  /**
   * Navigates to Home page.
   */
  @Given("I navigate to Home page")
  public void navigateToHomepage() {
    DriverFactory.getDriver().navigate().to(properties.getProperty(BASE_URL));
  }

  /**
   * Selects a tab according its name.
   *
   * @param tab the tab name.
   */
  @And("(I )select {string} tab")
  public void selectTab(final String tab) {
    mainPage.clickBestSellersLink(tab);
  }

  /**
   * Adds an item to the Cart.
   *
   * @param itemName the item name.
   */
  @And("(I )add {string} to Cart")
  public void addToCart(final String itemName) {
    layerCart = mainPage.addToCart(itemName);
  }

  /**
   * Clicks 'Continue Shopping' button.
   */
  @And("click 'Continue Shopping' button")
  public void clickContinueShoppingButton() {
    layerCart.clickContinueShoppingButton();
  }

  /**
   * Clicks Check out button.
   */
  @And("click Check out from Cart")
  public void selectCheckOutFromCart() {
    shoppingCart = mainPage.checkoutCart();
  }

  /**
   * Removes an item from Cart.
   *
   * @param itemName the item name.
   */
  @And("remove {string} from Cart")
  public void removeFromCart(final String itemName) {
    shoppingCart.removeItem(itemName);
  }

  /**
   * Verifies Total Amount is according the given value.
   *
   * @param totalAmount the total amount.
   */
  @And("verify total amount to pay is {string}")
  public void verifyTotalAmount(final String totalAmount) {
    assertEquals(totalAmount, shoppingCart.getTotalAmount());
  }

  /**
   * Verifies the item discount is displayed according given value.
   *
   * @param itemName the item name.
   * @param discount the discount.
   */
  @Then("the {string} discount is {string}")
  public void discountIs(final String itemName, final String discount) {
    assertEquals(mainPage.getItemDiscount(itemName), discount);
  }

  /**
   * Verifies that items should be displayed in the summary table.
   *
   * @param expectedValues expected list of list values.
   */
  @Then("verify following item(s) is/are displayed in the summary table")
  public void verifyItemsDisplayedInSummaryTable(final List<List<String>> expectedValues) {
    final List<List<String>> actualItemList = removeListOfListsEmptyValues(
        shoppingCart.getCartItemList());
    removeTextListOfList(actualItemList, "\nSKU");
    assertEquals(actualItemList, expectedValues);
  }

  /**
   * Verifies that items should not be displayed in the summary table.
   *
   * @param expectedValues expected list of list values.
   */
  @Then("verify following item(s) is/are not displayed in the summary table")
  public void verifyItemsNotDisplayedInSummaryTable(final List<List<String>> expectedValues) {
    final List<List<String>> actualItemList = removeListOfListsEmptyValues(
        shoppingCart.getCartItemList());
    removeTextListOfList(actualItemList, "\nSKU");
    assertFalse(containsSubList(actualItemList, expectedValues));
  }
}
