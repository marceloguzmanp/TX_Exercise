package com.exercise.constants;

/**
 * Contains all properties.
 */
public enum PropertiesInput {
  BROWSER("browser"),
  IMPLICIT_WAIT_TIME("implicitWaitTime"),
  EXPLICIT_WAIT_TIME("explicitWaitTime"),
  WAIT_SLEEP_TIME("waitSleepTime"),
  BASE_URL("baseUrl");

  private String property;

  /**
   * Sets the properties config.
   *
   * @param property property name.
   */
  PropertiesInput(final String property) {
    this.property = property;
  }

  /**
   * Gets property input.
   *
   * @return property.
   */
  public String getProperty() {
    return property;
  }
}
