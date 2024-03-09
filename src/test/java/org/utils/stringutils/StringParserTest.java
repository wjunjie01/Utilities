package org.utils.stringutils;

import org.junit.jupiter.api.Test;
import org.utils.exceptions.InvalidStringInputException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringParserTest {

    // job of the test is to check for error, throws if there's exception
    // 3 part format for naming convention
    // methodBeingTested_conditionToTest_expectedOutcome
    @Test
    void splitString_oneSeparator_expectTwoParts() throws InvalidStringInputException {
        //setup lines, Happy path
        StringParser sp = new StringParser();
        String inputString = "Hello|world"; //(condition is 1 separator)
        String separator = "\\|"; // \ bitwise or operator or the pipe in UNIX, escapes the meaning
        ArrayList<String> stringParts = sp.splitString(inputString, separator);

        //actual test
        assertEquals(2, stringParts.size());
    }

    @Test
    void splitString_nullString_expectException() {
        StringParser sp = new StringParser();
        String inputString = null; //(condition is 1 separator)
        String separator = "\\|"; // \ bitwise or operator or the pipe in UNIX, escapes the meaning
        //ArrayList<String> stringParts = sp.splitString(inputString, separator);

        //actual test
        //assertEquals(2, stringParts.size()) build will fail

        //Expects the type and calls the function
        //Throwing the error it is looking for
        assertThrows(InvalidStringInputException.class,
                () -> sp.splitString(inputString, separator));
    }
}
