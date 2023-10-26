package br.com.test.endpoints.steps;

import br.com.test.endpoints.actions.BuscarProdutosActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class BuscarProdutoID {

    BuscarProdutosActions buscarProdutosActions;

    public BuscarProdutoID() {
        buscarProdutosActions = new BuscarProdutosActions();
    }

    @Dado("que acesso o servico de Buscar Produto por ID {string}")
    public void queAcessoOServicoDeBuscarProdutoPorID(String id) {
        buscarProdutosActions.acessarServicoBuscarProdutoID(id);
    }

    @Quando("executo o serviço de Buscar Produto com o ID")
    public void executoOServicoDeBuscarProdutoComOID() throws IOException {
        buscarProdutosActions.executarServicoBuscarProdutoID();
    }

    @Entao("valido a exibicao dos dados de produtos do serviço de Buscar Produto por ID {string}, {string}, {string}, {string}, {string} e {string}")
    public void validoAExibicaoDosDadosDeProdutosDoServicoDeBuscarProdutoPorIDe(String id, String nome, String preco, String desconto, String estoque, String marca) {
        buscarProdutosActions.validarDadosDoProdutoPorID(id, nome, preco, desconto, estoque, marca);
    }

    @E("valido o contrato do servico de Buscar Produto por ID")
    public void validoOContratoDoServicoDeBuscarProdutoPorID() {
        buscarProdutosActions.validarContratoDoServicoBuscarProdutoID();
    }
}
