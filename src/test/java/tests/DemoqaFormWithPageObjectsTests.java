package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

public class DemoqaFormWithPageObjectsTests extends TestBase{
    TestData testData = new TestData();
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest(){
        registrationPage.openPage()
                .checkFormControl()
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

                .submit()
                .checkResult("Student Name", testData.firstName+" "+testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender",testData.gender)
                .checkResult("Mobile", testData.phone)
                .checkResult("Date of Birth", testData.day +" "+testData.month +","+testData.year)
                .checkResult("Subjects",String.join(", ",testData.subjectList))
                .checkResult("Hobbies", String.join(", ", testData.hobbiesList))
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }

    @Test
    void RegistrationRequiredFieldsTest(){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.phone)
                .submit()
                .checkResult("Student Name", testData.firstName+" "+testData.lastName)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phone);
    }

    @Test
    void emptyRegistrationFormTest(){
        registrationPage.openPage()
                .submit()
                .checkValidation();
    }
}
