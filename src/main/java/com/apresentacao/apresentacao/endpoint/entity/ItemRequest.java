package com.apresentacao.apresentacao.endpoint.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemRequest {

    private String item;

    private String marca;

    private String categoria;

    private Double preco;

}
