import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.Select;
public class MercuryTours {

    static protected WebDriver driver;
    public static void main(String args[]){

        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");
        driver = new ChromeDriver();//call the web driver

        driver.manage().window().maximize();
        driver.get("http://newtours.demoaut.com/mercurysignon.php");//open the webpage
        driver.findElement(By.linkText("registration form")).click();//click on registration link
        driver.findElement(By.name("firstName")).sendKeys("Anca");//input first name in text field
        driver.findElement(By.name("lastName")).sendKeys("Donea");//input last name in text field
        driver.findElement(By.name("phone")).sendKeys("07458123123");//input phone number in text field
        driver.findElement(By.id("userName")).sendKeys("Anca@yahoo.com");//input user name in text field
        driver.findElement(By.name("address1")).sendKeys("28 Marian Avenue");//input address1 in text field
        driver.findElement(By.name("address2")).sendKeys("Hemel");//input address2r in text field
        driver.findElement(By.name("city")).sendKeys("Hemel Hempstead");//input city in text field
        driver.findElement(By.name("state")).sendKeys("Vancouver");//input textr in text field
        driver.findElement(By.name("postalCode")).sendKeys("HP2 5PH");//input postalCode in text field

        Select droplist = new Select(driver.findElement(By.name("country")));//create an object for dropdown
        droplist.selectByVisibleText("GHANA");//select from dropdown GHANA value

        driver.findElement(By.id("email")).sendKeys("Anca1");//input email in text field
        driver.findElement(By.name("password")).sendKeys("Anca123");//input password in text field
        driver.findElement(By.name("confirmPassword")).sendKeys("Anca123");//input confirmPassword in text field
        driver.findElement(By.name("register")).click();//click on submit button
        driver.findElement(By.linkText("sign-in")).click();//click on registration link

        driver.findElement(By.name("userName")).sendKeys("Anca1");
        driver.findElement(By.name("password")).sendKeys("Anca123");
        driver.findElement(By.name("login")).click();
        //driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        //driver.findElement(By.name("userName")).sendKeys("Anca");
        //driver.findElement(By.name("password")).sendKeys("Alina1234");
        //driver.findElement(By.name("login")).click();

        String ExpectedMessage = "SIGN-OFF"; //ce ma stept sa afiseze cand am creat userul (ce ar trebui sa apara pe pagina)
        String ActualMessage = driver.findElement(By.xpath("//*[@href='mercurysignoff.php']")).getText();//ce afiseaza din program

        if(ExpectedMessage.equals(ActualMessage)){
            System.out.println("Your Test case is pass");
        }
        else {
            System.out.println("Your Test case is Faild");
        }

        driver.close();




    }
}
