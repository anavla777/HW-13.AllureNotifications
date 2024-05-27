package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");

    public TextBoxPage openPage() {
        open("/text-box");
        return this;
    }

    public TextBoxPage setUserName(String value){
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public TextBoxPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setPermanentAddress(String value){
        permanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage submit(){
        submitButton.scrollIntoView(true);
        submitButton.click();
        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
