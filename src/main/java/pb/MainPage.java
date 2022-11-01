package pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver webDriver;
    private final By categoryWomenMenuItem = By.className("menu-header-item__title");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void openWomenCategoryPage() {
        webDriver.findElement(categoryWomenMenuItem).click();
    }
}
