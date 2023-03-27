package com.doctro.orderservice.service;


import com.doctro.orderservice.dto.OrderLineItemsDto;
import com.doctro.orderservice.dto.OrderRequest;
import com.doctro.orderservice.model.Order;
import com.doctro.orderservice.model.OrderLineItems;
import com.doctro.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsListDto()
                .stream()
                .map(this::mapToDTO)
                .toList();

        order.setOrderLineItemsList(orderLineItemsList);

        orderRepository.save(order);


    }

    private OrderLineItems mapToDTO(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
