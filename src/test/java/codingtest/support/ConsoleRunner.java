package codingtest.support;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConsoleRunner {

    @FunctionalInterface
    public interface Program {
        void run() throws Exception;
    }

    public static String run(
            String input,
            Program program
    ) throws Exception {

        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        try (PrintStream ps =
                     new PrintStream(output, true, "UTF-8")) {

            System.setIn(new ByteArrayInputStream(
                    input.getBytes(StandardCharsets.UTF_8)
            ));

            System.setOut(ps);
            program.run();

        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return output.toString("UTF-8")
                .replace("\r\n", "\n")
                .trim();
    }
}
