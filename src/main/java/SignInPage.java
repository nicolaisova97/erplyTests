import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    private By clientCodeField = By.xpath("//input[@name='clientCode']");
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By signInButton = By.xpath("//button[@class='btn btn-secondary btn-lg']");

    public void typeClientCode(String clientCode){
        driver.findElement(clientCodeField).sendKeys(clientCode);
    }
    public void typeUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickSignIn(){
        driver.findElement(signInButton).click();
    }
    public void signIn(String clientCode, String username, String password){
        typeClientCode(clientCode);
        typeUsername(username);
        typePassword(password);
        clickSignIn();

    }



}
