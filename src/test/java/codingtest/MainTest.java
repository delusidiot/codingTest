package codingtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static codingtest.support.ConsoleRunner.run;

class MainTest {

    @Test
    void example1() throws Exception {
        String input = "1 2\n";
        String expected = "3";

        String actual = run(input,
                () -> Main.main(new String[0])
        );

        assertEquals(expected, actual);
    }

    @Test
    void example2() throws Exception {
        String input = "10 20\n";
        String expected = "30";

        String actual = run(input,
                () -> Main.main(new String[0])
        );

        assertEquals(expected, actual);
    }
}
