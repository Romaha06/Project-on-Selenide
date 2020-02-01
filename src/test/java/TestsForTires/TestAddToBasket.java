package TestsForTires;

import PagesPKW.*;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class TestAddToBasket extends BaseTest{

    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();
    ListingPage listingPage = new ListingPage();
    ProductPage productPage = new ProductPage();
    SetUp setUp = new SetUp();
    MainPagePKW mainPagePKW = new MainPagePKW();
    BasketPage basketPage = new BasketPage();



    @Test(groups = {"Regression"})
    public void addToBasketFromBlockTop() {
        setUp.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.addToBasketFromBlockTop();
        basketPage.deleteFromBasket();
        mainPagePKW.mainBlockSearchCar.shouldBe(Condition.visible);

    }

    @Test(groups = {"Regression"})
    public void addToBasketFromListing() {
        setUp.openUrl("https://reifen.pkwteile.de/sommerreifen");
        help.closePopup(help.btnCookies);
        listingPage.addToBasket();
        basketPage.deleteFromBasket();
        mainPagePKW.mainBlockSearchCar.shouldBe(Condition.visible);
    }

    @Test(groups = {"Regression"})
    public void addToBasketFromProdPage(){
        setUp.openUrl("https://reifen.pkwteile.at/mercedes-benz");
        help.closePopup(help.btnCookies);
        productPage.addToBasketFromProdPage();
        basketPage.deleteFromBasket();
        mainPagePKW.mainBlockSearchCar.shouldBe(Condition.visible);
    }
}
