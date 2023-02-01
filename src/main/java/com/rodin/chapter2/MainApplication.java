package com.rodin.chapter2;

import com.rodin.chapter3.Exporter;
import com.rodin.chapter3.HtmlExporter;

import java.io.IOException;

public class MainApplication {

    private static final String CSV_SOURCE = "src/main/resources/bank-simple.csv";

    public static void main(String[] args) throws IOException {

        final var bankStatementCSVParser = new BankStatementCSVParser();

        final var bankStatementAnalyzer = new BankStatementAnalyzer();

        final var exporter = new HtmlExporter();

        bankStatementAnalyzer.analyze(CSV_SOURCE, bankStatementCSVParser, exporter);
    }
}
