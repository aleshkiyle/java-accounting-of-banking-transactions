package com.rodin.chapter2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankStatementCSVParserTest {

    private final BankStatementParser statementParser =
            new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() {
        final String line = "30-01-2023, 100,Salary";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected =
                new BankTransaction(LocalDate.of(2023, Month.JANUARY, 30), 100, "Salary");

        assertEquals(expected.date(), result.date());
        assertEquals(expected.amount(), result.amount());
        assertEquals(expected.description(), result.description());
    }

}