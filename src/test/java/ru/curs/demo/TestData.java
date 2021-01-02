package ru.curs.demo;

import ru.curs.demo.dto.OrderDto;
import ru.curs.demo.dto.OrderLineDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestData {
    public static OrderDto getBrownOrder() {
        OrderDto doc = new OrderDto();
        List<OrderLineDto> lines = new ArrayList<>();
        lines.add(new OrderLineDto().setItemId("A").setQty(5));
        lines.add(new OrderLineDto().setItemId("B").setQty(3));
        doc.setId("no1").setDate(LocalDate.now()).setCustomerId("Brown").setLines(lines);
        return doc;
    }

    public static OrderDto getPinkOrder() {
        OrderDto doc = new OrderDto();
        List<OrderLineDto> lines = new ArrayList<>();
        lines.add(new OrderLineDto().setItemId("B").setQty(4));
        doc.setId("no2").setDate(LocalDate.now()).setCustomerId("Pink").setLines(lines);
        return doc;
    }
}
