package com.rodin.chapter2;

import java.io.IOException;

public class MainApplication {

    private static final String CSV_SOURCE = "src/main/resources/bank-simple.csv";

    public static void main(String[] args) throws IOException {

        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        bankStatementAnalyzer.analyze(CSV_SOURCE, bankStatementCSVParser);
    }
}
