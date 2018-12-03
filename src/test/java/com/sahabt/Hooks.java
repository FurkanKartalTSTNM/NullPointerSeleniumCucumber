package com.sahabt;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Hooks {

  public String URL = "http://hub.testinium.io/wd/hub";
  public static WebDriver webDriver;


  @Before
  public void beforeTest() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("key", System.getProperty("key"));

    try {
      webDriver = new RemoteWebDriver(new URL(URL), capabilities);
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    webDriver.manage().window().fullscreen();
  }

  @After
  public void afterTest() {
    webDriver.quit();
    webDriver = null;
  }

  public static WebDriver getWebDriver() {
    return webDriver;
  }
}
