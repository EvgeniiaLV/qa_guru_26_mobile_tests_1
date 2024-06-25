package config;

import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriverProvider implements WebDriverProvider {

    protected static DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    protected static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.getUser());
        caps.setCapability("browserstack.key", authConfig.getKey());

        // Set URL of the application under test
        caps.setCapability("app", deviceConfig.getApp());


        // Specify device and os_version for testing
        caps.setCapability("device", deviceConfig.getDevice());
        caps.setCapability("os_version", deviceConfig.getOSVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", deviceConfig.getProject());
        caps.setCapability("build", deviceConfig.getBuild());
        caps.setCapability("name", deviceConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(deviceConfig.getURL()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}