package selenidTests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SearchBookPage {
    @FindBy(id = "searchBox")
    private SelenideElement searchBox;

    @FindBy(id = "basic-addon2")
    private SelenideElement search;

    public void inputsearchBox(String searchBox) {
        this.searchBox.sendKeys(searchBox);
    }

    public void clickSearch() {
        this.search.click();
    }

}
