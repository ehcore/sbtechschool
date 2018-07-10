package ru.sbt.bit.ood.solid.homework;


import java.time.LocalDate;

public class DateRange {
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public DateRange(LocalDate dateFrom, LocalDate dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    @Override
    public String toString() {
        return "DateRange{" +
                "dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
