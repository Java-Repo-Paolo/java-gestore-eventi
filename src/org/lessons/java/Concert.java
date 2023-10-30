package org.lessons.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{
    private LocalTime time;
    private BigDecimal price;

    public Concert(String title, LocalDate date, int totalPlaces, LocalTime time, BigDecimal price) throws IllegalArgumentException {
        super(title, date, totalPlaces);
        this.time= time;
        this.price = price;
    }

    public LocalTime getTime() {
        return time;
    }

    private String getPrice() {
        DecimalFormat decimalFormat = new DecimalFormat("##,##0.00€");
        return decimalFormat.format(price);
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Concert{" +
                "time=" + time +
                ", price=" + price +
                '}';
    }
}
