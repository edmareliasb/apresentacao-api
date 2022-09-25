package com.apresentacao.apresentacao.endpoint.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class PedidoRequest {

    private String clienteNome;

    private List<ItemRequest> itens;

}
