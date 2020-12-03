package ru.curs.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.curs.celesta.CallContext;
import ru.curs.celesta.SystemCallContext;
import ru.curs.demo.dto.OrderDto;
import ru.curs.demo.service.DocumentService;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DocumentController {
    private final DocumentService srv;

    public DocumentController(DocumentService srv) {
        this.srv = srv;
    }

    @PutMapping("/save")
    public void saveOrder(@RequestBody OrderDto order) {
        CallContext ctx = new SystemCallContext();
        srv.postOrder(ctx, order);
    }

    @GetMapping("/report")
    public Map<String, Integer> getReport() {
        CallContext ctx = new SystemCallContext();
        return srv.getAggregateReport(ctx);
    }
}
