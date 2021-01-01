package ru.curs.demo.service;

import org.junit.jupiter.api.Test;
import ru.curs.celesta.CallContext;
import ru.curs.celestaunit.CelestaTest;
import ru.curs.demo.OrderHeaderCursor;
import ru.curs.demo.OrderLineCursor;
import ru.curs.demo.dto.OrderDto;
import ru.curs.demo.dto.OrderLineDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CelestaTest
public class DocumentServiceTest {

    DocumentService srv = new DocumentService();

    private OrderDto getBrownOrder() {
        OrderDto doc = new OrderDto();
        List<OrderLineDto> lines = new ArrayList<>();
        lines.add(new OrderLineDto().setItemId("A").setQty(5));
        lines.add(new OrderLineDto().setItemId("B").setQty(3));
        doc.setId("no1").setDate(LocalDate.now()).setCustomerId("Brown").setLines(lines);
        return doc;
    }

    private OrderDto getPinkOrder() {
        OrderDto doc = new OrderDto();
        List<OrderLineDto> lines = new ArrayList<>();
        lines.add(new OrderLineDto().setItemId("B").setQty(4));
        doc.setId("no2").setDate(LocalDate.now()).setCustomerId("Pink").setLines(lines);
        return doc;
    }

    @Test
    void documentIsPutToDb(CallContext context) {
        OrderDto doc = getBrownOrder();

        srv.postOrder(context, doc);
        //Check the fact that records are in the database
        OrderHeaderCursor header = new OrderHeaderCursor(context);
        header.tryFirst();
        assertEquals(doc.getId(), header.getId());

        OrderLineCursor line = new OrderLineCursor(context);
        line.setRange(line.COLUMNS.order_id(), doc.getId());
        assertEquals(2, line.count());
    }

    @Test
     void reportReturnsAggregatedQuantities(CallContext context) {
        srv.postOrder(context, getBrownOrder());
        srv.postOrder(context, getPinkOrder());
        Map<String, Integer> result = srv.getAggregateReport(context);
        assertEquals(5, result.get("A").intValue());
        assertEquals(7, result.get("B").intValue());
    }
}

