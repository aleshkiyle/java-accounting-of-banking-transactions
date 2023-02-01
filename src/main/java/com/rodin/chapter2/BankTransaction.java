package com.rodin.chapter2;

import java.time.LocalDate;

public record BankTransaction(LocalDate date, double amount, String description) {

}
