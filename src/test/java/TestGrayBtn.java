import Pages.Help;
import Pages.ListingPage;
import Pages.SetUp;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGrayBtn {

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

    @Test(groups = {"Regression", "SKIP"},dataProvider = "data-provider")
    public void checkGrayBtnOnListing(String url) {
        setUp.openUrl(url);
        help.closePopup(help.btnCookies);
        listingPage.checkGrayBtnOnListing();
    }
}
