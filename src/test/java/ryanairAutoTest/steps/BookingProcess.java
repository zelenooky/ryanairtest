package ryanairAutoTest.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ryanairAutoTest.pageObject.BookingPage;
import ryanairAutoTest.pageObject.ExtrasPage;
import ryanairAutoTest.pageObject.MainPage;
import ryanairAutoTest.pageObject.PaymentPage;
import ryanairAutoTest.support.BrowserFactory;

public class BookingProcess {

    private WebDriver driver;
    private MainPage mainPage;
    private BookingPage bookingPage;
    private ExtrasPage extrasPage;
    private PaymentPage paymentPage;


    @Given("^I make a booking from “DUB” to “SXF” on \"([^\"]*)\" for \"([^\"]*)\" adults and \"([^\"]*)\" child$")
    public void i_make_a_booking_from_DUB_to_SXF_on_for_adults_and_child(String arg1, String arg2, String arg3) throws Throwable {
        driver = BrowserFactory.startBrowser("https://www.ryanair.com/ie/en/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.selectOneWayRadioButton();
        mainPage.inputFromToDestination();
        mainPage.inputFlyOutDate();
        mainPage.selectDropDownArrow();
        mainPage.selectAdultsAndChildren();
        mainPage.submitButtonLetsGo();
        bookingPage = PageFactory.initElements(driver, BookingPage.class);
        bookingPage.continueSearch();
        bookingPage.fromPayButton();
        bookingPage.selectStandardFare();
        bookingPage.continueToExtraPage();
        extrasPage = PageFactory.initElements(driver, ExtrasPage.class);
        extrasPage.gotItSeats();
        extrasPage.seatSelection();
        paymentPage = PageFactory.initElements(driver, PaymentPage.class);
        paymentPage.loginRyanAir();
        paymentPage.passengerDetails();
        paymentPage.paymentAndContactDetails();
        paymentPage.errorMessage();
    }

    @When("^I pay for booking with card details “(\\d+)”, “(\\d+)/(\\d+)” and “(\\d+)”$")
    public void iPayForBookingWithCardDetailsAnd(int arg0, int arg1, int arg2, int arg3) throws Throwable {

    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() throws Throwable {

    }
}
