package PagesPKW;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasketPage {

    public SelenideElement priceInBasket = $x("//td[@class='price']");
    private SelenideElement delBtn = $x("//a[@class='delBtn']");
    private SelenideElement delPopup = $x("//div[@class='delete-popup cart-popup']");
    private SelenideElement submitYes = $x("//div[@class='popup-content__buttons']/a[2][@class='submit']");
    private SelenideElement popupCloseRedirect = $x("//div[@class='cart-popup close-redirect']");
    private SelenideElement popupBtnClose = $x("//div[@class='popup-content__buttons']/a[@class='color close_popup']");


    public void deleteFromBasket(){
        System.out.println("Remove item from basket");
        delBtn.click();
        delPopup.shouldBe(Condition.visible);
        submitYes.click();
        popupCloseRedirect.shouldBe(Condition.visible);
        popupBtnClose.click();
    }
}
