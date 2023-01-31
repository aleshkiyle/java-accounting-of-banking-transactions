package com.rodin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainApplication {

    private static final String CSV_SOURCE = "src/main/resources/bank-simple.csv";

    public static void main(String[] args) throws IOException {
        final Path path = Path.of(CSV_SOURCE);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (String line: lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        System.out.printf("The total for all transactions is %.1f", total);
    }
}
