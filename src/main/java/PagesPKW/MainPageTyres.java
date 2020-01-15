package PagesPKW;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


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
    private SelenideElement tiresBlockTop = $x("//div[@class='car_tires_toppop']");
    private SelenideElement popularTireSize = $x("//a[@class='inset']");
    private SelenideElement size_1 = $x("//span[text()='195/65 R15']");
    private SelenideElement size_2 = $x("//span[text()='205/55 R16']");
    private SelenideElement size_3 = $x("//span[text()='175/65 R14']");
    private SelenideElement size_4 = $x("//span[text()='185/55 R15']");
    private SelenideElement size_5 = $x("//span[text()='185/65 R14']");
    private SelenideElement bestSellers = $x("//a[@class='inset active']");
    private ElementsCollection titleParameters = $$x("//*[@class='car_tires_toppop']/div[3]//*[@class='options']");
    private ElementsCollection titleParametersBestSellers = $$x("//*[@class='car_tires_toppop']/div[2]//*[@class='options']");


    public void blockCheckBestSellers() {
        System.out.println("Scroll to Best Sellers");
        bestSellers.scrollTo();
        ElementsCollection title = (titleParametersBestSellers);
        System.out.println("Compare the number of elements");
        titleParametersBestSellers.shouldHave(size(5));
    }


    public void blockCheckPopularTireSizes() {
        System.out.println("click on Popular tire sizes");
        popularTireSize.click();
        System.out.println("Click on size 195/65 R15");
        size_1.click();
        ElementsCollection title = (titleParameters);
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 205/55 R16");
        size_2.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 175/65 R14");
        size_3.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 185/55 R15");
        size_4.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 185/65 R14");
        size_5.click();
        titleParameters.shouldHave(size(5));
    }


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

