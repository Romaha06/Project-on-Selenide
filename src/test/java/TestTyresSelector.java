import Pages.*;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

public class TestTyresSelector {

    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();
    ListingPage listingPage = new ListingPage();
    SearchFromCar searchFromCar = new SearchFromCar();
    SearchFromMoto searchFromMoto = new SearchFromMoto();


    @Test(groups = {"Regression"})
    public void searchPKW() {
        help.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnPKW();
        mainPageTyres.formSeasonWinter();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        help.checkPageURL("https://reifen.pkwteile.de/winterreifen/205-55-r16");
        listingPage.listing.shouldBe(Condition.visible);
    }

    @Test(groups = {"Regression"})
    public void searchSUV() {
        help.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnSUV();
        mainPageTyres.formSeasonSummer();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        help.checkPageURL("https://reifen.pkwteile.de/offroadreifen/sommerreifen/205-55-r16");
        listingPage.listing.shouldBe(Condition.visible);
    }

    @Test(groups = {"Regression"})
    public void searchLLKW() {
        help.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnLLKW();
        mainPageTyres.formSeasonWinter();
        searchFromCar.selectionOfParameters();
        mainPageTyres.search();
        help.checkPageURL("https://reifen.pkwteile.de/transporterreifen/winterreifen/205-55-r16");
        listingPage.listing.shouldBe(Condition.visible);
    }

    @Test(groups = {"Regression"})
    public void searchMoto() {
        help.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.clickMenuBtnMoto();
        mainPageTyres.formSeasonWinter();
        searchFromMoto.selectionOfParametersMoto();
        mainPageTyres.search();
        help.checkPageURL("https://reifen.pkwteile.de/motorradreifen/winterreifen/120-70-r14");
        listingPage.listing.shouldBe(Condition.visible);
    }
}
