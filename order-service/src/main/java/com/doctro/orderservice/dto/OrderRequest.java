package com.doctro.orderservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest{

    private List<OrderLineItemsDto> orderLineItemsListDto = new ArrayList<>();
}
