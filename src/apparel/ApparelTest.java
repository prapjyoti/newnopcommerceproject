package apparel;

import homepage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ApparelTest extends TopMenuTest {
    @Test
    public void verifyUserShouldNavigateToAccessoriesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Accessories” Tab
        Thread.sleep(500);
        mouseHover(By.linkText("Apparel"));
        Thread.sleep(1000);
        //1.2 Mouse Hover on “Accessories” and click
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]"));
        Thread.sleep(500);
        //1.3 verify the Accessories
        String expectedText = "Accessories";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Accessories')]"));
        Assert.assertEquals("User not Navigate to Accessories Page", expectedText, actualText);

    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //1.4 register
        Thread.sleep(1000);
        mouseHover(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        Thread.sleep(500);
        String expectedverificationMessage = "Register";
        Thread.sleep(2000);
        String actualVerificationMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(" User not registered successfully", expectedverificationMessage, actualVerificationMessage);
        Thread.sleep(1000);
        // 1.5 fill mandetry field
        //first name
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Lola");
        Thread.sleep(1000);
        //last name
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Spencer");
        Thread.sleep(1000);
        //email use random method as not use random email every run
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='Email']"), "lola" + randomInt + "@gmail.com");
        Thread.sleep(1000);
        //password
        sendTextToElement(By.xpath("//input[@id='Password']"), "Lola123");
        Thread.sleep(1000);
        //confirmed password
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "Lola123");
        Thread.sleep(1000);
        // 1.6. Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));
        Thread.sleep(1000);
        //1.7. Verify the message “Your registration completed”
        String expectedRegisterMessage = "Your registration completed";
        String actualRegisterMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Your Registration is not completed", expectedRegisterMessage, actualRegisterMessage);
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //1.8 click on continue

         /*Login as existing user
        1.1  Mouse Hover on “Accessories” Tab
        1.2  Mouse Hover on “Accessories” and click
        1.3  verify the Accessories
         */
        Thread.sleep(500);
        this.verifyUserShouldNavigateToAccessoriesPageSuccessfully();//Method called by current object

        // 1.9  verify the list view Tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        //1.10 click on product name "Obey Propaganda Hat" link
        clickOnElement(By.linkText("Obey Propaganda Hat"));
        Thread.sleep(1000);
        //1.11  verify the text Obey Propaganda Hat
        String expectedResult = "Obey Propaganda Hat";
        String actualResult = getTextFromElement(By.xpath("//h1[contains(text(),'Obey Propaganda Hat')]"));
        Assert.assertEquals("User not Navigate to obey Propaganda Page", expectedResult, actualResult);
        //1.12 select the size
        Thread.sleep(1000);
        selectByIndexFromDropDown(By.cssSelector("#product_attribute_13"), 2);
        Thread.sleep(500);
        //1.13 click on  add cart
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-31' and @class='button-1 add-to-cart-button']"));
        //1.14 verify the message
        String expectedProduct = "The product has been added to your shopping cart";
        String actualProduct = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("The Product Price is not added successfully", expectedProduct, actualProduct);
        //After that close the bar clicking on the cross button.
        Thread.sleep(500);
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(500);
        //1.15 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHover(By.xpath("//span[text()='Shopping cart']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[text()='Go to cart']"));
        //1.16 verify the message
        String expectedBasket = "Shopping cart";
        String actualBasket = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("The Shopping cart message not match", expectedBasket, actualBasket);
        Thread.sleep(500);
        //1.17  Change quantity  the qty and update to  5
        clear(By.xpath("//tbody/tr[1]/td[5]/input[1]"));
        Thread.sleep(500);
        sendTextToElement(By.xpath("//tbody/tr[1]/td[5]/input[1]"), "5");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));
        //1.18 verify the total
        String expectedPrice1 = "$150.00";
        String actualPrice1 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        Assert.assertEquals("The Product price is not match", expectedPrice1, actualPrice1);
        Thread.sleep(500);
        //1.19 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //1.20 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //1.21 verify the message
        Thread.sleep(500);
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Sign in message is not verify", expectedWelcome, actualWelcome);
        //1.22 Enter details for existing user

        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "lola" + randomInt + "@gmail.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "Lola123");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //1.23 Click on “CHECKOUT”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='checkout']"));
//1.24 shipping address field
        clear(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "Lola");
        Thread.sleep(500);
        clear(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Spencer");
        Thread.sleep(500);
        clear(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "lola" + randomInt + "@gmail.com");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "16,Eagle Avenue");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA0 1TR");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07544565698");
        Thread.sleep(500);
        //	1.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        //	1.26 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        //1.27 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //1.28 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        //1.28[1] click continue
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        //1.29 Select “Amex” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 3);
        //1.30  field  Payment card details
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Lola Spencer");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "378242201620236");
        Thread.sleep(1000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "5");
        Thread.sleep(500);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2022");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "141");
        //1.31 click on continue
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);
        //1.32 Verify “Payment Method” is “Credit Card”
        String expectedPaymentType = "Credit Card";
        String actualPaymentType = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment Method” is not “Credit Card”", expectedPaymentType, actualPaymentType);
        //1.33 Verify “Shipping Method” is “2nd Day Air”
        String expectedDelivery = "2nd Day Air";
        String actualDelivery = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air') and @class='value']"));
        Assert.assertEquals("Product Delivery options is not match", expectedDelivery, actualDelivery);
        //1.34 Verify Total is “$150.00”
        String expectedTotalPrice1 = "$150.00";
        String actualTotalPrice1 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Product Price is not match", expectedTotalPrice1, actualTotalPrice1);
        //1.35 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //1.36Verify the Text “Thank You”
        String expectedGratefulMessage1 = "Thank you";
        String actualGratefulMessage1 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Appreciation message is not match", expectedGratefulMessage1, actualGratefulMessage1);
        //1.37  Verify the message “Your order has been successfully processed!”
        String expectedOrderText1 = "Your order has been successfully processed!";
        String actualOrderText1 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Appreciation message is not match", expectedOrderText1, actualOrderText1);
        //1.38 Click on “CONTINUE”
        Thread.sleep(500);
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //1.39 Verify the text “Welcome to our store”
        Thread.sleep(500);
        String expectedGreeting = "Welcome to our store";
        String actualGreeting = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Greet message not appear successfully", expectedGreeting, actualGreeting);
        //1.40 Click on “Logout” link
        Thread.sleep(500);
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));
        //1.41 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedUrl = "https://demo.nopcommerce.com/";
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch", expectedUrl, actualUrl);

    }

}
