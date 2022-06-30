import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productsInput = By.xpath("//input[@placeholder='Products']");
    private By searchedProductCode = By.xpath("(//p[contains(@class, 'MuiTypography-root MuiTypography-body1')])[2]");
    private By noResultFound = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1']");
    private By productMagnifierIcon = By.xpath("//td[@class='MuiTableCell-root MuiTableCell-body MuiTableCell-alignRight']");
    private boolean productsTableIsDisplayed;


    public void clickProductsInput() {
        driver.findElement(productsInput).click();
    }

    public void typeProductCode(String productCode) {
        driver.findElement(productsInput).click();
        driver.findElement(productsInput).sendKeys(productCode);
    }

    public String getSearchedProductCodeText() {
        return driver.findElement(searchedProductCode).getText();
    }

    public String getNoResultFoundText() {
        return driver.findElement(noResultFound).getText();
    }

    public void clickProductMagnifierIcon() {
        driver.findElement(productMagnifierIcon).click();
    }

    public void verifyIfProductsTableIsDisplayed() {
        this.productsTableIsDisplayed = driver.findElement(By.xpath("//table[@class='MuiTable-root MuiTable-stickyHeader']")).isDisplayed();
        if (productsTableIsDisplayed) {
            System.out.println("Table is displayed");
        } else {
            System.out.println("Table is not displayed");
        }
    }


}
