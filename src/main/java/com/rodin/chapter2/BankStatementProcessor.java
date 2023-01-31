package com.rodin.chapter2;

import java.time.Month;
import java.util.List;
import java.util.Objects;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;


    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return bankTransactions.stream()
                .map(BankTransaction::amount)
                .reduce(Double::sum)
                .orElse(0d);
    }

    public double calculateTotalInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.date().getMonth() == month)
                .map(BankTransaction::amount)
                .reduce(Double::sum)
                .orElse(0d);
    }

    public double calculateTotalForCategory(final String category) {
        return bankTransactions.stream()
                .filter(bankTransaction -> Objects.equals(bankTransaction.description(), category))
                .map(BankTransaction::amount)
                .reduce(Double::sum)
                .orElse(0d);
    }
}
