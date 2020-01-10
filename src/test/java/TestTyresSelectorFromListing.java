import Pages.Help;
import Pages.ListingPage;
import Pages.SetUp;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;

public class TestTyresSelectorFromListing {

    Help help = new Help();
    ListingPage listingPage = new ListingPage();
    SetUp setUp = new SetUp();


    @Test(groups = {"Regression"})
    public void checkValidationError(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/205-55-r16");
        help.closePopup(help.btnCookies);
        listingPage.checkPopupValidationError();
    }

    @Test(groups = {"Regression"})
    public void checkingTireSelectorInListing(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/205-55-r16");
        help.closePopup(help.btnCookies);
        listingPage.checkingTireSelectorInListing();
        help.checkPageURL("https://tyres.buycarparts.co.uk/tyres-search?Season=summer&Width=255&CrossSections=60&Size=17");
        listingPage.listing.shouldBe(visible);
    }
}
