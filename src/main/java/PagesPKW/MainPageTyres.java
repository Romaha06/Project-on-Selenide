package PagesPKW;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPageTyres {

    ListingPage listingPage = new ListingPage();
    BasketPage basketPage = new BasketPage();
    AllCarMakersPage allCarMakersPage = new AllCarMakersPage();
    AllManufacturersPage allBrandsPage = new AllManufacturersPage();
    AllTyresSizesPage allTyresSizesPage = new AllTyresSizesPage();


    private SelenideElement btnPKW = $x("//img[@class='tabs__icon__pkw']");
    private SelenideElement btnSUV = $x("//img[@class='tabs__icon__suv']");
    private SelenideElement btnLLKW = $x("//img[@class='tabs__icon__llkw']");
    private SelenideElement btnMotoTyres = $x("//img[@class='tabs__icon__moto']");

    private SelenideElement selectSeasonsWinter = $x("//div[@class='season-tyre__label--winter']");
    private SelenideElement selectSeasonsSummer = $x("//div[@class='season-tyre__label--summer']");
    private SelenideElement selectSeasonsAll = $x("//div[@class='season-tyre__label--all-weather']");
    private SelenideElement btnTyresSearch = $x("//a[@id='tyres_search']");

    private SelenideElement btnAddBasketTop = $x("//div[@class='basket_btn button active_red_button']");

    private SelenideElement size_1 = $x("//span[text()='205/55 R16']");
    private SelenideElement size_2 = $x("//span[text()='195/65 R15']");
    private SelenideElement size_3 = $x("//span[text()='175/65 R14']");
    private SelenideElement size_4 = $x("//span[text()='185/55 R15']");
    private SelenideElement size_5 = $x("//span[text()='185/65 R14']");
    private SelenideElement tiresBlockTop = $x("//div[@class='car_tires_toppop']");
    private SelenideElement popularTireSize = $x("//a[@class='inset']");
    private SelenideElement bestSellers = $x("//a[@data-attr-type='top_products']");

    private ElementsCollection titleParameters = $$x("//div[@class='car_tires_toppop']/div[3]//div[@class='options']");
    private ElementsCollection titleParametersBestSellers = $$x("//div[@class='car_tires_toppop']/div[2]//div[@class='options']");

    private SelenideElement carMark = $x("//select[@name='maker_id']");
    private SelenideElement carModel = $x("//select[@name='model_id']");
    private SelenideElement carModification = $x("//select[@name='car_id']");
    private SelenideElement btnCarSearch = $x("//div[@class='mainblock-search__car ']//div[5]//span[1]");
    private SelenideElement selectorErrorTooltip = $x("//div[@class='popup-error-select validation-tooltip']");

    private SelenideElement blockTopManufacturers = $x("//div[@class='featured_manufacturers']");
    private SelenideElement btnAllTyreManufacturers = $x("//div[@class='type_list_all_brands']");
    private ElementsCollection defaultManufacturers = $$x("//div[@class='featured_manufacturers']//div[2]/a");

    private SelenideElement blockTopCarMakers = $x("//div[@class='listing_microdata bottom_box_mod listing_microdata--brand']");
    private SelenideElement btnAllCarMakers = $x("//div[@id='content']/div[7]/a[@class='button']");
    private ElementsCollection defaultCarMakers = $$x("//ul[@class='makers_block_bxslider']//li/a");

    private SelenideElement seoBlockPopularTyreSize = $x("//div[@class='other_pr']");
    private SelenideElement btnAllSize = $x("//div[@id='content']/div[8]/a[@class='button']");
    private ElementsCollection topDiameter = $$x("//div[@class='zoll']//ul//li");
    private ElementsCollection topTyresSize = $$x("//div[@class='other_pr']//div[2]//ul//li");


    public void checkingSeoBlockPopularTyreSize(){
        System.out.println("Checking the availability of the Popular Tyre Size block");
        seoBlockPopularTyreSize.shouldBe(visible);
        System.out.println("Checking the quantity of default Diameter in the inside of the block");
        topDiameter.shouldHave(size(8));
        System.out.println("Checking the quantity of default Tyres Size in the inside of the block");
        topTyresSize.shouldHave(size(10));
        System.out.println("Go to the page of All Size");
        btnAllSize.click();
        allTyresSizesPage.AllSizesBlock.shouldBe(visible);
    }


    public void checkingBlockTopCarMakers(){
        System.out.println("Checking the availability of the Top Car Brand block");
        blockTopCarMakers.shouldBe(visible);
        System.out.println("Checking the quantity of default Car Brand in the inside of the block");
        defaultCarMakers.shouldHave(size(8));
        System.out.println("Go to the page of All Car Brand");
        btnAllCarMakers.click();
        allCarMakersPage.allCarMakersBlock.shouldBe(visible);
    }


    public void checkingBlockTopManufacturers(){
        System.out.println("Checking the availability of the Top Manufacturers block");
        blockTopManufacturers.shouldBe(visible);
        System.out.println("Checking the quantity of default Manufacturers in the inside of the block");
        defaultManufacturers.shouldHave(size(12));
        System.out.println("Go to the page of all Manufacturers");
        btnAllTyreManufacturers.click();
        allBrandsPage.AllManufacturersBlock.shouldBe(visible);
    }


    public void checkingSelectorFromCar() {
        System.out.println("Choosing a make of car");
        carMark.click();
        $x("//option[@value='121']").click();//VW

        System.out.println("Choosing a model of car");
        carModel.click();
        $x("//option[@value='10200']").click();//CC (358) (11/2011 - ...)

        System.out.println("Choosing a modification of car");
        carModification.click();
        $x("//option[@value='26739']").click();//3.6 FSI 4motion (220 KW / 300 HP) (11/2011 - ...)

        System.out.println("Click the search button");
        btnCarSearch.click();

        System.out.println("Checking the correct transition to the page");
        $x("//h1[@class='title']//span[1]").shouldBe(visible);
    }


    public void checkingSelectorErrorTooltip(){
        System.out.println("Without filling in the field, click on the Search button");
        btnCarSearch.click();
        System.out.println("Check for error message");
        selectorErrorTooltip.shouldBe(visible);

        System.out.println("Fill in the Mark field and click on the Search button");
        carMark.click();
        $x("//option[@value='121']").click();//VW
        btnCarSearch.click();
        System.out.println("Check for error message");
        selectorErrorTooltip.shouldBe(visible);

        System.out.println("Fill in the Brand, Model field and click on the Search button");
        carMark.click();
        $x("//option[@value='121']").click();//VW
        carModel.click();
        $x("//option[@value='10200']").click();//CC (358) (11/2011 - ...)
        btnCarSearch.click();
        System.out.println("Check for error message");
        selectorErrorTooltip.shouldBe(visible);

    }


    public void checkingBlockBestSellers() {
        System.out.println("Check block TOP");
        tiresBlockTop.shouldBe(visible);
        System.out.println("Click on Best Sellers");
        bestSellers.click();
        System.out.println("Compare the number of elements");
        titleParametersBestSellers.shouldHave(size(5));
    }


    public void checkingBlockPopularTireSizes() {
        System.out.println("Click on Popular tire sizes");
        popularTireSize.click();
        System.out.println("Click on size 195/65 R15");
        size_2.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 205/55 R16");
        size_1.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 175/65 R14");
        size_3.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 185/55 R15");
        size_4.click();
        titleParameters.shouldHave(size(5));

        System.out.println("Click on size 185/65 R14");
        size_5.click();
        titleParameters.shouldHave(size(5));
    }


    public void addToBasketFromBlockTop() {
        System.out.println("Add item to basket from block top");
        btnAddBasketTop.click();
        listingPage.basket.click();
        basketPage.priceInBasket.shouldBe(visible);

    }


    public void clickMenuBtnPKW() {
        System.out.println("Choose type 'PKW'");
        btnPKW.click();
    }

    public void clickMenuBtnSUV() {
        System.out.println("Choose type 'button Off-Road_SUV'");
        btnSUV.click();
    }

    public void clickMenuBtnLLKW() {
        System.out.println("Choose type 'button LLKW'");
        btnLLKW.click();
    }

    public void clickMenuBtnMoto() {
        System.out.println("Choose type 'button moto'");
        btnMotoTyres.click();
    }

    public void formSeasonWinter() {
        System.out.println("Choose from Seasons: Winter");
        selectSeasonsWinter.click();
    }

    public void formSeasonSummer() {
        System.out.println("Choose from Seasons: Summer");
        selectSeasonsSummer.click();
    }

    public void formSeasonAll() {
        System.out.println("Choose from Seasons: Seasons-All");
        selectSeasonsAll.click();
    }

    public void search() {
        System.out.println("Click button Search.");
        btnTyresSearch.click();
    }
}

