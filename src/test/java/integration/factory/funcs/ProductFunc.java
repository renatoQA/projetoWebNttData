package integration.factory.funcs;

import integration.factory.database.DBConfig;
import integration.factory.pages.ProductPage;
import integration.factory.web.common.BaseTest;
import integration.factory.web.enums.Color;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductFunc extends BaseTest {

    ProductPage productPage = new ProductPage(driver);
    DBConfig dbConfig = new DBConfig();

    private static final double REGEX = 1e-15;


     /*
        Metodo responsavel por realizar o get da informação do objeto empecificado "item" e retornar
        para fazer o comparativo
      */
    public String getItem(String item) throws ClassNotFoundException, SQLException {

        switch (item) {
            case "nameProduct": {
                return productPage.getNomeProduto().getText();
            }
            case "customization": {
                return productPage.getCustomization().getText();
            }
            case "display": {
               return productPage.getDisplay().getText();
            }
            case "displayResolution": {
                return productPage.getDisplayResolution().getText();
            }
            case "displaySize": {
                return productPage.getDisplaySize().getText();
            }
            case "memory": {
                return productPage.getMemory().getText();
            }
            case "operatingSystem": {
                return productPage.getOperatingSystem().getText();
            }
            case "processor": {
                return productPage.getProcessor().getText();
            }
            case "touchscreen": {
                return productPage.getTouchscreen().getText();
            }
            case "weight": {
                return productPage.getWeight().getText();
            }
            case "color": {
                String colorDB = dbConfig.validaCampos().get("color");
                return colorDB.equals("BLUE")? productPage.getColorBlue().getAttribute("title").toString()
                        : colorDB.equals("BLACK")? productPage.getColorBlack().getAttribute("title").toString()
                        : colorDB.equals("RED")? productPage.getColorRed().getAttribute("title").toString()
                        : colorDB.equals("PURPLE")? productPage.getColorPurple().getAttribute("title").toString()
                        : colorDB.equals("GRAY")? productPage.getColorGray().getAttribute("title").toString()
                        : productPage.getColorYellow().getAttribute("title").toString();
            }
            default: {
                return null;
            }
        }
    }
    public void clicarAddToCart(){
        productPage.getAddToCartButton().isEnabled();
        productPage.getAddToCartButton().click();
    }
    public String alteraCorIgualBanco(String Cor){
        productPage.getCorIgual(Cor).click();
        return productPage.getCorIgual(Cor).getText();
    }
    public boolean validaProdutoCarrinho(){
        if(productPage.getValidaProdutoCarrinho().isEnabled()){
            return true;
        }else
            return false;
    }
    public void clicaMaisQuantidade(Integer Quantidade){
        for(int x=1;x<Quantidade; x++){
            productPage.getBtnMaisQuantidade().click();
        }
    }
    public void acessarCheckout(){
        productPage.getBtnPopUpFinalize().isEnabled();
        productPage.getBtnPopUpFinalize().click();
    }
    public void validarTotal() throws InterruptedException {

        double valorUnidade = Double.parseDouble(productPage.getBtnValorDaUnidade().getText().substring(1,7));

        productPage.getBtnShoppingCart().click();
        Thread.sleep(2000);

        int valorQuantidade = Integer.parseInt(productPage.getBtnQuantidadeTotal().getText());

        productPage.getBtnCheckout().click();

        double valorTotal = Double.parseDouble(productPage.getSpanValorTotal().getText().replace(",", "").substring(1,8));

        Assert.assertEquals(valorTotal, valorQuantidade * valorUnidade ,REGEX);
    }
    public Color enumCor() {

        List<Color> colors = Arrays.asList(Color.values());

        int size = colors.size();
        Random random = new Random();
        var cor = colors.get(random.nextInt(size));
        return cor;
    }
    /*
      Método responsavel por selecionar o objeto da cor passada e navegar pelas opções do enum Color.
     */
    public void selecionarCor(Color color) {
        switch (color) {
            case BLUE:{
                productPage.getColorBlue().click();
                break;
            }
            case BLACK: {
                productPage.getColorBlack().click();
                break;

            }
            case GRAY: {
                productPage.getColorGray().click();
                break;

            }
            case PURPLE: {
                productPage.getColorPurple().click();
                break;

            }
            case RED: {
                productPage.getColorRed().click();
                break;

            }
            case YELLOW: {
                productPage.getColorYellow().click();
                break;
            }
        }
    }
    public void removeProduto(){
        wait.until(ExpectedConditions.elementToBeClickable(productPage.getBtnRemoveProduct()));
        productPage.getBtnRemoveProduct().click();
    }

    public void validaCarrinhoVazio(){
        Assert.assertEquals("Your shopping cart is empty", productPage.getMessagemCarrinhoVazio().getText());
    }

    public boolean validaCorNoCarrinho() throws SQLException, ClassNotFoundException, InterruptedException {
        String colorDB = dbConfig.validaCampos().get("color");
        productPage.getBtnShoppingCart().click();
        Thread.sleep(2000);
        String colorSelecionada = productPage.getCorSelecionada().getText();

        if(colorDB.equals(colorSelecionada)){
            System.out.print("Cores iguais validadas!!!");
            return true;
        }else{
            return false;
        }
    }

}
