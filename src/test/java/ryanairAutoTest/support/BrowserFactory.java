package ryanairAutoTest.support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public enum Browser {
        Firefox, Chrome, IE
    }

    public static WebDriver startBrowser(String url) {

        String browserName = System.getenv("BROWSER");
        if (browserName == null) {
            browserName = "Firefox";
        }
        Browser browser = Browser.valueOf(browserName);

        String baseUrl = System.getenv("BASE_URL");
        if (baseUrl == null) {
            baseUrl = "https://www.ryanair.com/ie/en/";
        }
        url = baseUrl;

        WebDriver driver;

        switch (browser) {
            case Firefox:
                driver = createFirefoxDriver(url);
                break;
            case Chrome:
                driver = createChromeDriver(url);
                break;
            case IE:
                driver = createIEDriver(url);
                break;
            default:
                throw new RuntimeException("BrowserFactory not defined");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver createIEDriver(String url) {
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        WebDriver driver = new InternetExplorerDriver(cap);
        driver.get(url);
        driver.navigate().to("javascript:document.getElementById('overridelink').click()");

        return driver;
    }

    private static WebDriver createChromeDriver(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        return driver;
    }

    private static WebDriver createFirefoxDriver(String url) {

        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("default");
        myProfile.setAcceptUntrustedCertificates(true);
        myProfile.setAssumeUntrustedCertificateIssuer(false);
        WebDriver driver = new FirefoxDriver(myProfile);
        driver.get(url);

        return driver;
    }
}