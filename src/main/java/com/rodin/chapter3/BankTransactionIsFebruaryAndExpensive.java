package com.rodin.chapter3;

import com.rodin.chapter2.BankTransaction;

import java.time.Month;

public class BankTransactionIsFebruaryAndExpensive implements BankTransactionFilter {
    @Override
    public boolean test(BankTransaction bankTransaction) {
        return bankTransaction.date().getMonth() == Month.FEBRUARY && bankTransaction.amount() >= 1_000;
    }
}
