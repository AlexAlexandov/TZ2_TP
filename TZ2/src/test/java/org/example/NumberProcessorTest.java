package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    @Test
    void testFindMin() throws IOException {
        File file = createTestFile("1 2 3 4 5");
        NumberProcessor processor = new NumberProcessor(file.getPath());
        assertEquals(1, processor._min());
        file.delete();
    }

    @Test
    void testFindMax() throws IOException {
        File file = createTestFile("1 2 3 4 5");
        NumberProcessor processor = new NumberProcessor(file.getPath());
        assertEquals(5, processor._max());
        file.delete();
    }

    @Test
    void testCalculateSum() throws IOException {
        File file = createTestFile("1 2 3 4 5");
        NumberProcessor processor = new NumberProcessor(file.getPath());
        assertEquals(15, processor._sum());
        file.delete();
    }

    @Test
    void testCalculateProduct() throws IOException {
        File file = createTestFile("1 2 3 4 5");
        NumberProcessor processor = new NumberProcessor(file.getPath());
        assertEquals(120, processor._mult());
        file.delete();
    }

    @Test
    void testPerformance() throws IOException {
        int[] numCounts = {1000, 10000, 100000, 1000000};
        long[] times = new long[numCounts.length];
        for (int i = 0; i < numCounts.length; i++) {
            File file = createTestFile(generateNumbers(numCounts[i]));
            NumberProcessor processor = new NumberProcessor(file.getPath());
            long startTime = System.nanoTime();
            processor._sum();
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;
            file.delete();
        }
        for (int i = 0; i < numCounts.length; i++) {
            System.out.println("Number of numbers: " + numCounts[i] + ", Time: " + times[i] + " nanoseconds");
        }
    }

    @Test
    void testMemoryUsage() throws IOException {
        int[] sizes = {1000, 10000, 100000, 1000000};
        for (int size : sizes) {
            File file = createTestFile(generateNumbers(size));
            NumberProcessor processor = new NumberProcessor(file.getPath());
            long beforeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long res = processor._sum();
            long afterMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
            long memoryUsed = afterMemory - beforeMemory;
            System.out.println("Array size: " + size + ", Memory used: " + memoryUsed + " bytes");
            file.delete();
        }
    }

    private File createTestFile(String content) throws IOException {
        File file = File.createTempFile("test", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
        return file;
    }

    private String generateNumbers(int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= count; i++) {
            builder.append(i).append(" ");
        }
        return builder.toString().trim();
    }
}