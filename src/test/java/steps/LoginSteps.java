package steps;

import static com.exercise.constants.PropertiesInput.BASE_URL;

import com.exercise.selenium.webdriver.DriverFactory;
import com.exercise.selenium.webdriver.SharedDriver;
import com.exercise.utils.PropertiesManager;
import cucumber.api.java.en.Given;

/**
 * Login step class.
 */
public class LoginSteps {

  private static PropertiesManager properties = PropertiesManager.getInstance();

  public LoginSteps(SharedDriver sharedDriver) {
  }

  /**
   * Navigates to Home page.
   */
  @Given("I navigate to Home page")
  public void navigateToHomepage() {
    DriverFactory.getDriver().navigate().to(properties.getProperty(BASE_URL));
  }

  @Given("I select {string} tab")
  public void selectTab(String string) {
  }
}
