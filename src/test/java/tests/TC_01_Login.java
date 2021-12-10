package tests;

import jdk.jfr.Description;
import myMethods.MyMethods;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.LoginPage;
import utils.Driver;
import utils.ExcelUtility;

import java.util.List;

public class TC_01_Login extends Driver {

    private final LoginPage loginPage = new LoginPage();
    private final AdminPage adminPage = new AdminPage();
    private final MyMethods myMethods = new MyMethods();

    @Test
    @Description("As a user, I should not login if I do not choose location.")
    public void TC_01() {
        List<List<String>> dataList = ExcelUtility.getListData("src/test/java/resources/TestData.xlsx", "LoginPage", 3);
        myMethods.sendKeysFunction(loginPage.getInputUsername(), dataList.get(1).get(1));
        myMethods.sendKeysFunction(loginPage.getInputPassword(), dataList.get(1).get(2));
        myMethods.clickFunction(loginPage.getButtonLogin());
        myMethods.elementIsVisible(loginPage.getTextLocationError());
    }

    @Test
    @Description("As a user, I should not login with invalid username or password.")
    public void TC_02() {
        List<List<String>> dataList = ExcelUtility.getListData("src/test/java/resources/TestData.xlsx", "LoginPage", 3);
        for (int i = 0; i < 7; i++) {
            myMethods.clickFunction(loginPage.getButtonLaboratory());
            myMethods.sendKeysFunction(loginPage.getInputUsername(), dataList.get(i + 2).get(1));
            myMethods.sendKeysFunction(loginPage.getInputPassword(), dataList.get(i + 2).get(2));
            myMethods.clickFunction(loginPage.getButtonLogin());
            myMethods.elementIsVisible(loginPage.getTextErrorMessage());
        }
    }

    @Test
    @Description("As a user, I want to login with credentials, so that I can manage the system.")
    public void TC_03() {
        List<List<String>> dataList = ExcelUtility.getListData("src/test/java/resources/TestData.xlsx", "LoginPage", 3);
        myMethods.clickFunction(loginPage.getButtonLaboratory());
        myMethods.sendKeysFunction(loginPage.getInputUsername(), dataList.get(1).get(1));
        myMethods.sendKeysFunction(loginPage.getInputPassword(), dataList.get(1).get(2));
        myMethods.clickFunction(loginPage.getButtonLogin());
        myMethods.verifyText(loginPage.getTextLoginCheck(), "Logged in as Super User (admin) at Laboratory.");
    }

    @Test
    public void TC_04() {        myMethods.clickFunction(adminPage.getButtonAdmin());
        myMethods.clickFunction(adminPage.getButtonMyAccount());
        myMethods.verifyText(adminPage.getSelectedLocation(), "Laboratory");
        myMethods.clickFunction(adminPage.getSelectedLocation());
        myMethods.clickFunction(adminPage.getButtonLocationPharmacy());
        myMethods.waitUntilTextToBe(adminPage.getSelectedLocation(), "Pharmacy");
        myMethods.clickFunction(loginPage.getButtonLogout());
    }
}
