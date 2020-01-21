package TestsForTires;

import PagesPKW.Help;
import PagesPKW.ListingPage;
import PagesPKW.SetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SortingCheck {

    Help help = new Help();
    ListingPage listingPage = new ListingPage();
    SetUp setUp = new SetUp();


    @DataProvider(name = "data-provider")
    public Object[][] dataProviderData() {
        return new Object[][]{
                {"https://reifen.pkwteile.de/sommerreifen"},
                {"https://reifen.pkwteile.de/winterreifen"},
                {"https://reifen.pkwteile.de/ganzjahresreifen"}
        };
    }

    @Test(groups = {"Regression"},dataProvider = "data-provider")
    public void checkSortingByPrice(String url){
        setUp.openUrl(url);
        help.closePopup(help.btnCookies);
        listingPage.checkSortingByPrice(true);
    }
}
