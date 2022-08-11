package br.com.senac.todo.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestWebBrowser {

    private WebDriver driver;
    private WebElement searchBox;
    private WebElement searchButton;
    private WebElement searchResults;

    private Actions actions;

    @BeforeEach
    void openBrowser() {
        WebDriverManager.chromedriver().setup(); // coloca de forma automatica o driver correto do navegador
        driver = new ChromeDriver(); // inicia o Google Chrome (abre o browser)
    }

    @AfterEach
    void closeBrowser() {
        //driver.quit(); // encerra(fecha) o Google Chrome
    }

    @Test
    void seach(){
        driver.get("https://www.google.com.br");

        // solicitação
        searchBox = driver.findElement(By.cssSelector("[name='q']")); // definir a query string
        searchBox.sendKeys("Senac RJ"); // adiciona o valor de busca no input

        driver.manage().window().maximize(); // maximiza a página (expande)
        searchBox.submit(); // submete(envia) o formulario de pesquisa

        // resultado
        searchResults = driver.findElement(By.cssSelector("#search"));

        System.out.println("driver.findElement(By.tagName(\"title\")) = " + driver.findElement(By.tagName("title")));
        assertTrue(searchResults.isDisplayed());
        assertThat(driver.getTitle().startsWith("Senac Rio"));
    }

    @Test
    void searchClass() {
        driver.get("https://www.rj.senac.br");

        searchButton = driver.findElement(By.id("bt-opensearch"));

        actions = new Actions(driver);
        actions.moveToElement(searchButton).click().perform();

        searchBox = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS)).until(ExpectedConditions.elementToBeClickable(By.id("search-field")));
        searchBox.sendKeys("Técnico em informática");
        searchBox.submit();

        searchButton = driver.findElement(By.className("thumb-busca"));
        actions.moveToElement(searchButton).click().perform();

        var turma = driver.findElement(By.cssSelector("h1[class='fw-bold color-2-1 flt-left']")).getText();

        assertEquals("Turma 2022.3", turma);
    }
}
