package com.duoc.ReportService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {

    private Long id;
    private Long productId;
    private Integer quantity;
    private Double price;

    private Long orderId;
}
