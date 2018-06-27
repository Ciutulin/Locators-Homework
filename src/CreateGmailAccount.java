import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CreateGmailAccount {

    static protected WebDriver driver;
    public static void main(String args[]){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique
                                                  username every time when you run the program*/

        String username = "username" + random +"test" ;

        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.findElement(By.id("firstName")).sendKeys("Mariana");
        driver.findElement(By.id("lastName")).sendKeys("Ciutulin");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.name("Passwd")).sendKeys("test&&12345678");
        driver.findElement(By.name("ConfirmPasswd")).sendKeys("test&&12345678");
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();

        driver.findElement(By.id("phoneNumberId")).sendKeys("07245111222");
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();

        driver.findElement(By.id("code")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();

        //enter personal details
        driver.findElement(By.xpath("//*[class='whsOnd zHQkBf']")).sendKeys("danaciutulin@yahoo.com");
        Select droplist = new Select(driver.findElement(By.id("month")));//create an object for dropdown
        droplist.selectByVisibleText("July");//select from dropdown 1 value

        driver.findElement(By.id("day")).sendKeys("24");
        driver.findElement(By.id("year")).sendKeys("1982");
        Select droplist1 = new Select(driver.findElement(By.id("gender")));//create an object for dropdown
        droplist1.selectByVisibleText("Female");//select from dropdown 1 value
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();

        //tick privacy and terms
        driver.findElement(By.xpath("//*[@class='uHMk6b fsHoPb']")).click();
        driver.findElement(By.xpath("//*[@class='uHMk6b fsHoPb']")).click();
        //create account
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();
        //confirm
        driver.findElement(By.xpath("//*[@class='CwaK9']")).click();


        //verify if the automation test pass or fail
        String ExpectedMessage = "Welcome, Mariana Ciutulin"; //ce ma stept sa afiseze cand am creat userul
        String ActualMessage = driver.findElement(By.xpath("//*[@class='ZrQ9j']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
        else {
            System.out.println("Your Test case is Fail");
        }

        driver.close();











    }
}
