package es.jesustfk.curso.assertj.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class ListTest {

    /*
    has 3 elements
    has apple and ball elements
    no has cat
    bonus every elements minimus 4 characters
     */
    @Test(dataProvider = "getData")
    public void listTest(List<String> input) {
        List<String> expected = Arrays.asList("apple", "ball");
        assertSoftly(softAssertions -> {
                softAssertions.assertThat(input)
                        .hasSize(3)
                        .doesNotContain("cat")
                        .containsAll(expected)
                        .allSatisfy(s -> assertThat(s.length()).isGreaterThanOrEqualTo(4));
            });
        //input.forEach(s -> assertThat(s.length()).isGreaterThanOrEqualTo(4));
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                Arrays.asList("ball", "apple", "card"),
                Arrays.asList("ball", "apple", "cat"),
                Arrays.asList("ball", "apple", "mouse"),
        };
    }
}