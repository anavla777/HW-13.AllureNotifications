package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import static io.qameta.allure.Allure.step;

public class DemoqaFormWithPageObjectsTests extends TestBase{
    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("demoqaForm")
    @DisplayName("Successful registration test")
    void successfulRegistrationTest(){
        step("Open registration form", () -> {
            registrationPage
                    .openPage()
                    .checkFormControl();
        });
        step("Fill registration form", () -> {
            registrationPage
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setUserEmail(testData.email)
                    .setGender(testData.gender)
                    .setUserNumber(testData.phone)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .setSubjects(testData.subjectList)
                    .setHobbies(testData.hobbiesList)
                    .uploadPicture(testData.picture)
                    .setCurrentAddress(testData.address)
                    .setState(testData.state)
                    .setCity(testData.city)
                    .submit();
        });
        step("Validate result", () -> {
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.email)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phone)
                    .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                    .checkResult("Subjects", String.join(", ", testData.subjectList))
                    .checkResult("Hobbies", String.join(", ", testData.hobbiesList))
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.address)
                    .checkResult("State and City", testData.state + " " + testData.city);
        });
    }

    @Test
    @Tag("demoqaForm")
    @DisplayName("Registration with only required field test")
    void RegistrationRequiredFieldsTest(){
        step("Open registration form", () -> {
            registrationPage.openPage();
        });
        step("Fill only required fields", () -> {
            registrationPage
                    .setFirstName(testData.firstName)
                    .setLastName(testData.lastName)
                    .setGender(testData.gender)
                    .setUserNumber(testData.phone)
                    .submit();
        });
        step("Validate result", () -> {
            registrationPage
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.gender)
                    .checkResult("Mobile", testData.phone);
        });
    }

    @Test
    @Tag("demoqaForm")
    @DisplayName("Send empty form test")
    void emptyRegistrationFormTest(){
        step("Open registration form", () -> {
            registrationPage.openPage();
        });
        step("Validate result", () -> registrationPage
                .submit()
                .checkValidation());
    }
}
