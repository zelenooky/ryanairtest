package ryanairAutoTest.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;

public class MainPage {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    @FindBy(css = "div.flight-search-type-option.one-way")
    private WebElement oneWayButton;

    @FindBy(css = "#label-airport-selector-from")
    private WebElement fromInput;

    @FindBy(css = "div.core-list-item:nth-child(23)")
    private WebElement selectIreland;

    @FindBy(css = "div.pane:nth-child(2)>div:nth-child(2)>div:nth-child(4)>span:nth-child(1)")
    private WebElement selectDublin;

    @FindBy(css = "div.col-destination-airport")
    private WebElement toInput;

    @FindBy(css = "div.core-list-item:nth-child(19)")
    private WebElement selectGermany;

    @FindBy(css = "div.pane:nth-child(2) > div:nth-child(2) > div:nth-child(3) > span:nth-child(1)")
    private WebElement selectBerlin;

    @FindBy(css = "li.calendar-view:nth-child(2) > ul:nth-child(3) > li:nth-child(32) > span:nth-child(1)")
    private WebElement selectDate;

    @FindBy(css = ".dropdown-handle")
    private WebElement selectDropDownHandle;

    @FindBy(css = "button.core-btn.inc.core-btn-wrap")
    private WebElement select2Adults;

    @FindBy(css = "div[label='Children'] button.core-btn.inc")
    private WebElement selectChildren;

    @FindBy(css = "button.core-btn-primary:nth-child(2)")
    private WebElement submitButtonLetsGo;


    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(driver);
        this.wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        this.wait.withTimeout(1, TimeUnit.MINUTES);
    }

    public void selectOneWayRadioButton() {
        oneWayButton.click();
    }

    public void inputFromToDestination() throws InterruptedException {
        fromInput.click();
        wait.until(ExpectedConditions.visibilityOf(selectIreland));
        selectIreland.click();
        selectDublin.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectGermany));
        selectGermany.click();
        selectBerlin.click();
    }

    public void inputFlyOutDate() throws InterruptedException {
        selectDate.click();
    }

    public void selectDropDownArrow() {
        selectDropDownHandle.click();
    }

    public void selectAdultsAndChildren() {
        select2Adults.click();
        selectChildren.click();
    }

    public void submitButtonLetsGo(){
        submitButtonLetsGo.click();
    }
}


