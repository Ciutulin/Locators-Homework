import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Tools {

    static protected WebDriver driver;
    public static void main(String args[]){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique email address
                                                   and username every time when you run the program*/

        String username = "username" + random ;
        String email = "emailtest" + random + "@yahoo.com";

        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://demoqa.com/registration/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("name_3_firstname")).sendKeys("Firstnametest");
        driver.findElement(By.id("name_3_lastname")).sendKeys("Lastnametest");

        driver.findElement(By.cssSelector("input[value='single']")).click();//radio button
        driver.findElement(By.cssSelector("input[value='dance']")).click();//radio value


        //dropdown
        Select droplist = new Select(driver.findElement(By.name("dropdown_7")));//create an object for dropdown
        droplist.selectByVisibleText("Albania");//select from dropdown Albania value

        Select droplist1 = new Select(driver.findElement(By.name("date_8[date][mm]")));//create an object for dropdown
        droplist1.selectByVisibleText("1");//select from dropdown Albania value

        Select droplist2 = new Select(driver.findElement(By.name("date_8[date][dd]")));//create an object for dropdown
        droplist2.selectByVisibleText("2");//select from dropdown Albania value

        Select droplist3 = new Select(driver.findElement(By.name("date_8[date][yy]")));//create an object for dropdown
        droplist3.selectByVisibleText("2012");//select from dropdown Albania value



        driver.findElement(By.id("phone_9")).sendKeys("0123456789");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email_1")).sendKeys(email);


        driver.findElement(By.id("description")).sendKeys("Nice");
        driver.findElement(By.id("password_2")).sendKeys("12345678abc");
        driver.findElement(By.id("confirm_password_password_2")).sendKeys("12345678abc");


        driver.findElement(By.cssSelector("input[value='Submit']")).click();

        String ExpectedMessage = "Thank you for your registration"; //ce ma stept sa afiseze cand am creat userul
        String ActualMessage = driver.findElement(By.xpath("//*[@class='piereg_message']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
        else {
            System.out.println("Your Test case is Faild");
        }

        driver.close();

    }
}
