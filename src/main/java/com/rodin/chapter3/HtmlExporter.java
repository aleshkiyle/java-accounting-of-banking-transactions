package com.rodin.chapter3;

public class HtmlExporter implements Exporter {

    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!doctype html>";
        result += "<html lang='en'>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.sum() + "</li>";
        result += "<li><strong>The average is</strong>: " + summaryStatistics.average() + "</li>";
        result += "<li><strong>The max is</strong>: " + summaryStatistics.max() + "</li>";
        result += "<li><strong>The min is</strong>: " + summaryStatistics.min() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
