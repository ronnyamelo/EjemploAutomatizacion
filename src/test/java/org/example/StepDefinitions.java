package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    @FindBy(xpath = "// input [(@type='text' and @id='twotabsearchtextbox') ]")
    private WebElement searchBarTextBox;

    @FindBy(xpath ="// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")
    private WebElement searchBarSubmitButton;

    @FindBy(xpath = "(//* [starts-with (text(), 'Nintendo')])[1]/parent::a")
    private WebElement firstSearchElement;

    @FindBy(xpath = "//input [@type='submit' and@id='add-to-cart-button']")
    private WebElement addToTheCartSubmitButton;

    @FindBy (xpath = "//input [@type='submit' and @data-action-type='DISMISS']/..")
    private WebElement dismissShippingButton;

    @FindBy (xpath = "//div [@role='alertdialog']")
    private WebElement shippingDialogDiv;

    @FindBy (xpath = "//div [@id='nav-logo']/a")
    private WebElement amazonLogo;

    static WebDriver driver = new ChromeDriver();;
    static WebDriverWait  wait = new WebDriverWait(driver,1);
    static String lastArticleAddedName;
    static String addedArticleName;


    @Given("^Un usuario esta registrado y  va al portal de amazon$")
    public void userOpensWebsite() throws Throwable{

        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Un usuario busca un articulo : Nintendo Switch")
    public void unUsuarioBuscaUnArticuloNintendoSwitch() {


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]")).sendKeys("Nintendo Switch");
        driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")).click();
    }

    @And("Un usuario selecciona la primera opcion resultado de la busqueda")
    public void unUsuarioSeleccionaLaPrimeraOpcionResultadoDeLaBusqueda() {
        driver.findElement(By.xpath("(//div[@data-index>=1]/descendant::span[@class='a-price-whole'])[1]/../../../../../../../../../../descendant::a[@class='a-link-normal a-text-normal']")).click();
    }

    @And("Usuario Agrega el articulo al carrito")
    public void usuarioAgregaElArticuloAlCarrito() {

        addedArticleName= driver.findElement(By.xpath("//span [@id='productTitle']")).getText();
        driver.findElement(By.xpath("//input [@type='submit' and@id='add-to-cart-button']")).click();

    }

    @Then("Usuario Va al Carrito")
    public void usuarioVaAlCarrito() {

        driver.findElement(By.xpath("//div[@id='navbar']/descendant:: span [contains(text(), 'Cart')]/../..")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("Se Verifica que el Articulo ha sido Anadido")
    public void usuarioVerificaQueElArticuloHaSidoAnadido() {

        lastArticleAddedName = driver.findElement(By.xpath("(((//form [@id='activeCartViewForm']/div)[2]/div[@data-itemtype='active'] [1]/descendant::li/span)[1]/*/*)[1]")).getText();
        assertEquals (addedArticleName,lastArticleAddedName);
    }


    @Then("Usuario busca un articulo : Super Smash Bros Ultimate")
    public void usuarioBuscaUnArticuloSuperSmashBrosUltimate() {
        driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]")).sendKeys("Super Smash Bros Ultimate");
        driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")).click();
    }

    @And("Usuario selecciona la primera opcion resultado de la busqueda")
    public void usuarioSeleccionaLaPrimeraOpcionResultadoDeLaBusqueda() {
        driver.findElement(By.xpath("(//div[@data-index>=1]/descendant::span[@class='a-price-whole'])[1]/../../../../../../../../../../descendant::a[@class='a-link-normal a-text-normal']")).click();
    }


    @And("Usuario agrega articulo al carrito")
    public void usuarioAgregaArticuloAlCarrito() {
        addedArticleName= driver.findElement(By.xpath("//span [@id='productTitle']")).getText();
        driver.findElement(By.xpath("//input [@type='submit' and@id='add-to-cart-button']")).click();
    }





}
