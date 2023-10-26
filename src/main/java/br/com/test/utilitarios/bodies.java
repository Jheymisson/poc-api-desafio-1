package br.com.test.utilitarios;

import java.util.HashMap;

public class bodies {

    public static HashMap<String, Object> bodyProdutoAuth(String usuario, String senha) {
        HashMap<String, Object> body = new HashMap<>();
        body.put("username", usuario);
        body.put("password", senha);
        return body;
    }

}
