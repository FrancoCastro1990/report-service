package com.duoc.ReportService.Service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.ReportService.Model.Order;

@Service
public interface IReportServices {


    List<Order> getOrdersByDateRange(Date startDate, Date endDate);
    //String getOrdersByStatus(String status);
    //String getTotalSales();
    String getTotalSalesByDateRange(Date startDate, Date endDate);
    String getTotalSalesByStatus(String status);
    String getTotalSalesByClient(Long clientId);
}
