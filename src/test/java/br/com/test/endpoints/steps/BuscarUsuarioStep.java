package br.com.test.endpoints.steps;

import br.com.test.endpoints.actions.BuscaUsuarioAction;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

import java.io.IOException;

public class BuscarUsuarioStep {

    BuscaUsuarioAction buscaUsuarioAction;

    public BuscarUsuarioStep() {
        buscaUsuarioAction = new BuscaUsuarioAction();
    }

    @Dado("que acesso o servico de Buscar Usuarios já cadastrados")
    public void que_acesso_o_servico_de_Buscar_Usuarios_já_cadastrados() {
        buscaUsuarioAction.acessarServicoBuscarUsuario();
    }

    @Quando("executo o serviço de Buscar Usuarios")
    public void executo_o_serviço_de_Buscar_Usuarios() throws IOException {
        buscaUsuarioAction.executarServicoBuscarUsuario();
    }

    @Entao("valido a exibicao dos dados {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} e {string}")
    public void valido_a_exibicao_dos_dados_e(String firstName, String lastName, String maidenName, String age, String gender, String email, String phone, String username, String password, String birthDate) {
        buscaUsuarioAction.validarDadosDoUsuario(firstName,lastName,maidenName, age, gender, email, phone, username, password, birthDate);
    }

    @E("valido o contrato do servico de Buscar Usuarios")
    public void valido_o_contrato_do_servico_de_Buscar_Usuarios() {
        buscaUsuarioAction.validarContratoDoServicoBuscarUsuario();
    }

    @Entao("valido que não existe o usuário {string}")
    public void valido_que_não_existe_o_usuário(String usuario) {
        buscaUsuarioAction.validarMensagemBuscarUsuario(usuario);
    }

}
