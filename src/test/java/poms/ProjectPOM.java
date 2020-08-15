package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPOM {
    public ProjectPOM(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".login")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "passwd")
    public WebElement passwordBox;


    @FindBy(id = "SubmitLogin")
    public WebElement submitSignInButton;

    @FindBy(css = "#social_block li:nth-child(1)")
    public WebElement facebookLink;

    @FindBy(css = "#social_block li:nth-child(2)")
    public WebElement twitterLink;

    @FindBy(css = "#social_block li:nth-child(3)")
    public WebElement youtubeLink;

    @FindBy(css = "#social_block li:nth-child(4)")
    public WebElement googlePlusLink;



}
