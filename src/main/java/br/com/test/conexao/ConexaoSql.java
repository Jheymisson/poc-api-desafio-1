package br.com.test.conexao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSql {

    private static String DRIVER_NAME = "net.sourceforge.jtds.jdbc.Driver";
    static Logger logger = LoggerFactory.getLogger(ConexaoSql.class);

    public Connection getConexaoBD() throws SQLException, ClassNotFoundException {
        try {
            // Carrega o driver JDBC
            String driverName = DRIVER_NAME;
            // Cria a conexao  com Banco de dados
            Class.forName(driverName);
            String serverName = System.getProperty("");
            String mydatabase = System.getProperty("");
            // a JDBC url
            String url = "jdbc:jtds:sqlserver://" + serverName + "/" + mydatabase;
            String username = System.getProperty("");
            String password = System.getProperty("");
            logger.info("Realizando conexão sql na base!");
            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            logger.error("Não pode encontrar o driver para  Conectar - " + e.getMessage());
            throw e;
        }
    }

}