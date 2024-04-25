package com.ltp.workbook;

import java.math.BigDecimal;

public class Record
{
    private final  String item;
    private final BigDecimal revenue;
    private final BigDecimal cost;

    public Record(final String item,
                  final BigDecimal revenue,
                  final  BigDecimal cost)
    {
        this.item = item;
        this.revenue = revenue;
        this.cost = cost;
    }

    public String getItem() {
        return item;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
