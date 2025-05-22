package org.example;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit тесты для класса Main, выполняющего бенчмарк ArrayList и LinkedList.
 */
public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Проверяет, что в выводе присутствуют заголовки бенчмарка для обоих списков.
     */
    @Test
    void testPrintsBenchmarkHeaders() throws IOException {
        Main.main(new String[0]);
        String output = outContent.toString();

        assertTrue(output.contains("Benchmarking ArrayList with"),
                "Должен содержаться заголовок для ArrayList");
        assertTrue(output.contains("Benchmarking LinkedList with"),
                "Должен содержаться заголовок для LinkedList");
    }

    /**
     * Проверяет, что для ArrayList напечатано ровно 3 строки результатов.
     */
    @Test
    void testThreeArrayListResults() {
        Main.main(new String[0]);
        String[] lines = outContent.toString().split("\r?\n");
        long count = java.util.Arrays.stream(lines)
                .filter(line -> line.startsWith("ArrayList"))
                .count();
        assertEquals(3, count, "Должно быть три строки результатов для ArrayList");
    }

    /**
     * Проверяет, что для LinkedList напечатано ровно 3 строки результатов.
     */
    @Test
    void testThreeLinkedListResults() {
        Main.main(new String[0]);
        String[] lines = outContent.toString().split("\r?\n");
        long count = java.util.Arrays.stream(lines)
                .filter(line -> line.startsWith("LinkedList"))
                .count();
        assertEquals(3, count, "Должно быть три строки результатов для LinkedList");
    }
}
