package com.apresentacao.apresentacao.endpoint.mapper;

import com.apresentacao.apresentacao.endpoint.entity.ItemResponse;
import com.apresentacao.apresentacao.repository.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ItemResponseMapper {

    ItemResponseMapper INSTANCE = Mappers.getMapper(ItemResponseMapper.class );

    @Mapping(source = "item.pedido.id", target = "idPedido")
    ItemResponse itemToItemResponse(Item item);

    List<ItemResponse> itensToItemResponse(List<Item> itens);
}
