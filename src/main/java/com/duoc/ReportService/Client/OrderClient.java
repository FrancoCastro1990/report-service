package com.duoc.ReportService.Client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.duoc.ReportService.Model.Order;

@Service
public class OrderClient {
        private final RestTemplate restTemplate;
        private final String orderServiceUrl = "http://localhost:8082/api/orders";

        public OrderClient(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

        public List<Order> getAllOrders() {
            return Arrays.asList(restTemplate.getForObject(orderServiceUrl, Order[].class));
        }

        public Order getOrderById(Long orderId) {
            String url = orderServiceUrl + "/" + orderId;
            return restTemplate.getForObject(url, Order.class);
        }

        public List<Order> getOrdersByClientId(Long clientId) {
            String url = orderServiceUrl + "/client/" + clientId;
            return Arrays.asList(restTemplate.getForObject(url, Order[].class));
        }

        public  List<Order> getOrdersByDateRange(String startDate, String endDate) {
            String url = orderServiceUrl + "/date-range?startDate=" + startDate + "&endDate=" + endDate;
            return Arrays.asList(restTemplate.getForObject(url, Order[].class));
        }
}
