package org.pjatk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Chrome {

    @Test
    public void scenarioOne() {
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


}
