package pb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {

    private WebDriver webDriver;

    private final By selectedSize = By.cssSelector("a[size='36']");

    private final By addBasketButton = By.id("pd_add_to_cart");

    private final By basketButton = By.id("shopping-cart");

    public ProductDetailPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String pageTitle() {
        return webDriver.getTitle();
    }

    public void selectSize() {
        webDriver.findElement(selectedSize).click();
    }

    public void addBasket() {
        webDriver.findElement(addBasketButton).click();
    }

    public void openBasketPage() {
        webDriver.findElement(basketButton).click();
    }
}
