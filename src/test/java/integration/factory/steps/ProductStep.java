package integration.factory.steps;


import integration.factory.database.DBConfig;
import integration.factory.funcs.HomeFunc;
import integration.factory.funcs.ProductFunc;
import integration.factory.web.enums.Color;
import io.cucumber.java.es.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.Map;


public class ProductStep {

    ProductFunc productFunc = new ProductFunc();
    DBConfig dbConfig = new DBConfig();
    Color corEscolhida;



    @Então("validar a especificação do produto de acordo com o banco de dados")
    public void validarAEspecificaçãoDoProdutoDeAcordoComOBancoDeDados() throws SQLException, ClassNotFoundException {
        Map<String, String> valores = dbConfig.validaCampos();

        for(Map.Entry<String, String> entry : valores.entrySet()) {
            Assert.assertEquals(entry.getValue(), productFunc.getItem(entry.getKey()));
        }
    }

    @Quando("altero a cor do produto de acordo com a cor retornada do banco de dados")
    public void alteroACorDoProdutoDeAcordoComACorRetornadaDoBancoDeDados() throws SQLException, ClassNotFoundException {
        String colorDB = dbConfig.validaCampos().get("color");
        productFunc.alteraCorIgualBanco(colorDB);
    }
    @Quando("altero a cor do produto")
    public void alteroACorDoProduto() throws SQLException, ClassNotFoundException, InterruptedException {
        String colorDB = dbConfig.validaCampos().get("color");

        corEscolhida = productFunc.enumCor();

        while(corEscolhida.getColor().equals(colorDB)) {

            corEscolhida = productFunc.enumCor();
        }
        productFunc.selecionarCor((corEscolhida));
        Thread.sleep(2000);
    }

    @E("clico em Add to cart")
    public void clicoEmAddToCart() {
        productFunc.clicarAddToCart();
    }

    @E("acesso a pagina de checkout")
    public void acessarTelaCheckout() {
        productFunc.acessarCheckout();
    }

    @Então("valido que o produto foi adicionado ao carrinho com a cor selecionada")
    public void validoQueOProdutoFoiAdicionadoAoCarrinhoComACorSelecionada() throws SQLException, ClassNotFoundException, InterruptedException {
        Assert.assertTrue(productFunc.validaProdutoCarrinho());
        Assert.assertTrue(productFunc.validaCorNoCarrinho());
    }

    @Então("valido que  total na pagina de checkout")
    public void validoTOtalPaginaCheckout() throws InterruptedException {
        productFunc.validarTotal();
    }

    @Quando("altero a quantidade que desejo comprar para {int}")
    public void alteroAQuantidadeQueDesejoComprar(Integer Quantidade) {
        productFunc.clicaMaisQuantidade(Quantidade);
    }

    @Quando("realizo um update no banco da cor  do produto para a cor usada no teste")
    public void alteroCorNoBancoDeDados() throws SQLException, ClassNotFoundException {
        DBConfig.realizaUpdateBanco(corEscolhida.getColor());
        Assert.assertEquals(corEscolhida.getColor(), dbConfig.validaCampos().get("color"));
    }

    @E("removo o produto do carrinho de compras")
    public void removoOProdutoDoCarrinho() throws SQLException, ClassNotFoundException, InterruptedException {
        productFunc.removeProduto();
    }
    @Então("valido que o carrinho de compras está vazio")
    public void validoQueOCarrinhoDeComprasEstáVazio() {
         productFunc.validaCarrinhoVazio();
    }

}
