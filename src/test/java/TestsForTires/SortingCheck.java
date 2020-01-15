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
                {"https://reifen.pkwteile.de/winterreifen/205-55-r16"},
                {"https://reifen.pkwteile.de/winterreifen/205-55-r16?page=2"},
                {"https://reifen.pkwteile.de/winterreifen/205-55-r16?page=3"}
        };
    }

    @Test(groups = {"Regression"},dataProvider = "data-provider")
    public void checkSortingByPrice(String url){
        setUp.openUrl(url);
        listingPage.checkSortingByPrice(true);
    }
}
