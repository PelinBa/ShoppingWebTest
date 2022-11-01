package pb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddBasketProduct {

    private WebDriver webDriver;
    private JavascriptExecutor javascriptExecutor;

    private MainPage mainPage;

    private ProductListPage productListPage;

    private CategoryPage categoryPage;

    private ProductDetailPage productDetailPage;

    private BasketPage basketPage;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "/Users/pelin/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.lcwaikiki.com/tr-TR/TR");
        webDriver.manage().window().maximize();
        javascriptExecutor = (JavascriptExecutor) webDriver;

        mainPage = new MainPage(webDriver);
        productListPage = new ProductListPage(webDriver);
        categoryPage = new CategoryPage(webDriver);
        productDetailPage = new ProductDetailPage(webDriver);
        basketPage = new BasketPage(webDriver);
    }

    @After
    public void after() {
        webDriver.quit();
    }

    @Test
    public void add_selected_women_product_in_basket() throws InterruptedException {
        // Check Main page title
        String mainPageTitle = "LC Waikiki | İlk Alışverişte Kargo Bedava! - LC Waikiki";
        Assert.assertEquals(mainPage.pageTitle(), mainPageTitle);
        Thread.sleep(2000);
        // Open Category page
        mainPage.openWomenCategoryPage();

        // Check Category page title
        String categoryPageTitle = "Kadın Giyim - Kadın Kıyafetleri - LC Waikiki";
        Assert.assertEquals(categoryPage.pageTitle(), categoryPageTitle);
        Thread.sleep(2000);
        // Scroll to page 1300 px
        javascriptExecutor.executeScript("scrollBy(0,1300)");
        Thread.sleep(1000);

        // Open Product List page
        categoryPage.openCategoryProductsPage();
        // Check Product List page title
        String productListPageTitle = "Trend Ve Hesaplı Ürünler Lc Waikiki'de - LC Waikiki";
        Assert.assertEquals(productListPage.pageTitle(), productListPageTitle);
        // Scroll to page 300 px
        javascriptExecutor.executeScript("scrollBy(0,300)");
        Thread.sleep(2000);

        // Open selected product
        productListPage.openSelectedProduct();
        // Check Product Detail page title
        String productDetailPageTitle = "Pembe Ekose Kadın Etek - W2FM78Z8-LNQ - LC Waikiki";
        Assert.assertEquals(productDetailPage.pageTitle(), productDetailPageTitle);
        Thread.sleep(2000);

        // Select Product size
        productDetailPage.selectSize();
        // Add Product in basket
        productDetailPage.addBasket();
        Thread.sleep(2000);
        // Open Basket Page
        productDetailPage.openBasketPage();
        // Check Basket page title
        String basketPageTitle = "Sepetim - LC Waikiki";
        Assert.assertEquals(basketPage.pageTitle(), basketPageTitle);
        Thread.sleep(2000);

        // Open Main page
        basketPage.openMainPage();
        // Check Main page title
        Assert.assertEquals(mainPage.pageTitle(), mainPageTitle);
        Thread.sleep(2000);
    }
}
