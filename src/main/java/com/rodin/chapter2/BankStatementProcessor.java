package com.rodin.chapter2;

import com.rodin.chapter3.BankTransactionFilter;
import com.rodin.chapter3.BankTransactionSummarizer;
import com.rodin.chapter3.SummaryStatistics;

import java.time.Month;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public SummaryStatistics summarizeTransactions() {
        final DoubleSummaryStatistics doubleSummaryStatistics =
                bankTransactions.stream()
                        .mapToDouble(BankTransaction::amount)
                        .summaryStatistics();

        return new SummaryStatistics(
                doubleSummaryStatistics.getSum(),
                doubleSummaryStatistics.getMax(),
                doubleSummaryStatistics.getMin(),
                doubleSummaryStatistics.getAverage()
        );
    }

    public double summarizeTransactions(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }

    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions((accumulator, bankTransaction) ->
                bankTransaction.date().getMonth() == month ? accumulator + bankTransaction.amount() :
                        accumulator);
    }

    public double calculateTotalForCategory(final String category) {
        return summarizeTransactions((accumulator, bankTransaction) ->
                Objects.equals(bankTransaction.description(), category) ? accumulator + bankTransaction.amount() :
                        accumulator);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        return this.bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .toList();
    }

    public List<BankTransaction> findTransactionsEqualsGreaterThenEqual(final double amount) {
        return findTransactions(bankTransaction -> bankTransaction.amount() >= amount);
    }

    public List<BankTransaction> findTransactionsInMonthO(final Month month) {
        return findTransactions(bankTransaction -> bankTransaction.date().getMonth() == month);
    }

    public List<BankTransaction> findTransactionsInMonthAndGreater(
            final Month month, final double amount
    ) {
        return findTransactions(bankTransaction -> bankTransaction.date().getMonth() == month &&
                bankTransaction.amount() >= amount);
    }
}
