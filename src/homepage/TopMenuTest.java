package homepage;

import browsertesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        // clickOnElement(By.xpath("//div[@class='header-menu']/ul[1]/li/a"));
        clickOnElement(By.linkText("Computers"));
        clickOnElement(By.linkText("Electronics"));
        clickOnElement(By.linkText("Apparel"));
        clickOnElement(By.linkText("Digital downloads"));
        clickOnElement(By.linkText("Books"));
        clickOnElement(By.linkText("Jewelry"));
        clickOnElement(By.linkText("Gift Cards"));

    }

    @Test
    public void verifyPageNavigation() {
        selectMenu("Computers");
        String expectedMessage = "Computers";
        String actualMessage = getTextFromElement(By.partialLinkText("Computers"));
        Assert.assertEquals("User not Navigate to Page + ", expectedMessage, actualMessage);
    }

    @Test
    public void verifyPageElectronicsNavigation() throws InterruptedException {
        selectMenu("Electronics");
        String expectedMessage1 = "Electronics";
        Thread.sleep(500);
        String actualMessage1 = getTextFromElement(By.partialLinkText("Electronics"));
        Assert.assertEquals("User not Navigate to Page + ", expectedMessage1, actualMessage1);

    }

    @Test
    public void verifyPageApparelNavigation() {
        selectMenu("Apparel");
        String expectedMessage = "Apparel";
        String actualMessage = getTextFromElement(By.partialLinkText("Apparel"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);

    }

    @Test
    public void verifyDigitalDownloadsPageNavigate() {
        selectMenu("Digital downloads");
        String expectedMessage = "Digital downloads";
        String actualMessage = getTextFromElement(By.partialLinkText("Digital downloads"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);

        ////h1[contains(text(),'Digital downloads')]
    }

    @Test
    public void verifyBooksNavigate() {
        selectMenu("Books");
        String expectedMessage = "Books";
        String actualMessage = getTextFromElement(By.partialLinkText("Books"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);

        ////h1[contains(text(),'Books')]
    }

    @Test
    public void verifyJewelryNavigate() {
        selectMenu("Jewelry");
        String expectedMessage = "Jewelry";
        String actualMessage = getTextFromElement(By.partialLinkText("Jewelry"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);
        ////h1[contains(text(),'Jewelry')]

    }

    @Test
    public void verifyGiftNavigate() {
        selectMenu("Gift Cards");
        String expectedMessage = "Gift Cards";
        String actualMessage = getTextFromElement(By.partialLinkText("Gift Cards"));
        Assert.assertEquals("User not Navigate to Page+", expectedMessage, actualMessage);

        ////h1[contains(text(),'Gift Cards')]
    }
    /*public void closeBrowser(){
        driver.quit();
    }*/
}
