package br.com.test.endpoints.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfterTest {

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("################## INICIO DE TESTE CENÁRIO: " + scenario.getName() + " ###############");
    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("############################  FINALIZADO TESTE  #############################");
    }

}