package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageObjectTests extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {

        textBoxPage.openPage()
                .setUserName("Ada")
                .setEmail("ada@lovelace.com")
                .setCurrentAddress("Austin, Texas")
                .setPermanentAddress("Moscow, Russia")
                .submitClick()
                .checkResult("Name:", "Ada")
                .checkResult("Email:", "ada@lovelace.com")
                .checkResult("Current Address :", "Austin, Texas")
                .checkResult("Permananet Address :", "Moscow, Russia");
    }
}
