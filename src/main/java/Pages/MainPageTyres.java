package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.fail;


public class MainPageTyres {

    ListingPage listingPage = new ListingPage();
    BasketPage basketPage = new BasketPage();


    private SelenideElement btnPKW = $x("//img[@alt='PKW']");
    private SelenideElement btnSUV = $x("//img[@alt='Offroad/SUV']");
    private SelenideElement btnLLKW = $x("//img[@alt='Transporter']");
    private SelenideElement btnMotoTyres = $x("//img[@alt='Motorrad']");
    private SelenideElement selectSeasonsWinter = $x("//div[@class='season-tyre__label--winter']");
    private SelenideElement selectSeasonsSummer = $x("//div[@class='season-tyre__label--summer']");
    private SelenideElement selectSeasonsAll = $x("//div[@class='season-tyre__label--all-weather']");
    private SelenideElement btnTyresSearch = $x("//a[@id='tyres_search']");
    private SelenideElement btnAddBasketTop = $x("//div[@class='basket_btn button active_red_button']");


    public void addToBasketFromBlockTop() {
        System.out.println("Add item to basket from block top");
        $(btnAddBasketTop).click();
        $(listingPage.basket).click();
        $(basketPage.priceInBasket).shouldBe(visible);
    }


    public void clickMenuBtnPKW() {
        System.out.println("Choose type 'PKW'");
        btnPKW.click();
    }

    public void clickMenuBtnSUV() {
        System.out.println("Choose type 'button Off-Road_SUV'");
        btnSUV.click();
    }

    public void clickMenuBtnLLKW() {
        System.out.println("Choose type 'button LLKW'");
        btnLLKW.click();
    }

    public void clickMenuBtnMoto() {
        System.out.println("Choose type 'button moto'");
        btnMotoTyres.click();
    }

    public void formSeasonWinter() {
        System.out.println("Choose from Seasons: Winter");
        selectSeasonsWinter.click();
    }

    public void formSeasonSummer() {
        System.out.println("Choose from Seasons: Summer");
        selectSeasonsSummer.click();
    }

    public void formSeasonAll() {
        System.out.println("Choose from Seasons: Seasons-All");
        selectSeasonsAll.click();
    }

    public void search() {
        System.out.println("Click button Search.");
        btnTyresSearch.click();
    }
}

