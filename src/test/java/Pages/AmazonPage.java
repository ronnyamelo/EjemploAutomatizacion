package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    static WebDriver driver;



    @FindBy(xpath = "// input [(@type='text' and @id='twotabsearchtextbox') ]")
    private WebElement searchBarTextBox;

    @FindBy(xpath ="// input [(@type='text' and @id='twotabsearchtextbox') ]/../../../div[3]/*/*/*")
    private WebElement searchBarSubmitButton;

    @FindBy(xpath = "(//div[@data-index>=1]/descendant::span[@class='a-price-whole'])[1]/../../../../../../../../../../../descendant::a[@class='a-link-normal a-text-normal']")

    private WebElement firstSearchElement;

    @FindBy(xpath = "//input [@type='submit' and@id='add-to-cart-button']")
    private WebElement addToTheCartSubmitButton;

    @FindBy(xpath ="//span [@id='productTitle']")
    private WebElement articleProductName;


    @FindBy (xpath = "//input [@type='submit' and@id='add-to-cart-button']")
    private WebElement addtoCartButton;

    @FindBy (xpath = "//div[@id='navbar']/descendant:: span [contains(text(), 'Cart')]/../..")
    private WebElement cartButton;

    @FindBy (xpath = "(((//form [@id='activeCartViewForm']/div)[2]/div[@data-itemtype='active'] [1]/descendant::li/span)[1]/*/*)[1]")
    private WebElement cartLastAddedArticle;

    @FindBy (xpath = "//input [@type='submit' and @data-action-type='DISMISS']/..")
    private WebElement dismissShippingButton;

    @FindBy (xpath = "//div [@role='alertdialog']")
    private WebElement shippingDialogDiv;

    @FindBy (xpath = "//div [@id='nav-logo']/a")
    private WebElement amazonLogo;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void buscarArticulo(String articulo){
        searchBarTextBox.sendKeys(articulo);
        searchBarSubmitButton.click();
    }

    public String  seleccionarPrimerArticulo() {
        firstSearchElement.click();
        return articleProductName.getText();
    }

    public void agregarArticuloAlCarrito() {
        addtoCartButton.click();
    }

    public void irAlCarrito() {
        cartButton.click();
    }

    public String obtenerUltimoArticuloAnadido() {
        return cartLastAddedArticle.getText();
    }
}
