package TestsForTires;

import PagesPKW.*;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class TestTiresSelector extends BaseTest{

    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();
    ListingPage listingPage = new ListingPage();
    SearchFromCar searchFromCar = new SearchFromCar();
    SearchFromMoto searchFromMoto = new SearchFromMoto();
    SetUp setUp = new SetUp();



    @Test(groups = {"Regression"})
    public void checkingSelectorErrorTooltip(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingSelectorErrorTooltip();
    }


    @Test(groups = {"Regression"})
    public void checkingSelectorFromCar() {
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingSelectorFromCar();
    }


    @Test(groups = {"Regression"})
    public void searchPKW() {
        setUp.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnPKW();
        mainPageTyres.formSeasonWinter();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        listingPage.listing.shouldBe(Condition.visible);
    }


    @Test(groups = {"Regression"})
    public void searchSUV() {
        setUp.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnSUV();
        mainPageTyres.formSeasonSummer();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        listingPage.listing.shouldBe(Condition.visible);
    }


    @Test(groups = {"Regression"})
    public void searchLLKW() {
        setUp.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnLLKW();
        mainPageTyres.formSeasonWinter();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        listingPage.listing.shouldBe(Condition.visible);
    }


    @Test(groups = {"Regression"})
    public void searchMoto() {
        setUp.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnMoto();
        mainPageTyres.formSeasonWinter();
        searchFromMoto.selectionOfParametersMoto();
        mainPageTyres.search();
        listingPage.listing.shouldBe(Condition.visible);
    }
}
