package com.apresentacao.apresentacao.endpoint;

import com.apresentacao.apresentacao.endpoint.entity.AtualizaStatusPedidoResquest;
import com.apresentacao.apresentacao.endpoint.entity.ItemResponse;
import com.apresentacao.apresentacao.endpoint.entity.PedidoRequest;
import com.apresentacao.apresentacao.endpoint.entity.PedidoResponse;
import com.apresentacao.apresentacao.endpoint.mapper.ItemResponseMapper;
import com.apresentacao.apresentacao.endpoint.mapper.PedidoMapper;
import com.apresentacao.apresentacao.endpoint.mapper.PedidoResponseMapper;
import com.apresentacao.apresentacao.repository.entity.Item;
import com.apresentacao.apresentacao.repository.entity.Pedido;
import com.apresentacao.apresentacao.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PedidoEndpoint {

    private final PedidoService pedidoService;

    @GetMapping(value = "/pedidos")
    public List<PedidoResponse> getPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        return PedidoResponseMapper.INSTANCE.pedidosToPedidoResponse(pedidos);
    }

    @GetMapping(value = "/pedidos/{id}")
    public PedidoResponse getPedidoById(@PathVariable("id") Long pedidoId) {
        Pedido pedido = pedidoService.getPedidoById(pedidoId);
        return PedidoResponseMapper.INSTANCE.pedidoToPedidoResponse(pedido);
    }

    @GetMapping(value = "/pedidos/{id}/itens")
    public List<ItemResponse> getItensByIdPedido(@PathVariable("id") Long pedidoId) {
        List<Item> itens = pedidoService.getItensByPedidoId(pedidoId);
        return ItemResponseMapper.INSTANCE.itensToItemResponse(itens);
    }

    @GetMapping(value = "/pedidos/{id}/itens/{item-id}")
    public ItemResponse getItemByIdItemAndIdPedido(@PathVariable("id") Long pedidoId, @PathVariable("item-id") Long itemId) {
        Item item = pedidoService.getItemByIdPedidoAndIdItem(pedidoId, itemId);
        return ItemResponseMapper.INSTANCE.itemToItemResponse(item);
    }

    @PostMapping(value = "/pedidos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> pedidoCreate(@RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = PedidoMapper.INSTANCE.pedidoRequestToPedido(pedidoRequest);
        Long idPedidoSaved = pedidoService.createPedido(pedido);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pedido criado com sucesso. Id "+ idPedidoSaved);
    }

    @PutMapping(value = "/pedidos/atualiza-status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> pedidoUpdate(@PathVariable("id") Long pedidoId, @RequestBody AtualizaStatusPedidoResquest pedidoRequest) {
        pedidoService.updateStatusPedido(pedidoId, pedidoRequest.getStatus());

        return ResponseEntity.status(HttpStatus.OK).body("Status do Pedido Atualizado com sucesso.");
    }

    @DeleteMapping(value = "/pedidos/{id}/itens/{item-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void itemPedidoDelete(@PathVariable("id") Long pedidoId, @PathVariable("item-id") Long itemId) {
        pedidoService.deleteItem(pedidoId, itemId);
    }

}
