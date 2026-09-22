package com.fatec.product.dtos;

public record ProductRequest(
    String name,
    String description,
    Double price

) {
    
}
