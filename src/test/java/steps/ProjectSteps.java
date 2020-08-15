package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import poms.ProjectPOM;

import java.util.List;
import java.util.Set;


public class ProjectSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;


    protected String email = "group2@gmail.com";
    protected String password = "group2";

    protected ProjectPOM pom;


    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String URL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver,10);
        pom = new ProjectPOM(driver);

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Then("^I try to login in by email and password\\.$")
    public void i_try_to_login_in_by_email_and_password() {

        // Click on sign in button
        pom.signInButton.click();

        // Enter the email address
        pom.emailBox.sendKeys(email);

        // Enter the password
        pom.passwordBox.sendKeys(password);

        // Click on Sign in button
        pom.submitSignInButton.click();

    }

    @And("^I click on following elemen and check them than can I reach to correct site\\.$")
    public void iClickOnFollowingElemenAndCheckThemThanCanIReachToCorrectSite(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        for(List<String> column: rows) {
            for (String name: column) {
                WebElement element = getElement(name);
                element.click();
                String title = getNextWindowsUrl();
                Assert.assertTrue(title.contains(name));
            }
        }
        driver.quit();
    }

    public String getNextWindowsUrl(){
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles) {
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }
        String url = driver.getCurrentUrl();
        driver.close();
        driver.switchTo().window(mainWindowHandle);
        return url;
    }

    public WebElement getElement(String name){

        WebElement element = null;
        switch (name){
            case "facebook":
                element = pom.facebookLink;
                break;
            case "twitter":
                element = pom.twitterLink;
                break;
            case "youtube":
                element = pom.youtubeLink;
                break;
            case "google":
                element = pom.googlePlusLink;
                break;
            default:
                Assert.fail(element + " menu is not implement!");
        }
        return  element;
    }

}
