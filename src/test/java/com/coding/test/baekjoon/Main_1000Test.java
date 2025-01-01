package com.coding.test.baekjoon;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Main_1000Test {
    @Test
    void solve() throws IOException {
        String input = "1 2";
        String answer = "3\r\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        System.setIn(bais);
        System.setOut(new PrintStream(bos));

        Main_1000 main = new Main_1000();
        main.solve();
        assertEquals(answer, bos.toString());

    }
}