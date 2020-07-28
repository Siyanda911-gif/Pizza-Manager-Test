package Test_Functionality;

import com.google.common.base.StandardSystemProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Complete_Order {
    private WebDriver driver;

    public Complete_Order(WebDriver driver)
    {
        this.driver=driver;
    }
    @FindBy (xpath = "//a[@href='/order-status']")
    WebElement Status;

    public void Click_Order_Status() throws InterruptedException {
        WebDriverWait details=new WebDriverWait(driver,30);
        details.until(ExpectedConditions.visibilityOf(Status));
        Status.click();
    }
    public void Accept_And_Mark_As_Complete(String _address) throws InterruptedException {
        List rows = driver.findElements(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div"));

        int position=rows.size();
        String Address = driver.findElement(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div[" + position + "]/div[2]")).getText();
        if(Address.equalsIgnoreCase(_address))
        {
            if(driver.findElements(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div["+position+"]/div[4]/span[1]")).size()!=0)
              {
                  driver.findElement(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div["+position+"]/div[4]/span[1]")).click();

                  TimeUnit.SECONDS.sleep(2);
                  if(driver.findElements(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div["+ position+"]/div[5]")).size()!=0)
                  {
                      driver.findElement(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div["+position+"]/div[5]")).click();
                  }
              }
            }
    }
    public String Get_Order_Status()
    {
        List rows = driver.findElements(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div"));
        int position=rows.size();
        String Status = driver.findElement(By.xpath("/html/body/app-root/section/section/app-order-status/main/section[2]/section/div[" + position + "]/div[4]")).getText();

        return Status;
    }
}
