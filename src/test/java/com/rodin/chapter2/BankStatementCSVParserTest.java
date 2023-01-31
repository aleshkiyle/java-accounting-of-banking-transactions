package com.rodin.chapter2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser =
            new BankStatementCSVParser();

    @Test
    public void correctTestLine() {
        Assertions.assertTrue(true);
    }
    @Test
    public void shouldParseOneCorrectLine() {
        final String line = "30-01-2023, 100, Salary";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected =
                new BankTransaction(LocalDate.of(2023, Month.JANUARY, 30), 100, "Salary");

        assertEquals(expected.date(), result.date());
        assertEquals(expected.amount(), result.amount());
        assertEquals(expected.description(), result.description());
    }

    @Test
    public void shouldParseOneIncorrectLine() {
        final String line = "30-01-2023, 100, Salary";

        final BankTransaction resultParsing = this.statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(
                LocalDate.of(2023, Month.JANUARY, 29), 120, "Tesco"
        );

        assertNotEquals(expected.date(), resultParsing.date());
        assertNotEquals(expected.amount(), resultParsing.amount());
        assertNotEquals(expected.description(), resultParsing.description());
    }
}