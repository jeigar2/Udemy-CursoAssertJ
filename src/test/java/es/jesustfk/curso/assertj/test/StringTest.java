package es.jesustfk.curso.assertj.test;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.testng.Assert.*;

/*
String input = <some test>;
validate
Length is 8
Starts with "se"
Should not contain "api"
Should not contain any white space
Only one "i" is present
 */

public class StringTest {

    @Test(dataProvider = "getData")
    public void stringTest(String input) {
        // con assartionsSoftly
        // muestra en la consola todas las condiciones que no se cumplen
        // en lugar de parar en la primera condicion que no se cumple.
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(input)
                    .hasSize(8)
                    .startsWith("se")
                    .doesNotContain("api")
                    .doesNotContainAnyWhitespaces()
                    .containsOnlyOnce("i");
        });
    }

    @DataProvider
    public Object[] getData(){
        return new String[] {
                "selenium",
                "selenide",
                "ri tapi"
        };
    }
}