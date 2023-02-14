package com.coderscampus.salesdatasorter;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class TelsaSales {
    private YearMonth date;
    private Integer sales;

    public TelsaSales(String date, String sales){
        this.date = YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM-yy"));
        this.sales = Integer.parseInt(String.valueOf(sales));
    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
