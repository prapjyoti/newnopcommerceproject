package electronics;


import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ElectronicsTest extends TopMenuTest {
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //1.1 Mouse Hover on “Electronics” Tab
        mouseHover(By.linkText("Electronics"));
        Thread.sleep(1000);
        //1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(500);
        //1.3 Verify the text “Cell phones”
        String expectedMatch = "Cell phones";
        String actualMatch = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("User not Navigate to next Page", expectedMatch, actualMatch);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab
        //2.2 Mouse Hover on “Cell phones” and click
        //2.3 Verify the text “Cell phones”
         this.verifyUserShouldNavigateToCellPhonesPageSuccessfully();

        //2.4 Click on List View Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.master-wrapper-content div.master-column-wrapper div.center-2 div.page.category-page div.page-body div.products-container div.products-wrapper div.product-list div.item-grid div.item-box:nth-child(3) div.product-item div.details h2.product-title > a:nth-child(1)"));
        ////a[contains(text(),'Nokia Lumia 1020')]
        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String expectedProductMatch = "Nokia Lumia 1020";
        String actualProductMatch = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("Text Cell Phones not Match", expectedProductMatch, actualProductMatch);
        Thread.sleep(500);
        //	2.7 Verify the price “$349.00”
        String expectedProductPrice = "$349.00";
        String actualProductPrice = getTextFromElement(By.xpath("//div[@class='product-price']/span"));
        Assert.assertEquals("The Product Price is not match", expectedProductPrice, actualProductPrice);
        Thread.sleep(500);
        //2.8 Change quantity to 2
        clear(By.xpath("//input[@id='product_enteredQuantity_20']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //2.9  Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedProductAdded = "The product has been added to your shopping cart";
        String actualProductAdded = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("The Product Price is not added successfully", expectedProductAdded, actualProductAdded);
        //After that close the bar clicking on the cross button.
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(500);
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHover(By.xpath("//span[text()='Shopping cart']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[text()='Go to cart']"));
        //2.12 Verify the message "Shopping cart"
        String expectedMessage1 = "Shopping cart";
        String actualMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("The Shopping cart message not match", expectedMessage1, actualMessage1);
        Thread.sleep(500);
        //	2.13 Verify the quantity is 2
        String expectedMessage2 = "2";
        String actualMessage2 = getAttributefromelement(By.xpath("//tbody/tr[1]/td[5]/input[1]"),"value");
        Assert.assertEquals("The Shopping cart qty is not match", expectedMessage2, actualMessage2);
        //
       Thread.sleep(500);
        String expectedPrice = "$698.00";
        String actualPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("The Product price is not match", expectedPrice, actualPrice);
        Thread.sleep(500);
     //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(500);
        //2.17 Verify the Text “Welcome, Please Sign In!”
        String expectedText = "Welcome, Please Sign In!";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Sign in message is not verify", expectedText,actualText);
        // 	2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        Thread.sleep(500);
        //verify RegisterTab
        String expectedTextVerify = "Register";
        String actualTextVerify = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals("Sign in message is not verify", expectedTextVerify,actualTextVerify);
     //2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        //first name
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Linda");
        Thread.sleep(1000);
        //last name
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Davies");
        Thread.sleep(1000);
        //email use random method as not use random email every run
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='Email']"),"linda" + randomInt + "@gmail.com" );
        Thread.sleep(1000);
        //password
       sendTextToElement(By.xpath("//input[@id='Password']"),"Lin123");
       Thread.sleep(1000);
       //confirmed password
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"),"Lin123");
        Thread.sleep(1000);
        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(1000);
        //2.22 Verify the message “Your registration completed”
        String expectedRegisterMessage = "Your registration completed";
        String actualRegisterMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your Registration is not completed", expectedRegisterMessage,actualRegisterMessage);
        //2.23 click on continue
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(500);
        //2.24 verify message shopping cart
        String expectedShoppingText = "Shopping cart";
        String actualShoppingText = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Your Registration is not completed", expectedShoppingText,actualShoppingText);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        Thread.sleep(500);
        //	2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(500);
        //	2.27 Fill the Mandatory fields
        clear(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Linda");
        Thread.sleep(500);
        clear(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Davies");
        Thread.sleep(500);
        clear(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "linda" + randomInt + "@gmail.com");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "11,Eagle Avenue");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA0 1TR");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07544565698");
        Thread.sleep(500);
        //	2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        //	2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //2.31[1] click continue
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 0);
        //2.33 Fill all the details
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Linda Davies");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4485873901194403");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "2");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2024");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "733");
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.31 Verify “Payment Method” is “Credit Card”
        Thread.sleep(2000);
        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedPaymentType = "Credit Card";
        String actualPaymentType = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment Method” is not “Credit Card”",expectedPaymentType,actualPaymentType);
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedDelivery = "2nd Day Air";
        String actualDelivery = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air') and @class='value']"));
        Assert.assertEquals("Product Delivery options is not match",expectedDelivery,actualDelivery);
        //	2.37 Verify Total is “$698.00”
        String expectedPrice1 = "$698.00";
        String actualPrice2 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Product Price is not match",expectedPrice1,actualPrice2);
        //	2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //	2.39 Verify the Text “Thank You”
        String expectedGratefulMessage = "Thank you";
        String actualGratefulMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Appreciation message is not match", expectedGratefulMessage, actualGratefulMessage);
        //	2.40 Verify the message “Your order has been successfully processed!”
        String expectedOrderText = "Your order has been successfully processed!";
        String actualOrderText= getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Appreciation message is not match", expectedOrderText,actualOrderText);
        //	2.41 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.42 Verify the text “Welcome to our store”
        Thread.sleep(500);
        String expectedGreeting = "Welcome to our store";
        String actualGreeting = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Greet message appear successfully", expectedGreeting, actualGreeting);
        //2.43 Click on “Logout” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch",expectedUrl,actualUrl);




    }


}



