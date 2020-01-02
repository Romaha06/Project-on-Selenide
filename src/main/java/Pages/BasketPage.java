package Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {

    public SelenideElement priceInBasket = $x("//td[@class='price']");
}
