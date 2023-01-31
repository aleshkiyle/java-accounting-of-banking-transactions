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

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Path.of(CSV_SOURCE);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLineFromCSVFile(lines);
    }
}
