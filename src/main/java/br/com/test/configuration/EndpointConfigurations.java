package br.com.test.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe de configurações do endpoint. Esta classe fornece funcionalidades para carregar e obter
 * URLs de API a partir de um arquivo de propriedades.
 */
public class EndpointConfigurations {

    // Caminho do arquivo de propriedades que contém as configurações da API.
    private static final String PROPERTIES_FILE_PATH = "./src/test/resources/api.properties";
    private static Properties props;

    /**
     * Inicializa e carrega o arquivo de propriedades.
     *
     * @throws IOException Se ocorrer um erro ao ler o arquivo de propriedades.
     */
    private static void inicializaProperties() throws IOException {
        props = new Properties();
        props = getProperties();
    }

    /**
     * Retorna a URL da API para o endpoint especificado.
     *
     * @param endpoint O tipo de conexão enum que representa o endpoint desejado.
     * @return A URL da API para o endpoint especificado.
     * @throws IOException Se ocorrer um erro ao inicializar ou obter a propriedade.
     */
    public static String getUrlApi(TipoConexaoEnum endpoint) throws IOException {
        inicializaProperties();
        return props.getProperty(endpoint.toString());
    }

    /**
     * Carrega e retorna as propriedades do arquivo de propriedades.
     *
     * @return O objeto Properties carregado a partir do arquivo de propriedades.
     * @throws IOException Se ocorrer um erro ao ler o arquivo de propriedades.
     */
    private static Properties getProperties() throws IOException {
        FileInputStream file = new FileInputStream(PROPERTIES_FILE_PATH);
        props.load(file);
        file.close();
        return props;
    }

}


