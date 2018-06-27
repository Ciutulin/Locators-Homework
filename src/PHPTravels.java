import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class PHPTravels {

    static protected WebDriver driver;
    public static void main(String args[]){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique email address
                                                   every time when you run the program*/

        String email = "emailtest" + random +"@yahoo.com";

        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/account/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        driver.findElement(By.cssSelector("input[id='remember-me']")).click();//sellect the radiobutton*/
        driver.findElement(By.linkText("SIGN UP")).click();


        driver.findElement(By.name("firstname")).sendKeys("firstnametest");
        driver.findElement(By.name("lastname")).sendKeys("lastnametest");
        driver.findElement(By.name("phone")).sendKeys("phonetest");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("passweortest");
        driver.findElement(By.name("confirmpassword")).sendKeys("passweortest");



        driver.findElement(By.xpath("//*[@type='submit']")).click();//Xpath relative

        String ExpectedMessage = "Hi, firstnametest lastnametest"; //ce ma stept sa afiseze cand am creat userul
        String ActualMessage = driver.findElement(By.xpath("//*[@class='RTL']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
            else {
            System.out.println("Your Test case is Faild");
        }

        driver.close();



    }
}
