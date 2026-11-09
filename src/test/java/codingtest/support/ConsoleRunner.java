package codingtest.support;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class ConsoleRunner {

    private ConsoleRunner() {}

    @FunctionalInterface
    public interface Program {
        void run() throws Exception;
    }

    public static String run(String input, Program program) throws Exception {
        InputStream originalIn = System.in;
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (PrintStream ps = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
            System.setOut(ps);
            program.run();
            ps.flush();
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }

        return normalize(output.toString(StandardCharsets.UTF_8));
    }

    /** 줄바꿈 통일 + 줄 끝 공백 제거 + 앞뒤 빈 줄 제거 */
    public static String normalize(String s) {
        return s.replace("\r\n", "\n")
                .lines()
                .map(String::stripTrailing)
                .collect(Collectors.joining("\n"))
                .strip();
    }
}