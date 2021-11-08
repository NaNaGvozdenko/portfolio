package selenidTests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class LoginBookStorePage {

    @FindBy(id = "userName")
    private SelenideElement userName;

    @FindBy(id = "password")
    private SelenideElement password;

    @FindBy(id = "login")
    private SelenideElement login;

    public void inputUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLogin() { this.login.click(); }
}
