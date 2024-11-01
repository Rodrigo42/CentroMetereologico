package br.com.fiap.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue = "br/com/fiap/test/steps",
        plugin = {"html:target/cucumber-reports.html"}
)
public class TestRunnerTest {
}