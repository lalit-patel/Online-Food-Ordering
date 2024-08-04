package com.patel.request;

import lombok.Data;

import java.util.List;

@Data
public class AddToCartItemRequest {

    private Long foodID;
    private int quantity;
    private List<String> ingredients;
}
