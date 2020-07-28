package Test_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Place_Pizza_Order {
    private WebDriver driver;

    public Place_Pizza_Order(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (xpath = "//a[@href='/new-order']")
    WebElement NewOrder;
    @FindBy(xpath = "//input[contains(@formcontrolname,'name')]")
    WebElement Name;
    @FindBy (xpath = "//input[contains(@formcontrolname,'email')]")
    WebElement Email;
    @FindBy (xpath = "//input[contains(@formcontrolname,'address')]")
    WebElement Address;
    @FindBy(xpath = "//input[contains(@formcontrolname,'phone')]")
    WebElement Contact_No;

    @FindBy(xpath = "//button[@class='btn'][contains(.,'Small')]")
    WebElement Small;
    @FindBy(xpath = "//button[@class='btn'][contains(.,'Medium')]")
    WebElement Medium;
    @FindBy(xpath = "//button[@class='btn'][contains(.,'Large')]")
    WebElement Large;

    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Bacon')]")
    WebElement Bacon;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Pepperoni')]")
    WebElement Pepperoni;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Mushroom')]")
    WebElement Mushroom;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Olive')]")
    WebElement Olive;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Basil')]")
    WebElement Basil;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Sweetcorn')]")
    WebElement Sweetcorn;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Onion')]")
    WebElement Onion;
    @FindBy (xpath = "//button[@class='btn toppings-btn'][contains(.,'Tomatoe')]")
    WebElement Tomatoes;

    @FindBy(xpath = "//button[@class='btn order-btn'][contains(.,'Place Order')]")
    WebElement PlaceOrder;

    public void Click_New_Order()
    {
        WebDriverWait details=new WebDriverWait(driver,30);
        details.until(ExpectedConditions.visibilityOf(NewOrder));
        NewOrder.click();
    }
    public void Capture_Customer_Details(String _name,String _email,String _address,String _contact)
    {
        WebDriverWait details=new WebDriverWait(driver,30);
        details.until(ExpectedConditions.visibilityOf(Name));

        Name.sendKeys(_name);
        Email.sendKeys(_email);
        Address.sendKeys(_address);
        Contact_No.sendKeys(_contact);
    }
    public void Choose_Size(String _size) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        if(_size.equalsIgnoreCase("Small"))
        {
            Small.click();
        }else
            if(_size.equalsIgnoreCase("Medium"))
            {
                Medium.click();
            }else
                if(_size.equalsIgnoreCase("Large"))
                {
                    Large.click();
                }
    }
    public void Add_Toppings(String _bacon,String _pepperoni,String _mushroom,String _olive,String _basil,String _sweetcorn,String _onion,String _tomatoe)
    {
        if(_bacon.equalsIgnoreCase("Yes"))
        {
            Bacon.click();
        }
        if(_pepperoni.equalsIgnoreCase("Yes"))
        {
            Pepperoni.click();
        }
        if(_mushroom.equalsIgnoreCase("Yes"))
        {
            Mushroom.click();
        }
        if(_olive.equalsIgnoreCase("Yes"))
        {
            Olive.click();
        }
        if(_basil.equalsIgnoreCase("Yes"))
        {
            Basil.click();
        }
        if(_sweetcorn.equalsIgnoreCase("Yes"))
        {
            Sweetcorn.click();
        }
        if(_onion.equalsIgnoreCase("Yes"))
        {
            Onion.click();
        }
        if(_tomatoe.equalsIgnoreCase("Yes"))
        {
            Tomatoes.click();
        }
    }
    public void Click_Place_Order() throws InterruptedException {
        WebDriverWait details=new WebDriverWait(driver,30);
        details.until(ExpectedConditions.visibilityOf(PlaceOrder));
        PlaceOrder.click();

        TimeUnit.SECONDS.sleep(2);
        driver.switchTo().alert().accept();
    }
}
