package ru.clevertec;

import ru.clevertec.model.Customer;
import ru.clevertec.model.Order;
import ru.clevertec.model.Product;
import ru.clevertec.util.JsonSerializer;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        Map<UUID, BigDecimal> priceMap1 = new HashMap<>();
        priceMap1.put(productId1, new BigDecimal("99.99"));
        priceMap1.put(productId2, new BigDecimal("79.99"));
        Product product1 = new Product(productId1, "Product 1", 99.99, priceMap1);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);

        UUID orderId = UUID.randomUUID();
        OffsetDateTime createDate = OffsetDateTime.now();
        Order order = new Order(orderId, productList, createDate);

        List<Order> orders = new ArrayList<>();
        orders.add(order);

        UUID customerId = UUID.randomUUID();
        Customer customer = new Customer(customerId, "John", "Doe", OffsetDateTime.now(), orders);

        String json = JsonSerializer.toJson(customer);
        System.out.println("Serialized JSON: " + json);
    }
}