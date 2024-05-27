package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;
import pages.components.CityComponent;
import pages.components.StateComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final SelenideElement
            userForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectAutoComplete = $(".subjects-auto-complete__menu"),
            hobbiesWrapperInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            submitClick = $("#submit"),
            outputTable= $(".table-responsive");
    CalendarComponent calendarComponent = new CalendarComponent();
    StateComponent stateComponent = new StateComponent();
    CityComponent cityComponent = new CityComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String[] subjects) {
        for (String subject : subjects) {
            subjectsInput.setValue(subject);
            subjectAutoComplete.$(byText(subject)).click();
        }
        return this;
    }

    public RegistrationPage setHobbies(String[] hobbiesList){
        for (String hobby : hobbiesList){
            hobbiesWrapperInput.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage setState(String value){
        stateComponent.setState(value);
        return this;
    }

    public RegistrationPage setCity(String value){
        cityComponent.setCity(value);
        return this;
    }

    public RegistrationPage submit(){
        submitClick.scrollIntoView(true);
        submitClick.click();
        return this;
    }

    @Step("Field: {key} should have text: {value}")
    public RegistrationPage checkResult(String key, String value) {
        outputTable.$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }

    public RegistrationPage checkFormControl(){
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        return this;
    }
    public void checkValidation() {
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        lastNameInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        userNumberInput.shouldHave(cssValue("border-color","rgb(220, 53, 69)"));
        outputTable.shouldNotBe(visible);
    }
}
