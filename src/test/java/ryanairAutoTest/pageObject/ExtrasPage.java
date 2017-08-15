package ryanairAutoTest.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class ExtrasPage {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    @FindBy(css = "button.core-btn-primary:nth-child(3)")
    private WebElement buttonGotItSeats;

    @FindBy(css = ".seat-row-seat.standard:not(.reserved)")
    private List<WebElement> selectSeats;

    @FindBy(css = "button.core-btn-primary.next")
    private WebElement nextButton;

    @FindBy(css = "[translate='trips.seats.confirm']")
    private WebElement confirmButton;

    @FindBy(css = "button.core-btn-bb-outline:nth-child(2)")
    private WebElement noThanksButton;

    @FindBy(css = "div.cart.cart-empty button[type='button']")
    private WebElement checkOutButton;


    public ExtrasPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(driver);
        this.wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        this.wait.withTimeout(1, TimeUnit.MINUTES);
    }

    public void gotItSeats() {
        buttonGotItSeats.click();
    }

    public void seatSelection() throws InterruptedException {
        Thread.sleep(500);
        selectSeats.get(0).click();
        selectSeats.get(1).click();
        selectSeats.get(2).click();
        nextButton.click();
        confirmButton.click();
        noThanksButton.click();
        Thread.sleep(500);
        checkOutButton.click();
    }
}
