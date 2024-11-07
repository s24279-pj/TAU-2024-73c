package org.pjatk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Chrome {

    @Test
    public void trojmiasto() {
        WebDriver webDriver = new ChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriver.get("https://www.trojmiasto.pl/");

            String pageTitle = webDriver.getTitle();
            // 1
            Assertions.assertEquals("Trojmiasto.pl - wiadomości i informacje z Trójmiasta.", pageTitle);

            WebElement news = webDriver.findElement(By.xpath("//a[text()='Wiadomości']"));
            news.click();

            wait.until(ExpectedConditions.urlToBe("https://www.trojmiasto.pl/wiadomosci/"));

            String currentUrl = webDriver.getCurrentUrl();
            // 2
            Assertions.assertEquals("https://www.trojmiasto.pl/wiadomosci/", currentUrl);

            WebElement cookieAccept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cky-btn-accept")));
            // 3
            Assertions.assertTrue(cookieAccept.isDisplayed());
            cookieAccept.click();

            WebElement firstArticleLink = webDriver.findElement(By.xpath("(//article//a)[1]"));
            firstArticleLink.click();

            WebElement articleTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("newsHeader__title")));
            // 4
            Assertions.assertTrue(articleTitle.isDisplayed());

            WebElement articleAuthor = webDriver.findElement(By.className("newsHeader__author"));
            // 5
            Assertions.assertTrue(articleAuthor.isDisplayed());

            WebElement opinionsButton = webDriver.findElement(By.xpath("//div[@class='newsHeader__opinions']//button"));
            //6
            Assertions.assertTrue(opinionsButton.isDisplayed());

            WebElement addOpinion = webDriver.findElement(By.className("Opinions__add"));
            //7
            Assertions.assertEquals("Dodaj opinię", addOpinion.getAccessibleName());

            WebElement opinionForm = webDriver.findElement(By.className("Opinions__form"));
            String displayValue = opinionForm.getCssValue("display");
            // 8
            Assertions.assertEquals("none", displayValue);

        } finally {
            webDriver.quit();
        }
    }

    @Test
    public void supersklep() {
        WebDriver webDriver = new ChromeDriver();


        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriver.get("https://supersklep.pl/");

            String pageTitle = webDriver.getTitle();
            // 1
            Assertions.assertEquals("Sklep skateboardowy, snowboardowy, ze sneakersami i ubraniami streetwear | SUPERSKLEP", pageTitle);

            WebElement cookieBannerAccept = webDriver.findElement(By.className("privacy-confirm-button"));
            // 2
            Assertions.assertTrue(cookieBannerAccept.isDisplayed());
            cookieBannerAccept.click();

            WebElement languageSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("popup")));
            WebElement dropdownLanguage = languageSelection.findElement(By.className("dropdown_option"));
            dropdownLanguage.click();

            WebElement languageOption = webDriver.findElement(By.cssSelector("div[data-id='pl']"));

            // 3
            Assertions.assertTrue(languageOption.isDisplayed());
            languageOption.click();

            WebElement languageText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-id='pl'] span")));
            // 4
            Assertions.assertEquals("Polski/PLN", languageText.getText());

            WebElement acceptLanguage = webDriver.findElement(By.className("btn-next"));
            acceptLanguage.click();

            WebElement snowboardShopSection = webDriver.findElement(By.cssSelector("a[title='Snowboard shop']"));
            snowboardShopSection.click();
            wait.until(ExpectedConditions.urlToBe("https://supersklep.pl/snowboard"));

            WebElement glovesCategory = webDriver.findElement(By.cssSelector("a[title='Rękawice snowboardowe']"));
            glovesCategory.click();
            wait.until(ExpectedConditions.urlToBe("https://supersklep.pl/rekawice-snowboardowe"));

            WebElement product = webDriver.findElement(By.className("cvn-product"));
            product.click();

            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.id("addToCartBtn")));

            // 5
            Assertions.assertTrue(addToCart.isDisplayed());
            addToCart.click();

            WebElement chooseProduct = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-default")));
            chooseProduct.click();

            WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.id("asideBasket")));
            // 6
            Assertions.assertTrue(cart.isDisplayed());

            WebElement itemsQuantity = webDriver.findElement(By.className("products-quantity"));
            // 7
            Assertions.assertEquals(itemsQuantity.getText(), "Produkty w koszyku (1)");

            WebElement deleteButton = webDriver.findElement(By.className("btn-delete"));
            // 8
            Assertions.assertTrue(deleteButton.isDisplayed());
            deleteButton.click();
            // 9
            Assertions.assertEquals(itemsQuantity.getText(), "Produkty w koszyku (0)");

        } finally {
            webDriver.quit();
        }
    }

    @Test
    public void olx() {
        WebDriver webDriver = new ChromeDriver();

        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            webDriver.get("https://olx.pl/");

            String pageTitle = webDriver.getTitle();
            // 1
            Assertions.assertEquals("Ogłoszenia - Sprzedam, kupię na OLX.pl", pageTitle);

            WebElement cookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("onetrust-policy")));
            // 2
            Assertions.assertTrue(cookieBanner.isDisplayed());

            WebElement cookieBannerAccept = webDriver.findElement(By.id("onetrust-accept-btn-handler"));
            cookieBannerAccept.click();

            // 3
            Assertions.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-policy"))));

            WebElement categoriesSection = webDriver.findElement(By.className("css-1i7rc0q"));
            // 4
            Assertions.assertTrue(categoriesSection.isDisplayed());

            WebElement searchSection = webDriver.findElement(By.className("css-1hf80wu"));
            // 5
            Assertions.assertTrue(searchSection.isDisplayed());

            WebElement promotedSection = webDriver.findElement(By.className("css-uhv1v6"));
            // 6
            Assertions.assertTrue(promotedSection.isDisplayed());

            WebElement yourAccount = webDriver.findElement(By.className("css-12l1k7f"));
            yourAccount.click();

            WebElement loginSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1iyoj2o")));
            // 7
            Assertions.assertTrue(loginSection.isDisplayed());

            List<WebElement> loginButtons = webDriver.findElements(By.className("css-17pvrqn"));
            // 8
            Assertions.assertEquals(3, loginButtons.size());


        } finally {
            webDriver.quit();
        }
    }


}
