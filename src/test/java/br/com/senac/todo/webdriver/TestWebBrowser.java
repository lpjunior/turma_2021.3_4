package br.com.senac.todo.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

public class TestWebBrowser {

    private WebDriver driver;
    private WebElement searchBox;
    private WebElement searchResults;

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

        assertTrue(searchResults.isDisplayed());
        assertThat(driver.getTitle().startsWith("Senac Rio"));
    }
}
