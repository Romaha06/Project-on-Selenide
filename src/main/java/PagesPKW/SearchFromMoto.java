package PagesPKW;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class SearchFromMoto {


    private SelenideElement selectWidthMoto = $x("//select[@name='Width']");
    private SelenideElement selectHeightMoto = $x("//select[@name='CrossSections']");
    private SelenideElement selectTypMoto = $x("//select[@id='form_R_ZR']");
    private SelenideElement selectSizeMoto = $x("//select[@name='Size']");

    public void widthMoto() {
        System.out.println("Choose from Width Moto.");
        selectWidthMoto.click();
        $x("//option[@value='120']").click();
    }

    public void heightMoto() {
        System.out.println("Choose from Height Moto.");
        selectHeightMoto.click();
        $x("//option[@value='70']").click();
    }

    public void typMoto() {
        System.out.println("Choose from Typ Moto.");
        selectTypMoto.click();
        $x("//option[@value='R']").click();
    }

    public void sizeMoto() {
        System.out.println("Choose from Size Moto.");
        selectSizeMoto.click();
        $x("//option[@value='14']").click();
    }

    public void selectionOfParametersMoto() {
        widthMoto();
        heightMoto();
       // typMoto();
        sizeMoto();
    }
}
