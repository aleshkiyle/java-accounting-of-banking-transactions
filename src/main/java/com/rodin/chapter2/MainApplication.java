package com.rodin.chapter2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
        System.out.printf("The total for all transactions is %.1f%n", total);

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        double totalInJanuary = 0d;
        for (String line: lines) {
            String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                totalInJanuary += Double.parseDouble(columns[1]);
            }
        }
        System.out.printf("The total for all transactions in January is %.1f", totalInJanuary);
    }
}
