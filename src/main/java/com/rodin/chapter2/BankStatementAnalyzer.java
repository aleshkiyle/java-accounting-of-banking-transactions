package com.rodin.chapter2;

import com.rodin.chapter3.Exporter;
import com.rodin.chapter3.SummaryStatistics;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BankStatementAnalyzer {

    public void analyze(final String fileName,
                        final BankStatementParser bankStatementParser,
                        final Exporter exporter) throws IOException {
        final Path path = Path.of(fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLineFrom(lines);

        final var bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        final var summaryStatistics = bankStatementProcessor.summarizeTransactions();

        System.out.println(exporter.export(summaryStatistics));
    }
}
