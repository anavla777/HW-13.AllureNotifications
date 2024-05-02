package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoqaFormWithPageObjectsTests extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest(){
        registrationPage.openPage()
                .checkFormControl()
                .setFirstName("Jensen")
                .setLastName("Huang")
                .setUserEmail("test@mail.com")
                .setGender("Male")
                .setUserNumber("1111111111")
                .setDateOfBirth("01","January","1970")
                .setSubjects("Physics")
                .setSubjects("Computer Science")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture("selenide-logo-big.png")
                .setCurrentAddress("Groove street 1")
                .setState("Haryana")
                .setCity("Panipat")

                .submit()
                .checkResult("Student Name", "Jensen Huang")
                .checkResult("Student Email", "test@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1111111111")
                .checkResult("Date of Birth", "01 January,1970")
                .checkResult("Subjects", "Physics, Computer Science")
                .checkResult("Hobbies", "Reading, Music")
                .checkResult("Picture", "selenide-logo-big.png")
                .checkResult("Address", "Groove street 1")
                .checkResult("State and City", "Haryana Panipat");
    }

    @Test
    void RegistrationRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName("Ada")
                .setLastName("Lovelace")
                .setGender("Female")
                .setUserNumber("7999999999")
                .submit()
                .checkResult("Student Name", "Ada Lovelace")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "7999999999");
    }

    @Test
    void emptyRegistrationFormTest(){
        registrationPage.openPage()
                .submit()
                .checkValidation();
    }
}
