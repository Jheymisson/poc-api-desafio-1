package br.com.test.endpoints.actions;

import br.com.test.configuration.EndpointConfigurations;
import br.com.test.endpoints.utils.RestStep;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static br.com.test.configuration.TipoConexaoEnum.SICRED_BUSCAR_USUARIOS;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

/**
 * Classe de ação para a funcionalidade de Buscar Usuário.
 * Fornece métodos para interagir e validar respostas do serviço de Buscar Usuário.
 */
public class BuscaUsuarioAction {

    // Instância da classe auxiliar RestStep que contém informações sobre a solicitação e resposta HTTP.
    private RestStep restStep;

    /**
     * Construtor da classe BuscaUsuarioAction.
     * Inicializa a instância de {@link RestStep}.
     */
    public BuscaUsuarioAction() {
        restStep = new RestStep();
    }

    /**
     * Configura uma solicitação para acessar o serviço de Buscar Usuário.
     */
    public void acessarServicoBuscarUsuario() {
        restStep.setRequest(given()
                .log().all()
                .contentType(ContentType.JSON.withCharset("UTF-8")));
    }

    /**
     * Executa o serviço de Buscar Usuário.
     *
     * <p>A URL do serviço é obtida a partir da classe de configurações {@code EndpointConfigurations}.
     * O resultado da solicitação é armazenado para validações posteriores.</p>
     *
     * @throws IOException Caso haja problemas ao obter a URL do serviço.
     */
    public void executarServicoBuscarUsuario() throws IOException {
        restStep.setResponse(restStep
                .getRequest()
                .when()
                .get(EndpointConfigurations.getUrlApi(SICRED_BUSCAR_USUARIOS)));
    }

    /**
     * Valida os dados retornados pelo serviço de Buscar Usuário.
     *
     * @param firstName, lastName, maidenName, age, gender, email, phone, username, password, birthDate - São os atributos do usuário que são validados na resposta.
     */
    public void validarDadosDoUsuario(String firstName, String lastName, String maidenName, String age,
                                      String gender, String email, String phone, String username, String password,
                                      String birthDate) {
        Response response = restStep.getResponse();
        response.then().statusCode(200);
        String responseBody = response.getBody().asString();
        List<String> valuesToCheck = Arrays.asList(firstName, lastName, maidenName, age, gender, email, phone, username, password, birthDate);

        for (String value : valuesToCheck) {
            Assert.assertTrue("Resposta do erro: " + value, responseBody.contains(value));
        }

    }

    /**
     * Valida o contrato do serviço de Buscar Usuário.
     *
     * <p>Este método utiliza um arquivo de esquema JSON localizado no classpath para validar
     * a estrutura do JSON retornado pelo serviço. Assumimos que o esquema está correto e reflete
     * as expectativas para a resposta do serviço.</p>
     */
    public void validarContratoDoServicoBuscarUsuario() {
        Response response = restStep.getResponse();
        String schemaPath = "schemas/BuscarUsuarioSchema.json";
        response.then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath(schemaPath));
    }

    /**
     * Valida a mensagem retornada pelo serviço de Buscar Usuário.
     *
     * <p>Este método verifica se o nome do usuário não está presente na resposta. É usado para validar
     * cenários onde um usuário específico não deve estar na lista de usuários retornada pelo serviço.</p>
     *
     * @param usuario O nome do usuário que não deve estar presente na resposta.
     */
    public void validarMensagemBuscarUsuario(String usuario) {
        Response response = restStep.getResponse().then().extract().response();
        boolean usuarioEncontrado = response.getBody().asString().contains(usuario);
        Assert.assertFalse("O nome do usuário foi encontrado na lista, mas não deveria estar lá.", usuarioEncontrado);
    }
}

