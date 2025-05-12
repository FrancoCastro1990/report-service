package com.duoc.ReportService.Model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Long id;
    
    private Long clientId;
    private Date orderDate;
    private Double total = 0.0;
    private String status; // Default status is "Created", "In Process", "Shipped", "Completed"

    private List<OrderItem> items;
}

