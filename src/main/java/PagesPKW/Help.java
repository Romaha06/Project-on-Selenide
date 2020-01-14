package PagesPKW;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.fail;

public class Help {


    public SelenideElement btnCookies = $x("//div[@class='block-cookies__button']");


    public boolean checkElementIsDisplayed(SelenideElement element) {
        try {
            element.shouldBe(visible);
        } catch (ElementNotFound e) {
            return false;
        }
        return true;
    }

    public void closePopup(SelenideElement element) {
        System.out.println("Close popup.");
        try {
            element.shouldBe(visible).click();
        } catch (UIAssertionError e) {
            Assert.assertTrue(true);
        }
    }

    public void checkPageURL(String expectedURL) {
        try {
            Wait().until(webDriver -> url().equals(expectedURL));
        } catch (TimeoutException e) {
            System.out.println(url());
            fail("Invalid URL " + expectedURL);
        }
    }
}
