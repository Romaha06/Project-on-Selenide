import Pages.Help;
import Pages.ListingPage;
import Pages.MainPageTyres;
import Pages.ProductPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestAddToBasket {

    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();
    ListingPage listingPage = new ListingPage();
    ProductPage productPage = new ProductPage();

    @DataProvider(name = "data-provider")
    public Object[][] dataProviderData() {
        return new Object[][]{
                {"https://reifen.pkwteile.de/sommerreifen"},
                {"https://reifen.pkwteile.de/winterreifen"},
                {"https://reifen.pkwteile.de/ganzjahresreifen"}
        };
    }

    @Test(groups = {"Regression"})
    public void addToBasketFromBlockTop() {
        help.openUrl("https://reifen.pkwteile.de/");
        help.closePopup(help.btnCookies);
        mainPageTyres.addToBasketFromBlockTop();
    }

    @Test(groups = {"Regression"}, dataProvider = "data-provider")
    public void addToBasketFromListing(String url) {
        help.openUrl(url);
        help.closePopup(help.btnCookies);
        listingPage.addToBasket();
    }

    @Test(groups = {"Regression"},dataProvider = "data-provider")
    public void addToBasketFromProdPage(String url){
        help.openUrl(url);
        help.closePopup(help.btnCookies);
        productPage.addToBasketFromProdPage();
    }
}
