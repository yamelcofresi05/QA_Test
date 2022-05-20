package Login;
//@YamelCofresi



import Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest  {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "Resorces/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");


    }


    @Test
    public void Test_InvalidPassword(){
        LoginPage login = new LoginPage(driver);
        login.setUsername("tomsmith");
        login.setPassword("123456788");
        login.clickLoginButton();
        Assert.assertTrue(login.getAlertMessage().contains("Your password is invalid!"),"Failed");


    }
    @Test
    public void Test_InvalidUser() {

        LoginPage login = new LoginPage(driver);
        login.setUsername("yamelcofresi");
        login.setPassword("SuperSecretPassword!");
        login.clickLoginButton();
        Assert.assertTrue(login.getAlertMessage().contains("Your username is invalid!"),"Failed");

    }

    @AfterMethod
    public void closeWindow(){
        driver.close();
    }


}
