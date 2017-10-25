package ryanairAutoTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class BookingPage {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    @FindBy(css = ".flight-header__min-price > flights-table-price:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(2)")
    private WebElement buttonFromPay;

    @FindBy(css = "div.flights-table-fares__fare:nth-child(1) > div:nth-child(4) > button:nth-child(2)")
    private WebElement selectStandardFarePrice;

    @FindBy(css = "div.trips-basket:nth-child(2) > button:nth-child(1)")
    private WebElement continueToExtrasPage;

    public BookingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(driver);
        this.wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        this.wait.withTimeout(1, TimeUnit.MINUTES);
    }

    public void fromPayButton() {
        buttonFromPay.click();
    }

    public void selectStandardFare() {
        wait.until(ExpectedConditions.elementToBeClickable(selectStandardFarePrice));
        selectStandardFarePrice.click();
    }

    public void continueToExtraPage() {
        wait.until(ExpectedConditions.elementToBeClickable(continueToExtrasPage));
        continueToExtrasPage.click();
    }
}
