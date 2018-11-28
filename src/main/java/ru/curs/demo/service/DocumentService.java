package ru.curs.demo.service;

import org.springframework.stereotype.Service;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.transaction.CelestaTransaction;
import ru.curs.demo.OrderHeaderCursor;
import ru.curs.demo.OrderLineCursor;
import ru.curs.demo.OrderedQtyCursor;
import ru.curs.demo.dto.OrderDto;
import ru.curs.demo.dto.OrderLineDto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentService {
    private final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @CelestaTransaction
    public void postOrder(CallContext context, OrderDto doc) {
        try (OrderHeaderCursor header = new OrderHeaderCursor(context);
             OrderLineCursor line = new OrderLineCursor(context)) {
            header.setId(doc.getId());
            header.setDate(Date.from(doc.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            header.setCustomer_id(doc.getCustomerId());
            header.setCustomer_name(doc.getCustomerName());
            header.insert();
            int lineNo = 0;
            for (OrderLineDto docLine : doc.getLines()) {
                lineNo++;
                line.setLine_no(lineNo);
                line.setOrder_id(doc.getId());
                line.setItem_id(docLine.getItemId());
                line.setQty(docLine.getQty());
                line.insert();
            }
        }
    }

    @CelestaTransaction
    public Map<String, Integer> getAggregateReport(CallContext context) {
        Map<String, Integer> result = new HashMap<>();
        try (OrderedQtyCursor ordered_qty = new OrderedQtyCursor(context)) {
            for (OrderedQtyCursor line : ordered_qty) {
                result.put(ordered_qty.getItem_id(), ordered_qty.getQty());
            }
        }
        return result;
    }
}
