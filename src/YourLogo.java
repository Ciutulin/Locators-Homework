import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class YourLogo {

    static protected WebDriver driver;
    public static void main(String args[]){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique email address
                                                   every time when you run the program*/


        String email = "emailtest" + random +"@yahoo.com";


        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);//crate account
        driver.findElement(By.id("SubmitCreate")).click();//submit

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//wait 5 seconds to load the page
        driver.findElement(By.id("id_gender2")).click();//select radio button




        driver.findElement(By.id("customer_firstname")).sendKeys("Firstnametest ");
        driver.findElement(By.id("customer_lastname")).sendKeys("Lastnametest ");

        driver.findElement(By.name("passwd")).sendKeys("passwdtest");

        Select droplist = new Select(driver.findElement(By.id("days")));//create an object for dropdown
        droplist.selectByVisibleText("1  ");//select from dropdown 23 value

        Select droplist1 = new Select(driver.findElement(By.id("months")));//create an object for dropdown
        droplist1.selectByVisibleText("January ");//select from dropdown January value

        Select droplist2 = new Select(driver.findElement(By.id("years")));//create an object for dropdown
        droplist2.selectByVisibleText("2018  ");//select from dropdown 1980 value

        driver.findElement(By.id("uniform-newsletter")).click();
        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("firstname")).sendKeys("firstnametest");
        driver.findElement(By.id("lastname")).sendKeys("lastnametest");
        driver.findElement(By.id("company")).sendKeys("companytest");
        driver.findElement(By.id("address1")).sendKeys("address1test");
        driver.findElement(By.id("address2")).sendKeys("address2test");
        driver.findElement(By.id("city")).sendKeys("citytest");

        Select droplist3 = new Select(driver.findElement(By.id("id_state")));//create an object for dropdown
        droplist3.selectByVisibleText("Alabama");//select from dropdown Alabama value

        driver.findElement(By.id("postcode")).sendKeys("12345");

        Select droplist4 = new Select(driver.findElement(By.id("id_country")));//create an object for dropdown
        droplist4.selectByVisibleText("United States");//select from dropdown Alabama value

        driver.findElement(By.id("other")).sendKeys("othertest");
        driver.findElement(By.id("phone")).sendKeys("0123456789");
        driver.findElement(By.id("phone_mobile")).sendKeys("12345678901");
        driver.findElement(By.id("alias")).sendKeys("aliastest");

        driver.findElement(By.id("submitAccount")).click();

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign out")).click();
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys("passwdtest");
        driver.findElement(By.id("SubmitLogin")).click();

        String ExpectedMessage = "Welcome to your account. Here you can manage all of your personal information and orders."; //ce ma stept sa afiseze cand am creat userul
        String ActualMessage = driver.findElement(By.xpath("//*[@class='info-account']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
        else {
            System.out.println("Your Test case is Faild");
        }

        driver.close();

















    }
}
