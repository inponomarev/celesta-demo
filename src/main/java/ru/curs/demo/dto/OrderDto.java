package ru.curs.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class OrderDto {
    private String id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String managerId;

    private List<OrderLineDto> lines;

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getManagerId() {
        return managerId;
    }

    public List<OrderLineDto> getLines() {
        return lines;
    }

    public OrderDto setLines(List<OrderLineDto> lines) {
        this.lines = lines;
        return this;
    }

    public OrderDto setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public OrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public OrderDto setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderDto setManagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }

    public OrderDto setId(String id) {
        this.id = id;
        return this;
    }
}
