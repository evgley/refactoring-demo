package intro;

import org.junit.Test;

import java.util.ArrayList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;

/**
 * SUT: system under test
 * Test Case: class
 * Test, Test scenario: method
 */
public class ArrayListTest { //SUT = ArrayList
    @Test(timeout = 5_000)
    public void itShouldSizeIncrementedAddedWhenDoAddElement() { //BDD: Domain Lang
        //region Fixture | Arrange | Given
        ArrayList<Object> sut = new ArrayList<>();
        Object dummy = new Object();
        assumeTrue(sut.size() == 0); //Pending | Ignored
        //endregion

        //region Act | When
        sut.add(dummy);
        //endregion

        //region Assert | Then
        /**
         * AssertionError | Failure
         */

        assertThat(sut.size()).isEqualTo(1);
        assertThat(sut).doesNotContain(2).doesNotContain(1);
        //endregion
    }

    @Test(expected = NullPointerException.class)
    public void itShouldGetErrorWhenSutIsNull() {
        ArrayList sut = null;
        sut.add("");
    }
}
