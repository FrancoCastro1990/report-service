package com.duoc.ReportService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.ReportService.Client.OrderClient;
import com.duoc.ReportService.Model.Order;

@Service
public class ReportService implements IReportServices {

    @Autowired
    private OrderClient orderClient;

    @Override
    public List<Order> getOrdersByDateRange(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }

        // Convert java.util.Date to String format for the URL
        String startDateStr = new java.sql.Date(startDate.getTime()).toString();
        String endDateStr = new java.sql.Date(endDate.getTime()).toString();

        // Call the client method to get orders by date range
        return orderClient.getOrdersByDateRange(startDateStr, endDateStr);
    }

    @Override
    public String getTotalSalesByDateRange(Date startDate, Date endDate) {
    if (startDate == null || endDate == null) {
        throw new IllegalArgumentException("Start date and end date cannot be null");
    }

    // Convert java.util.Date to String format for the URL
    String startDateStr = new java.sql.Date(startDate.getTime()).toString();
    String endDateStr = new java.sql.Date(endDate.getTime()).toString();

    // Call the client method to get orders by date range
    // This will need to be processed or calculated after receiving the orders
    List<Order> orders = orderClient.getOrdersByDateRange(startDateStr, endDateStr);

    // Calculate total sales from the orders
    double totalSales = orders.stream()
            .mapToDouble(Order::getTotal)
            .sum();
    return String.valueOf(totalSales);
    }

    @Override
    public String getTotalSalesByStatus(String status) {
       List<Order> orders = orderClient.getAllOrders();
       double totalSales = orders.stream()
               .filter(order -> order.getStatus().equalsIgnoreCase(status))
               .mapToDouble(Order::getTotal)
               .sum();
       return String.valueOf(totalSales);
    }

    @Override
    public String getTotalSalesByClient(Long clientId) {
        List<Order> orders = orderClient.getOrdersByClientId(clientId);
        double totalSales = orders.stream()
                .mapToDouble(Order::getTotal)
                .sum();
        return String.valueOf(totalSales);
    }

}
