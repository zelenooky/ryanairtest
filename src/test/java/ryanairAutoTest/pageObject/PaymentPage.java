package ryanairAutoTest.pageObject;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

import static jdk.nashorn.internal.objects.Global.print;

public class PaymentPage {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    @FindBy(css = "div.login-register button[ui-sref='login']")
    private WebElement loginMyRyanAir;

    @FindBy(css = "div.form-field input[placeholder='Email address']")
    private WebElement loginEmailAddress;

    @FindBy(css = "div.form-field input[placeholder='Password']")
    private WebElement loginPassword;

    @FindBy(css = "div.modal-form-group:nth-child(5) > button-spinner:nth-child(1) > button:nth-child(1)")
    private WebElement loginButton;

    @FindBy(css = ".form-field.payment-passenger-title select")
    private List<WebElement> passengerTitle;

    @FindBy(css = ".form-field.payment-passenger-first-name input")
    private List<WebElement> passengerFirstName;

    @FindBy(css = ".form-field.payment-passenger-last-name input")
    private List<WebElement> passengerLastName;

    @FindBy(css = "div.phone-number-country")
    private WebElement phoneNumberCountry;

    @FindBy(css = "div.core-select option[label='Germany']")
    private WebElement chooseCountry;

    @FindBy(css = ".phone-number [name='phoneNumber']")
    private WebElement phoneNumber;

    @FindBy(css = "[name='cardNumber']")
    private WebElement cardNumber;

    @FindBy(css = ".core-select.card-type-select select")
    private WebElement cardType;

    @FindBy(css = "[value='MC']")
    private WebElement chooseMasterCard;

    @FindBy(css = "[name='expiryMonth']")
    private WebElement cardExpiryMonth;

    @FindBy(css = "div.core-select option[label='10']")
    private WebElement chooseMonthOfExpiration;

    @FindBy(css = "div.core-select option[label='2018']")
    private WebElement chooseYearOfExpiration;

    @FindBy(css = "[name='expiryYear']")
    private WebElement cardExpiryYear;

    @FindBy(css = ".core-input.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required.ng-valid-pattern.ng-valid-minlength.ng-valid-maxlength")
    private WebElement securityCode;

    @FindBy(css = "div.full-width-form.payment-input input[name='cardHolderName']")
    private WebElement cardHoldersName;

    @FindBy(css = "[name='billingAddressAddressLine1']")
    private WebElement billingAddress1;

    @FindBy(css = "[name='billingAddressAddressLine2']")
    private WebElement billingAddress2;

    @FindBy(css = "[name='billingAddressCity']")
    private WebElement billingAddressCity;

    @FindBy(css = "[name='billingAddressPostcode']")
    private WebElement billingAddressPostcode;

    @FindBy(css = "div.form-field.country option[label='Germany']")
    private WebElement billingAddressCountry;

    @FindBy(css = "[name='acceptPolicy']")
    private WebElement acceptTermsOfService;

    @FindBy(css = ".core-btn-primary.core-btn-medium")
    private WebElement payNow;

    @FindBy(css = ".error .info-text")
    private WebElement paymentUnauthorized;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<WebDriver>(driver);
        this.wait.pollingEvery(250, TimeUnit.MILLISECONDS);
        this.wait.withTimeout(1, TimeUnit.MINUTES);
    }

    public void loginRyanAir() {
        loginMyRyanAir.click();
        loginEmailAddress.sendKeys("vanjafranjic@outlook.com");
        loginPassword.sendKeys("Aligator05");
        loginButton.click();
    }

    public void passengerDetails() throws InterruptedException {
        Thread.sleep(1000);
        Select titleDropDown = new Select(passengerTitle.get(0));
        titleDropDown.selectByValue("string:MR");
        wait.until(ExpectedConditions.elementToBeClickable(passengerFirstName.get(0)));
        passengerFirstName.get(0).sendKeys("Vanja");
        passengerLastName.get(0).sendKeys("Franjic");
        Select title1DropDown = new Select(passengerTitle.get(1));
        title1DropDown.selectByValue("string:MRS");
        passengerFirstName.get(1).sendKeys("Tijana");
        passengerLastName.get(1).sendKeys("Franjic");
        passengerFirstName.get(2).sendKeys("Filip");
        passengerLastName.get(2).sendKeys("Franjic");
    }

    public void paymentAndContactDetails() {
        phoneNumberCountry.click();
        chooseCountry.click();
        phoneNumber.sendKeys("40 3174052");
        cardNumber.sendKeys("5555555555555557");
        cardType.click();
        chooseMasterCard.click();
        cardExpiryMonth.click();
        chooseMonthOfExpiration.click();
        cardExpiryYear.click();
        chooseYearOfExpiration.click();
        securityCode.sendKeys("265");
        cardHoldersName.sendKeys("Vanja");
        billingAddress1.sendKeys("Reeperbahn 147");
        billingAddress2.sendKeys("Reeperbahn 149");
        billingAddressCity.sendKeys("Hamburg");
        billingAddressPostcode.sendKeys("20359");
        billingAddressCountry.click();
        acceptTermsOfService.click();
        payNow.click();
    }

    public boolean errorMessage() {
        if (paymentUnauthorized.getText().toString().contains("As your payment was not authorised we could not complete your reservation." +
                "Please ensure that the information was correct or use a new payment to try again")) return true;
        else {
            return false;
        }
    }
}
