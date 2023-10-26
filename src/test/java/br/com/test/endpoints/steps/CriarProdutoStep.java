package br.com.test.endpoints.steps;

import br.com.test.endpoints.actions.CriarProdutoActions;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CriarProdutoStep {

    CriarProdutoActions criarProdutoActions;

    public CriarProdutoStep(){
        criarProdutoActions = new CriarProdutoActions();
    }

    @Dado("acesso o serviço de Criar Produtos com os dados:")
    public void acesso_o_serviço_de_Criar_Produtos_com_os_dados(DataTable dataTable) {
        List<Map<String, String>> dataList = dataTable.asMaps(String.class, String.class);
        Map<String, String> dataMap = dataList.get(0);

        Random random = new Random();
        int randomNumber = random.nextInt(1000);

        String titulo = dataMap.get("titulo") + randomNumber;
        String descricao = dataMap.get("descricao");
        float preco = Float.parseFloat(dataMap.get("preco"));
        float desc = Float.parseFloat(dataMap.get("desconto"));
        float avalia = Float.parseFloat(dataMap.get("avaliar"));
        int estoque = Integer.parseInt(dataMap.get("estoque"));
        String marca = dataMap.get("marca");
        String categoria = dataMap.get("categoria");
        String linkimg = dataMap.get("img");

        criarProdutoActions.acessarServicoCriarProduto(titulo, descricao, preco, desc, avalia, estoque, marca, categoria, linkimg);
    }

    @Quando("executo o serviço de Criar Produtos")
    public void executo_o_serviço_de_Criar_Produtos() throws IOException {
        criarProdutoActions.executarServicoCriarProduto();
    }

    @Então("o produto é criado com sucesso")
    public void o_produto_é_criado_com_sucesso() {
        criarProdutoActions.validarDadosDoProdutoCriado();
    }

    @Então("o contrato do serviço de Criar Produtos é validado")
    public void o_contrato_do_serviço_de_Criar_Produtos_é_validado() {
        criarProdutoActions.validarContratoDoServicoCriarProduto();
    }


}
