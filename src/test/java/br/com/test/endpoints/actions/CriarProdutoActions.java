package br.com.test.endpoints.actions;

import br.com.test.configuration.EndpointConfigurations;
import br.com.test.endpoints.utils.RestStep;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import java.io.IOException;

import static br.com.test.configuration.TipoConexaoEnum.SICRED_CRIAR_PRODUTO;
import static br.com.test.endpoints.bodies.ServiceBodies.bodyCriarProduto;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
/**
 * Ação para criar produtos. Esta classe define os métodos para interagir com o serviço de criação de produtos.
 */
public class CriarProdutoActions {

    // Atributo para representar as etapas da requisição e resposta REST.
    private RestStep restStep;

    /**
     * Construtor padrão. Inicializa a etapa de REST.
     */
    public CriarProdutoActions() {
        restStep = new RestStep();
    }

    /**
     * Define a requisição para acessar o serviço de criação de produtos.
     * A requisição inclui detalhes como tipo de conteúdo e o corpo da requisição com os dados do produto.
     *
     * @param titulo    Título do produto.
     * @param descricao Descrição do produto.
     * @param preco     Preço do produto.
     * @param desc      Desconto do produto.
     * @param avalia    Avaliação do produto.
     * @param estoque   Estoque do produto.
     * @param marca     Marca do produto.
     * @param categoria Categoria do produto.
     * @param linkimg   Link da imagem do produto.
     */
    public void acessarServicoCriarProduto(String titulo, String descricao, float preco,
                                           float desc, float avalia, int estoque,
                                           String marca, String categoria, String linkimg) {
        restStep.setRequest(given().log().all()
                .contentType(ContentType.JSON.withCharset("UTF-8"))
                .body(bodyCriarProduto(titulo, descricao, preco, desc, avalia, estoque, marca, categoria, linkimg)));
    }

    /**
     * Executa a requisição para criar um novo produto.
     *
     * @throws IOException caso ocorra um erro ao executar a requisição.
     */
    public void executarServicoCriarProduto() throws IOException {
        restStep.setResponse(restStep
                .getRequest()
                .when().log().all()
                .post(EndpointConfigurations.getUrlApi(SICRED_CRIAR_PRODUTO)));
    }

    /**
     * Valida os dados do produto criado na resposta do serviço.
     * Atualmente, verifica apenas o código de status da resposta.
     */
    public void validarDadosDoProdutoCriado() {
        Response response = restStep.getResponse();
        response.then().statusCode(200);
    }

    /**
     * Valida o contrato da resposta do serviço de criação de produtos.
     * Esta validação usa um esquema JSON para verificar se a resposta está no formato esperado.
     */
    public void validarContratoDoServicoCriarProduto() {
        Response response = restStep.getResponse();
        String schemaPath = "schemas/CriarProdutoSchema.json";
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

}
