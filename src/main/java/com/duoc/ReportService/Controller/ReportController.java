package com.duoc.ReportService.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.ReportService.Model.Order;
import com.duoc.ReportService.Service.IReportServices;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    private IReportServices reportServices;

    // Endpoint to get orders by date range
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrdersByDateRange(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
        ) {
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        List<Order> orders = reportServices.getOrdersByDateRange(startDate, endDate);
        return ResponseEntity.ok(orders);
    }

    // Endpoint to get total sales by date range
    @GetMapping("/sales")
    public ResponseEntity<String> getTotalSalesByDateRange(
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, 
        @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        String sales = reportServices.getTotalSalesByDateRange(startDate, endDate);
        return ResponseEntity.ok(sales);
    }

    // Endpoint to get total sales by status
    @GetMapping("/sales/status")
    public ResponseEntity<String> getTotalSalesByStatus(@RequestParam String status) {
        String sales = reportServices.getTotalSalesByStatus(status);
        return ResponseEntity.ok(sales);
    }

    // Endpoint to get total sales by client
    @GetMapping("/sales/client")
    public ResponseEntity<String> getTotalSalesByClient(@RequestParam Long clientId) {
        String sales = reportServices.getTotalSalesByClient(clientId);
        return ResponseEntity.ok(sales);
    }
}
