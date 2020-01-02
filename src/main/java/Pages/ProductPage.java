package Pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {

    Help help = new Help();
    ListingPage listingPage = new ListingPage();
    BasketPage basketPage = new BasketPage();

    private SelenideElement btnAddBasketProdPage = $x("//button[@class='pkw-product__buy-btn basket_btn tires ']");
    private SelenideElement closePopupProdPage = $x("//span[@class='popup-related__close']");


    public void addToBasketFromProdPage(){
        System.out.println("Add item to basket from product page");
        listingPage.prodPageLink.click();
        btnAddBasketProdPage.click();
        help.closePopup(closePopupProdPage);
        listingPage.basket.click();
        basketPage.priceInBasket.shouldBe(visible);
    }
}
