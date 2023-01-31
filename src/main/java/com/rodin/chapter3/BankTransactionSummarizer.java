package com.rodin.chapter3;

import com.rodin.chapter2.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);

}
