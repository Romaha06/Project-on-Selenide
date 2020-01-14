package PagesPKW;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertFalse;


public class ListingPage {

    BasketPage basketPage = new BasketPage();
    Help help = new Help();

    private SelenideElement nextPage = $x("//a[@rel='next']");
    private SelenideElement outOfStock = $x("//div[@class='vers_box grey']");
    private SelenideElement btnAddBasket = $x("//div[@class='basket_btn button active_red_button ']");
    public SelenideElement basket = $x("//a[@data-gac='Go_to_basket']");
    public SelenideElement prodPageLink = $x("//a[@class='prod_link']");
    private ElementsCollection labelPrice = $$x("//div[@class='price']");
    public SelenideElement listing = $x("//div[@class='listing_items js-listing-wrap']");
    public SelenideElement filterBrand = $x("//form[@id='list-filter-form']");
    private SelenideElement selectorTyresFromListing = $("#tyres_search_form");
    private SelenideElement listingSelectSeason = $x("//select[@name='Season']");
    private SelenideElement listingSelectWidth = $x("//select[@name='Width']");
    private SelenideElement listingSelectHeight = $x("//select[@name='CrossSections']");
    private SelenideElement listingSelectDiameter = $x("//select[@name='Size']");
    private SelenideElement popupValidationError = $x("//div[@class='pp_not_found']");
    private SelenideElement closePopupValidationError = $x("//*[@id='popup_car_tires_not_found']/div/a");
    private SelenideElement btnSearchFromListing = $x("//a[@id='tyres_search']");


    public void checkingTireSelectorInListing() {
        System.out.println("Choose the parameters of the Season, Width, Height and Diameter");
        listingSelectSeason.click();
        $x("//option[@value='summer']").click();
        listingSelectWidth.click();
        $x("//option[@value='255']").click();
        listingSelectHeight.click();
        $x("//option[@value='60']").click();
        listingSelectDiameter.click();
        $x("//option[@value='17']").click();
        btnSearchFromListing.click();
    }

    public void checkPopupValidationError() {
        System.out.println("Choose a season");
        selectorTyresFromListing.shouldBe(Condition.visible);
        listingSelectSeason.click();
        $x("//option[@value='allseason']").click();
        btnSearchFromListing.click();
        popupValidationError.shouldBe(visible);
        closePopupValidationError.click();
        System.out.println("Choose a season and Widht");
        listingSelectSeason.click();
        $x("//option[@value='allseason']").click();
        listingSelectWidth.click();
        $x("//option[@value='205']").click();
        btnSearchFromListing.click();
        popupValidationError.shouldBe(visible);
        closePopupValidationError.click();
        System.out.println("Choose a season and Widht and Height");
        listingSelectSeason.click();
        $x("//option[@value='allseason']").click();
        listingSelectWidth.click();
        $x("//option[@value='205']").click();
        listingSelectHeight.click();
        $x("//option[@value='55']").click();
        btnSearchFromListing.click();
        popupValidationError.shouldBe(visible);
    }

    public void checkGrayBtnOnListing() {
        while (help.checkElementIsDisplayed(nextPage)) {
            assertFalse(help.checkElementIsDisplayed(outOfStock), "Items are not in stock, on the lists!");
            $(nextPage).click();
        }
    }

    public void addToBasket() {
        System.out.println("Add item to basket from listing");
        btnAddBasket.click();
        basket.click();
        basketPage.priceInBasket.shouldBe(visible);
    }

    public void checkSortingByPrice(boolean naturalOrder) {
        System.out.println("Price Sort Check");
        ElementsCollection pricesWebElements = (labelPrice);
        //получаем текст цены, парсим цифры, превращаем в Double и записываем в список pricesFromSite
        List<Double> pricesFromSite = new ArrayList<>();
        for (WebElement element : pricesWebElements) {
            Double price = Double.parseDouble(
                    element.getText().replaceAll("(\\d+)[,]{1}(\\d*).*", "$1.$2"));
            pricesFromSite.add(price);
        }

        //делаем копию списка pricesFromSite и сортируем список sortedPrices
        List<Double> sortedPrices = new ArrayList<>(pricesFromSite);
        if (naturalOrder == true) {
            Collections.sort(sortedPrices);  //по возростанию
        } else {
            Collections.sort(sortedPrices, Collections.reverseOrder()); //по убыванию
        }
        Assert.assertEquals(pricesFromSite, sortedPrices);
    }
}

