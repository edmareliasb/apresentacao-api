package com.apresentacao.apresentacao.endpoint.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoResponse {

    private Long id;

    private String clienteNome;

    private Long totalItens;

    private String status;

    private Double precoTotal;

    private List<ItemResponse> itens;

}
