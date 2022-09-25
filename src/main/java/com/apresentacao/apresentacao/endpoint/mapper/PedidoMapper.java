package com.apresentacao.apresentacao.endpoint.mapper;

import com.apresentacao.apresentacao.endpoint.entity.ItemRequest;
import com.apresentacao.apresentacao.endpoint.entity.PedidoRequest;
import com.apresentacao.apresentacao.repository.entity.Item;
import com.apresentacao.apresentacao.repository.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PedidoMapper {

    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class );

    Item itemRequestToItem(ItemRequest itemRequest);

    Pedido pedidoRequestToPedido(PedidoRequest pedidoRequest);

    Pedido pedidoRequestToPedido(Pedido pedidoRequest);

}
