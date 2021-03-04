package es.jesustfk.curso.assertj.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FileTest {

    /*
    The same content in two files
     */
    @Test
    public void fileTest() {
        Path expectedFile = Paths.get("src/test/resources/data/expected.txt");
        Path actualFile = Paths.get("src/test/resources/data/actual.txt");

        assertThat(actualFile).hasSameContentAs(expectedFile);
    }
}
