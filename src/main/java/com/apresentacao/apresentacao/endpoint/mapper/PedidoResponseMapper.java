package com.apresentacao.apresentacao.endpoint.mapper;

import com.apresentacao.apresentacao.endpoint.entity.ItemResponse;
import com.apresentacao.apresentacao.endpoint.entity.PedidoResponse;
import com.apresentacao.apresentacao.repository.entity.Item;
import com.apresentacao.apresentacao.repository.entity.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PedidoResponseMapper {

    PedidoResponseMapper INSTANCE = Mappers.getMapper(PedidoResponseMapper.class );

    @Mapping(source = "item.pedido.id", target = "idPedido")
    ItemResponse itemToItemResponse(Item item);

    PedidoResponse pedidoToPedidoResponse(Pedido pedido);

    List<PedidoResponse> pedidosToPedidoResponse(List<Pedido> pedidos);

 
}
