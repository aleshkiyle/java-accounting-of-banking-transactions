package com.rodin.chapter2;

import lombok.Data;

import java.time.LocalDate;

public record BankTransaction(LocalDate date, double amount, String description) {

}
