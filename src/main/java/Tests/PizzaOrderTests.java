package Tests;

import Setup.Setup_Class;
import Test_Functionality.*;
import Test_Helpers.Pizza_Report;
import Test_Helpers.Random_Address;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import javax.naming.ldap.Control;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PizzaOrderTests extends Pizza_Report {

    private WebDriver driver = Setup_Class.startBrowserOfChoice("http://localhost:4200/", "chrome");
    private static String dir = System.getProperty("user.dir");
    private static final String excel = dir + "/src/main/java/Test_Data/Pizza.xlsx";
    private FileInputStream fis = new FileInputStream(excel);
    private XSSFWorkbook workbook = new XSSFWorkbook(fis);

    private XSSFSheet sheet = workbook.getSheetAt(0);
    private int data_Length = sheet.getLastRowNum();

    public PizzaOrderTests() throws IOException, InterruptedException {
    }

    @Test(description = "This Test Will order a Pizza online and complete it")
    public void Order_Pizza_Online() throws InterruptedException {
        for (int i = 1; i <= data_Length; i++) {

            String Name=sheet.getRow(i).getCell(0).getStringCellValue();
            String Email=sheet.getRow(i).getCell(1).getStringCellValue();
            String Address=sheet.getRow(i).getCell(2).getStringCellValue();
            Random_Address address=new Random_Address();
            Address =address.getRandomAddress()+" Commissioner Street " + Address;
            String ContactNo=sheet.getRow(i).getCell(3).getStringCellValue();
            String PizzaSize=sheet.getRow(i).getCell(4).getStringCellValue();
            String Bacon=sheet.getRow(i).getCell(5).getStringCellValue();
            String Pepperoni=sheet.getRow(i).getCell(6).getStringCellValue();
            String Mushroom=sheet.getRow(i).getCell(7).getStringCellValue();
            String Olive=sheet.getRow(i).getCell(8).getStringCellValue();
            String Basil=sheet.getRow(i).getCell(9).getStringCellValue();
            String Sweetcorn=sheet.getRow(i).getCell(10).getStringCellValue();
            String Onion=sheet.getRow(i).getCell(11).getStringCellValue();
            String Tomatoes=sheet.getRow(i).getCell(12).getStringCellValue();
            test = extent.createTest("Order Pizza Online Report");
            test.log(Status.PASS, "Click New Order");
            Place_Pizza_Order order=PageFactory.initElements(driver,Place_Pizza_Order.class);
            Complete_Order complete_order=PageFactory.initElements(driver,Complete_Order.class);
            order.Click_New_Order();
            test.log(Status.PASS, "Order Details");
            test.log(Status.PASS, "Name " +Name);
            test.log(Status.PASS, "Email "+Email);
            test.log(Status.PASS, "Address "+Address);
            test.log(Status.PASS, "Contact No "+ ContactNo);
            order.Capture_Customer_Details(Name,Email,Address,ContactNo);
            test.log(Status.PASS, "Pizza Size " + PizzaSize);
            order.Choose_Size(PizzaSize);
            test.log(Status.PASS, "Toppings Choice");
            test.log(Status.PASS, "Bacon " + Bacon);
            test.log(Status.PASS, "Pepperoni " + Pepperoni);
            test.log(Status.PASS, "Mushroom " + Mushroom);
            test.log(Status.PASS, "Olive " + Olive);
            test.log(Status.PASS, "Basil " + Basil);
            test.log(Status.PASS, "Sweetcorn " + Sweetcorn);
            test.log(Status.PASS, "Onion " + Onion);
            test.log(Status.PASS, "Tomatoes " + Tomatoes);
            order.Add_Toppings(Bacon,Pepperoni,Mushroom,Olive,Basil,Sweetcorn,Onion,Tomatoes);
            test.log(Status.PASS, "Click To Place Order");
            order.Click_Place_Order();

            TimeUnit.SECONDS.sleep(5);
            test.log(Status.PASS, "Click Order Status");
            complete_order.Click_Order_Status();
            test.log(Status.PASS, "Accept Order And Mark As Complete");
            complete_order.Accept_And_Mark_As_Complete(Address);
            Assert.assertEquals(complete_order.Get_Order_Status(),"Completed");
        }
    }
    @AfterTest
    public void quit()
    {
        driver.quit();
    }
}
