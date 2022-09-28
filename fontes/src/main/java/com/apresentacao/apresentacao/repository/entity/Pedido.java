package com.apresentacao.apresentacao.repository.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_nome")
    private String clienteNome;

    @Column(name = "total_itens")
    private Long totalItens;

    private String status;

    @Column(name = "preco_total")
    private Double precoTotal;

    @OneToMany(mappedBy="pedido")
    private List<Item> itens;

}