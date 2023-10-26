package br.com.test.sql;

import br.com.test.conexao.ConexaoSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtils {

    private static ConexaoSql conexaoSql;

    /*
        Conexão com a Base
     */
    protected static Connection getConexaoSql() throws SQLException, ClassNotFoundException {
        initConexaoSqlSeNecessario();
        return conexaoSql.getConexaoBD();
    }

    private static void initConexaoSqlSeNecessario() {
        if (conexaoSql == null) {
            conexaoSql = new ConexaoSql();
        }
    }

    /*
        Classe responsavél por  executar uma query dentro da base
     */
    public static String resultQuery(String query, String campo) throws ClassNotFoundException {
        String result = "";
        try (Connection con_cob = getConexaoSql(); Statement stmt = con_cob.createStatement()){
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                result = resultSet.getString(campo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



}
