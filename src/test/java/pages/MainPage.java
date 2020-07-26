package pages;

public class MainPage {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        loginPage.start();
        loginPage.openSelectLanguageList();
        loginPage.chooseEnglishLanguage();
        loginPage.finish();
    }
}
