package computer;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestSuit extends TopMenuTest {

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));//1.1.Test name verifyProductArrangeInAlphaBaticalOrder()
        Thread.sleep(2000);
        clickOnElement(By.linkText("Desktops"));
        //selectByValueFromDropDown(By.xpath("//select[@id='products-orderby']"),"Name:ZtoA");
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 2);

        //1.4 Verify the Product will arrange in Descending order.
        String expectedMessage = "Name: Z to A";
        Thread.sleep(3000);
        String actualMessage = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Name:Z to A is not arranging in Descending order.", expectedMessage, actualMessage);

    }

    // Test name verifyProductAddedToShoppingCartSuccessFully()
    //2.1 Click on Computer Menu.
    @Test
    public void verifytheProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        clickOnElement(By.linkText("Computers"));
        Thread.sleep(3000);
        //2.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));
        //	2.3 Select Sort By position "Name: A to Z"
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 1);
        //2.4 2.4 Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));
        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));
        Assert.assertEquals("User not navigate to next page", expectedMessage, actualMessage);
        // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"), 1);
        //Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_3']//label[text()='400 GB [+$100.00]']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        Thread.sleep(1000);
        // 2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12' and @ name='product_attribute_5']"));
        //2.11 Verify the price "$1,475.00"
        String expectedMessage1 = "$1,475.00";
        String actualMessage1 = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals("Price did not match with actual price", expectedMessage1, actualMessage1);
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(500);
        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));
        Assert.assertEquals("Product not added to the cart", expectedMessage2, actualMessage2);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[text()='Shopping cart']"));
        clickOnElement(By.xpath("//button[text()='Go to cart']"));
        //2.15 Verify the message "Shopping cart"
        String expectedMessage3 = "Shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("The Shopping cart message not match", expectedMessage3, actualMessage3);
        // Change the Qty to "2" and Click on "Update shopping cart"
        clear(By.xpath("//input[@class='qty-input']"));
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        //Verify the Total"$2,950.00"
        Thread.sleep(500);
        String expectedMessage4 = "$2,950.00";
        String actualMessage4 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Toal Price is not Match", expectedMessage4, actualMessage4);
        //click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(500);
        // Verify the Text “Welcome, Please Sign In!”
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Sign in message is not verify", expectedMessage5, actualMessage5);
        //Click on “CHECKOUT AS GUEST” Tab
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[text()='Checkout as Guest']"));
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Monica");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Brown");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "monicabrown@yahoo.com");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "11,Fernbank Avenue");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA0 2TR");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07544565725");
        Thread.sleep(500);
        //Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));
        // Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));
        Thread.sleep(1000);
        // Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        Thread.sleep(500);
        //Fill all the details
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 1);
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Monica Brown");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5530144852132251");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "5");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "963");
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.31 Verify “Payment Method” is “Credit Card”
        Thread.sleep(2000);
        String expectedMessage6 = "Credit Card";
        String actualMessage6 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment Method” is not “Credit Card”", expectedMessage6, actualMessage6);
        //2.32 Verify “Shipping Method” is “Next Day Air”
        Thread.sleep(1000);
        String expectedshipping = "Next Day Air";
        String actualshipping = getTextFromElement(By.xpath("//span[contains(text(),'Next Day Air') and @class='value']"));
        Assert.assertEquals("Shipping method is not match", expectedshipping, actualshipping);
        Thread.sleep(1000);
        //2.33 Verify Total is “$2,950.00”
        String expectedTotalPrice = "$2,950.00";
        String actualTotalprice = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total Price is not match", expectedTotalPrice, actualTotalprice);
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        String expectedGrateful = "Thank you";
        String actualGrateful = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Appreciation message is not match", expectedGrateful, actualGrateful);
        //Verify the message “Your order has been successfully processed!”
        String expectedOrder = "Your order has been successfully processed!";
        String actualorder = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Appreciation message is not match", expectedOrder, actualorder);
        //2.37 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.38 Verify the text “Welcome to our store”
        Thread.sleep(500);
        String expectedGreet = "Welcome to our store";
        String actualGreet = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Greet message appear successfully", expectedGreet, actualGreet);


    }

}
