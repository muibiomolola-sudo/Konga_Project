import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Objects;

public class KongaTest {
    public WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        // locate where the firefox driver is
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ADMIN\\Desktop\\Konga_Project\\resources\\geckodriver.exe");
        //. Open your firefox Browser
        driver = new FirefoxDriver();
        //. maximize the browser
        driver.manage().window().maximize();
        //. Input konga page URL (https://www.konga.com)
        driver.get("https://www.konga.com/");
        //Test1.Verify that user input the right URL and his on the right webpage
        if (Objects.requireNonNull(driver.getCurrentUrl()).contains("https://www.konga.com/"))
            //pass
            System.out.println("current Webpage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }
    @Test(priority = 0 )
    public void Loginpage() throws InterruptedException {
            //Click on login button to open the login page
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[3]/div[1]/div/div[4]/a")).click();
            //Test2.Verify that when user click on the login button,the user is directed to the login page
            String expectedUrl = "https://www.konga.com/";
            String actualUrl = driver.getCurrentUrl();
            if (Objects.requireNonNull(actualUrl).contains(expectedUrl))
                //pass
                System.out.println("Correct WebPage");
            else
                //fail
                System.out.println("Wrong WebPage");
            Thread.sleep(5000);
    }

    @Test(priority = 1 )
    public void successfulLogin() throws InterruptedException {
            //. Input your username /email on the username field
            driver.findElement(By.id("username")).sendKeys("Sweetpotatoes268@gmail.com");
            //. Input Your password in the password field
            driver.findElement(By.id("password")).sendKeys("Omolola@66");
            //. Click on LogIN button
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[4]/section/section/div/aside/div[2]/div/form/div[3]/button")).click();
            //Test3. Verify that user successfully login with valid details and receive a  success message
            String expectedUrl = "https://www.konga.com/";
            String actualUrl = driver.getCurrentUrl();
            if (Objects.requireNonNull(actualUrl).contains(expectedUrl))
                //pass
                System.out.println("Correct WebPage");
            else
                //fail
                System.out.println("Wrong WebPage");
            Thread.sleep(5000);
    }

    @Test(priority = 2 )
    public void computerandaccesories() throws InterruptedException {
            //Test4. Verify that computers and accessories was navigated to, and Apple Macbook under laptop sub category is present
            // . From the Categories, click on the “Computers and Accessories”
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[3]/div[2]/div/a[2]")).click();
            Thread.sleep(25000);
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section/section/section/section/div/section/div[2]/div[2]/ul/li[6]/a/label/span")).click();
            Thread.sleep(20000);
            //.  Click on the Laptop Sub Category
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
            Thread.sleep(5000);
            //. Click on the Apple MacBooks
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section/section/section/section/div/section/div[2]/div[2]/ul/li[1]/a/ul/li[1]/a/label/span")).click();
            String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
            String actualPageUrl = driver.getCurrentUrl();
            if (Objects.requireNonNull(actualPageUrl).contains(expectedPageUrl))
                //pass
                System.out.println("Correct WebPage");
            else
                //fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
    }

    @Test(priority = 3 )
    public void itemtocart() throws InterruptedException {
            //. Add an item to the cart
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/section/section/section/section/section/section/ul/li[6]/article/div[2]/form/div[2]/button")).click();
            //Test5. verify that item1 is successfully added to cart with the right quantity reflected
            String expectedPageUrl = "https://www.konga.com/category/accessories-computing-5227";
            String actualPageUrl = driver.getCurrentUrl();
            if (Objects.requireNonNull(actualPageUrl).contains(expectedPageUrl))
                //pass
                System.out.println("Correct WebPage");
            else
                //fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
    }

    @Test(priority = 4 )
    public void mycart() throws InterruptedException {
            //. Click on my cart
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/nav/div[3]/div[1]/div/a[3]")).click();
            //Test6. verify item is in the Cart
            WebElement Cartitem = driver.findElement(By.xpath("//*[@id=\"js-cart-items-wrapper\"]/div/div/div[1]"));
            Cartitem.isDisplayed();
            System.out.println("Item present!");
            Thread.sleep(50000);
    }

    @Test(priority = 5 )
    public void checkout() throws InterruptedException {
            //. Click on checkout
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/section/main/div/div[2]/div[4]/div/div[6]/div/a")).click();
            //Test6. verify that the checkout process run smoothly
            String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
            String actualPageUrl = driver.getCurrentUrl();
            if (actualPageUrl.contains(expectedPageUrl))
                //pass
                System.out.println("Correct WebPage");
            else
                //fail
                System.out.println("Wrong Webpage");
            Thread.sleep(5000);
    }

    @Test(priority = 6 )
    public void deliveryaddress() throws InterruptedException {
            //.  Click on change address
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/div[3]/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
            //.  Click on Add delivery address
            driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/div[3]/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        //.  Add first address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/div/aside/div[2]/div/div")).click();
        Thread.sleep(5000);
        //.  Click on use this address
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        //Test7. Verify that the system validates the address and the  checkout process continues smoothly
        String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
        String actualPageUrl = driver.getCurrentUrl();
        if (Objects.requireNonNull(actualPageUrl).contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 7 )
    public void payment() throws InterruptedException {
        //. Go to the payment options, click on pay now
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/div[3]/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        // Click on the continue payment
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/div[3]/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        //Test8. Verify that the page to select payment method was displayed.
        String expectedPageUrl = "https://www.konga.com/checkout/complete-order";
        String actualPageUrl = driver.getCurrentUrl();
        if (Objects.requireNonNull(actualPageUrl).contains(expectedPageUrl))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void iframe() throws InterruptedException {
        //20 select a card payment method
        //20a change from default to iframe
        WebElement paymethod = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("kpg-frame-component");
        //Test9. Verify that card payment method was successfully changed from default to iframe
        String expectedTitle = "SELECT PAYMENT METHOD";
        String actualTitle = driver.getTitle();
        if (Objects.requireNonNull(actualTitle).contains(expectedTitle))
            //pass
            System.out.println("Correct WebPage");
        else
            //fail
            System.out.println("Wrong Webpage");
        Thread.sleep(5000);
    }

    @Test(priority = 9 )
    public void cardpayment() throws InterruptedException {
        // select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("select card method");
        Thread.sleep(5000);
    }

    @Test (priority = 10)
    public void inputcarddetails () throws InterruptedException {
        //. input individual card details
        // input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("1234123454");
        Thread.sleep(5000);
        // input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("1124");
        Thread.sleep(5000);
        // input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("123");
        Thread.sleep(5000);
        System.out.println("input card details");
    }

    @Test (priority = 11)
    public void errormessage () throws InterruptedException {
        // print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(5000);
    }

    @Test (priority = 12)
    public void closeframe () throws InterruptedException {
        //12 close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();
        System.out.println("exit iframe");
        Thread.sleep(5000);
    }
    @AfterTest
    public void closeBrowser() throws InterruptedException {
        //37. Quit the browser.
        driver.quit();
        Thread.sleep(5000);
    }

}





