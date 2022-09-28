package com.apresentacao.apresentacao.endpoint.entity;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long id;

    private Long idPedido;

    private String item;

    private String marca;

    private String categoria;

    private Double preco;

}