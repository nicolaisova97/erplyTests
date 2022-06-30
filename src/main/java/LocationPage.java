import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage {
    private WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By locationPos = By.xpath("//div[@class='Clickable-div list-group-item']");

    public void selectLocationPos() {
        driver.findElement(locationPos).click();
    }
}
