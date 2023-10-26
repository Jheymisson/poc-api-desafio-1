package br.com.test.executar;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.DataProvider;

/**
 * Configurações para execução dos testes Cucumber utilizando TestNG.
 *
 * <p>Esta classe é responsável por definir as opções de execução dos testes Cucumber.
 * Ela estende {@code AbstractTestNGCucumberTests}, fornecendo integração direta com o TestNG.</p>
 *
 * @CucumberOptions
 * <ul>
 *     <li><b>plugin</b>: Define os plugins que são ativados para esta execução.</li>
 *     <li><b>features</b>: Caminho para as definições de features do Cucumber.</li>
 *     <li><b>glue</b>: Pacote que contém as definições de etapas (step definitions).</li>
 *     <li><b>monochrome</b>: Se verdadeiro, a saída da console para esta execução não usará cores.</li>
 *     <li><b>tags</b>: Tags específicas a serem consideradas para execução.</li>
 * </ul>
 *
 */
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/features",
        glue = "br.com.test.endpoints",
        monochrome = true,
        tags = ""
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    /**
     * Fornece os cenários a serem executados pelo TestNG.
     *
     * <p>Este método é uma sobreposição do método fornecido pela superclasse.
     * Ele retorna os cenários que devem ser considerados para a execução.</p>
     *
     * @return Um array de objetos representando os cenários a serem executados.
     */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
