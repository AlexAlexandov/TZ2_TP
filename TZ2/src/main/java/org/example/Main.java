package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class NumberProcessor {
    private String filename;

    public NumberProcessor(String filename) {
        this.filename = filename;
    }

    public int _min() throws IOException {
        int min = Integer.MAX_VALUE;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                int n = Integer.parseInt(num);
                if (n < min) {
                    min = n;
                }
            }
        }
        return min;
    }

    public int _max() throws IOException {
        int max = Integer.MIN_VALUE;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                int n = Integer.parseInt(num);
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }

    public int _sum() throws IOException {
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                sum += Integer.parseInt(num);
            }
        }
        return sum;
    }

    public long _mult() throws IOException {
        long product = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String[] numbers = line.split(" ");
            for (String num : numbers) {
                product *= Long.parseLong(num);
            }
        }
        return product;
    }
}


