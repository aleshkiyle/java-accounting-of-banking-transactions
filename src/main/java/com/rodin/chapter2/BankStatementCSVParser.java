package com.rodin.chapter2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    private static final DateTimeFormatter DATE_PATTERN =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static final String SPLITERATOR = ",";

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(SPLITERATOR);

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2].trim();

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLineFrom(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line: lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
    }
}
