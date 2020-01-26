package TestsForTires;

import PagesPKW.Help;
import PagesPKW.MainPageTyres;
import PagesPKW.SetUp;
import org.testng.annotations.Test;

public class TestBlockTiresTop extends BaseTest{

    SetUp setUp = new SetUp();
    Help help = new Help();
    MainPageTyres mainPageTyres = new MainPageTyres();


    @Test(groups = {"Regression"})
    public void blockCheckBestSellers(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.blockCheckBestSellers();
    }

    @Test(groups = {"Regression"})
    public void blockCheckPopularTireSizes(){
        setUp.openUrl("https://tyres.buycarparts.co.uk/");
        help.closePopup(help.btnCookies);
        mainPageTyres.blockCheckPopularTireSizes();
    }
}


