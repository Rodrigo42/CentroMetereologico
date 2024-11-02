package br.com.fiap.test;


import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ChuvaControllerTest.class,
        QualidadeAguaControllerTest.class,
        QualidadeArControllerTest.class,
        SecaControllerTest.class,
        TerremotoControllerTest.class
})
public class JunitTestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ChuvaControllerTest.class,
                QualidadeAguaControllerTest.class,
                QualidadeArControllerTest.class,
                SecaControllerTest.class,
                TerremotoControllerTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println("Teste falhou: " + failure.toString());
        }

        System.out.println("Todos os testes passaram? " + result.wasSuccessful());
    }
}
