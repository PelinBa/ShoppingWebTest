package pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {

    private WebDriver webDriver;

    private final By categorySelectedProduct = By.cssSelector("a[data-optionid='2614914']");

    public ProductListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void openSelectedProduct() {
        webDriver.findElement(categorySelectedProduct).click();
    }
}
