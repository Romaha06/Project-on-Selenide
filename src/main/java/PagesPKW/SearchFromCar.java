package PagesPKW;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class SearchFromCar {


    private SelenideElement selectWidth = $x("//select[@name='Width']");
    private SelenideElement selectHeight = $x("//select[@name='CrossSections']");
    private SelenideElement selectSize = $x("//select[@name='Size']");


    public void width() {
        System.out.println("Choose from Width.");
        selectWidth.click();
        $x("//option[@value='215']").click();
    }

    public void height() {
        System.out.println("Choose from Height.");
        selectHeight.click();
        $x("//option[@value='65']").click();
    }

    public void size() {
        System.out.println("Choose from Size.");
        selectSize.click();
        $x("//option[@value='16']").click();
    }

    public void selectionOfParameters() {
        width();
        height();
        size();
    }
}
