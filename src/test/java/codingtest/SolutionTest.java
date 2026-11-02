package codingtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void example1() {
        int[] input = {1, 2, 3};

        int expected = 6;
        int actual = solution.solution(input);

        assertEquals(expected, actual);
    }

    @Test
    void example2() {
        int[] input = {10, 20, 30};

        assertEquals(60, solution.solution(input));
    }
}

