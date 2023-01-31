package com.rodin.chapter3;

import com.rodin.chapter2.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {

    boolean test(final BankTransaction bankTransaction);

}
