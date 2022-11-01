package pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver webDriver;

    private final By categoryProducts = By.cssSelector("a[href='https://www.lcwaikiki.com/tr-TR/TR/etiket/hesapli-ve-trend-urunler']");

    public CategoryPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public String pageTitle() {

        return webDriver.getTitle();
    }

    public void openCategoryProductsPage() {
        webDriver.findElement(categoryProducts).click();
    }
}
