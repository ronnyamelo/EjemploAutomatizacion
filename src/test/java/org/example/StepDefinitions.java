package org.example;

import Pages.AmazonPage;
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


    static WebDriver driver = new ChromeDriver();
    static WebDriverWait  wait = new WebDriverWait(driver,1);
    static String lastArticleAddedName;
    static String addedArticleName;
    static AmazonPage page;


    @Given("^Un usuario esta registrado y  va al portal de amazon$")
    public void userOpensWebsite() throws Throwable{

        String PATHDRIVER = "src/test/resources/drivers/";
        System.setProperty("webdriver.chrome.driver", PATHDRIVER+"chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
        page = new AmazonPage(driver);

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

        page.buscarArticulo("Nintendo Switch");
        //driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]")).sendKeys("Nintendo Switch");
        //driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")).click();
    }

    @And("Un usuario selecciona la primera opcion resultado de la busqueda")
    public void unUsuarioSeleccionaLaPrimeraOpcionResultadoDeLaBusqueda() {

        addedArticleName=  page.seleccionarPrimerArticulo();
       // driver.findElement(By.xpath("(//div[@data-index>=1]/descendant::span[@class='a-price-whole'])[1]/../../../../../../../../../../descendant::a[@class='a-link-normal a-text-normal']")).click();
    }

    @And("Usuario Agrega el articulo al carrito")
    public void usuarioAgregaElArticuloAlCarrito() {

        page.agregarArticuloAlCarrito();
       // driver.findElement(By.xpath("//input [@type='submit' and@id='add-to-cart-button']")).click();

    }

    @Then("Usuario Va al Carrito")
    public void usuarioVaAlCarrito() {

        page.irAlCarrito();
        //driver.findElement(By.xpath("//div[@id='navbar']/descendant:: span [contains(text(), 'Cart')]/../..")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("Se Verifica que el Articulo ha sido Anadido")
    public void usuarioVerificaQueElArticuloHaSidoAnadido() {

        lastArticleAddedName =  page.obtenerUltimoArticuloAnadido();
        //driver.findElement(By.xpath("(((//form [@id='activeCartViewForm']/div)[2]/div[@data-itemtype='active'] [1]/descendant::li/span)[1]/*/*)[1]")).getText();
        assertEquals (addedArticleName,lastArticleAddedName);
    }


    @Then("Usuario busca un articulo : Super Smash Bros Ultimate")
    public void usuarioBuscaUnArticuloSuperSmashBrosUltimate() {
        page.buscarArticulo("Super Smash Bros Ultimate");
        //driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]")).sendKeys("Super Smash Bros Ultimate");
        //driver.findElement(By.xpath("// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")).click();
    }
    

    @And("Usuario agrega articulo al carrito")
    public void usuarioAgregaArticuloAlCarrito() {
        page.agregarArticuloAlCarrito();
        //addedArticleName= driver.findElement(By.xpath("//span [@id='productTitle']")).getText();
        //driver.findElement(By.xpath("//input [@type='submit' and@id='add-to-cart-button']")).click();
    }





}
