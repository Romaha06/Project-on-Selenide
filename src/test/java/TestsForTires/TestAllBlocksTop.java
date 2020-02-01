package TestsForTires;

import PagesPKW.Help;
import PagesPKW.MainPageTyres;
import PagesPKW.SetUp;
import org.testng.annotations.Test;

public class TestAllBlocksTop extends BaseTest{

    SetUp setUp = new SetUp();
    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();


    @Test(groups = {"Regression"})
    public void checkingSeoBlockPopularTyreSize(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingSeoBlockPopularTyreSize();
    }


    @Test(groups = {"Regression"})
    public void checkingBlockTopCarMakers(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingBlockTopCarMakers();
    }


    @Test(groups = {"Regression"})
    public void checkingBlockTopManufacturers(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingBlockTopManufacturers();
    }


    @Test(groups = {"Regression"})
    public void blockCheckBestSellers(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingBlockBestSellers();
    }

    @Test(groups = {"Regression"})
    public void blockCheckPopularTireSizes(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.checkingBlockPopularTireSizes();
    }
}


