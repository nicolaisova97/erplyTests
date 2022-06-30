import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutomatedTestCases {

    public WebDriver driver;
    private SignInPage signInPage;
    private LocationPage locationPage;
    private DashboardPage dashboardPage;

    String clientCode = "104572";
    String username = "testassignment";
    String password = "PosTestAssignment123";
    String productCode = "STRAWBERRY1";
    String invalidProductCode = "hahaha";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://epos.erply.com/latest/");
        signInPage = new SignInPage(driver);
        locationPage = new LocationPage(driver);
        dashboardPage = new DashboardPage(driver);
        signInPage.signIn(clientCode, username, password);
        locationPage.selectLocationPos();
    }

    @Test
    public void searchResultsWhenNothingIsEnteredIntoTheInputField() {
        dashboardPage.clickProductsInput();
        dashboardPage.verifyIfProductsTableIsDisplayed();
    }

    @Test
    public void searchResultsByValidProductCode() throws InterruptedException {
        dashboardPage.typeProductCode(productCode);
        Thread.sleep(1000);
        Assert.assertEquals(productCode, dashboardPage.getSearchedProductCodeText());
    }

    @Test
    public void searchResultsByInvalidCode() throws InterruptedException {
        dashboardPage.typeProductCode(invalidProductCode);
        Thread.sleep(1000);
        Assert.assertEquals("No results found.", dashboardPage.getNoResultFoundText());
    }

    @Test
    public void openProductDetailsOfASearchedProduct() throws InterruptedException {
        dashboardPage.clickProductsInput();
        Thread.sleep(1000);
        dashboardPage.clickProductMagnifierIcon();
        if (driver.findElement(By.xpath("//div[@class='product-view']")).isDisplayed()) {
            System.out.println("Product details are displayed");
        } else {
            System.out.println("Product details are not displayed");
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
