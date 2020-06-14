package com.exercise.selenium.webdriver;

import com.exercise.constants.Browser;
import com.exercise.selenium.browser.FireFox;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.openqa.selenium.WebDriver;
import com.exercise.selenium.browser.Chrome;
import com.exercise.selenium.browser.IDriver;

/**
 * Returns the driver instance.
 */
public class BrowserFactory {

  private static final Map<Browser, Supplier<IDriver>> BROWSERS = new EnumMap<>(Browser.class);

  static {
    BROWSERS.put(Browser.CHROME, Chrome::new);
    BROWSERS.put(Browser.FIREFOX, FireFox::new);
  }

  /**
   * Class constructor.
   */
  private BrowserFactory() {
  }

  /**
   * Gets the driver instance according the name given by the parameter.
   *
   * @param browser browser type.
   * @return web driver instance.
   */
  public static WebDriver getDriver(final Browser browser) {
    return BROWSERS.getOrDefault(browser, Chrome::new).get().initDriver();
  }
}
