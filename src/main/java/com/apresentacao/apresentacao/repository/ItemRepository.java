package com.apresentacao.apresentacao.repository;

import com.apresentacao.apresentacao.repository.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByPedidoId(Long id);

    Item findByIdAndPedidoId(Long itemId, Long pedidoId);
}
