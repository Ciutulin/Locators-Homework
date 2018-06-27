import net.bytebuddy.jar.asm.tree.analysis.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Guru99 {

    static protected WebDriver driver;
    public static void main(String args[]){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique email address
                                                    every time when you run the program*/


        String email = "emailtest" + random + "@yahoo.com";

        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        //create user
        driver.get("http://demo.guru99.com/v4/");
        driver.findElement(By.linkText("here")).click();
        driver.findElement(By.name("emailid")).sendKeys("ancabucur@yahoo.com");
        driver.findElement(By.name("btnLogin")).click();


        //login user (angajatul unui magazin)
        driver.get("http://demo.guru99.com/v4/");
        driver.findElement(By.name("uid")).sendKeys("mngr139355");
        driver.findElement(By.name("password")).sendKeys("qybEmAr");
        driver.findElement(By.name("btnLogin")).click();


        //add customer
        driver.findElement(By.linkText("New Customer")).click();
        driver.findElement(By.name("name")).sendKeys("Mihaela");

        driver.findElement(By.cssSelector("input[value='f']")).click();//radio button
        driver.findElement(By.id("dob")).sendKeys("09/15/1985");

        driver.findElement(By.name("addr")).sendKeys("28 Martian Avenue HP2 5PL");
        driver.findElement(By.name("city")).sendKeys("Hemel Hempstead");
        driver.findElement(By.name("state")).sendKeys("United Kingdom");
        driver.findElement(By.name("pinno")).sendKeys("123456");
        driver.findElement(By.name("telephoneno")).sendKeys("07456123456");
        driver.findElement(By.name("emailid")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys("Nostradamus");
        driver.findElement(By.name("sub")).click();



        String ExpectedMessage = "Customer Registered Successfully!!!"; //ce ma stept sa afiseze cand am creat userul
        String ActualMessage = driver.findElement(By.xpath("//*[@class='heading3']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
        else {
            System.out.println("Your Test case is Faild");
        }

        driver.close();





    }
}
