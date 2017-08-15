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

    @FindBy(css = ".form-field.payment-passenger-last-name input")
    private List<WebElement> childFirstName;

    @FindBy(css = ".form-field.payment-passenger-last-name input")
    private List<WebElement> childLastName;

    @FindBy(css = "[name='phoneNumberCountry']")
    private WebElement phoneNumberCountry;

    @FindBy(css = "[label='+country+']")
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

    @FindBy(css = "[value='number:'+month+'']")
    private WebElement chooseMonthOfExpiration;

    @FindBy(css = "[value='number:'+year+'']")
    private WebElement chooseYearOfExpiration;

    @FindBy(css = "[name='expiryYear']")
    private WebElement cardExpiryYear;

    @FindBy(css = ".core-input.ng-pristine.ng-untouched.ng-empty.ng-invalid.ng-invalid-required.ng-valid-pattern.ng-valid-minlength.ng-valid-maxlength")
    private WebElement securityCode;

    @FindBy(css = "[name='cardHolderName']")
    private WebElement cardHoldersName;

    @FindBy(css = "[name='billingAddressAddressLine1']")
    private WebElement billingAddress1;

    @FindBy(css = "[name='billingAddressAddressLine2']")
    private WebElement billingAddress2;

    @FindBy(css = "[name='billingAddressCity']")
    private WebElement billingAddressCity;

    @FindBy(css = "[name='billingAddressPostcode']")
    private WebElement billingAddressPostcode;

    @FindBy(css = "[name='billingAddressCountry']")
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

    public void passengerDetails() {
        Select titleDropDown = new Select(passengerTitle.get(0));
        titleDropDown.selectByValue("string:MR");
        passengerFirstName.get(0).sendKeys("Vanja");
        passengerLastName.get(0).sendKeys("Franjic");
        passengerFirstName.get(1).sendKeys("Tijana");
        passengerLastName.get(1).sendKeys("Franjic");
        //childFirstName.get(3).sendKeys("John");
        //childLastName.get(3).sendKeys("Doe");
    }

    public void paymentAndContactDetails() {
        phoneNumberCountry.click();
        chooseCountry.click();
        phoneNumber.click();
    }

    public boolean errorMessage() {
        return paymentUnauthorized.getText().toString().contains
                ("As your payment was not authorised we could not complete your reservation. " +
                        "Please ensure that the information was correct or use a new payment to try again");
    }
}
