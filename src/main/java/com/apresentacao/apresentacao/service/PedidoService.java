package com.apresentacao.apresentacao.service;

import com.apresentacao.apresentacao.exception.ObjetoNotFoundException;
import com.apresentacao.apresentacao.repository.ItemRepository;
import com.apresentacao.apresentacao.repository.PedidoRepository;
import com.apresentacao.apresentacao.repository.entity.Item;
import com.apresentacao.apresentacao.repository.entity.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemRepository itemRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long pedidoId) {
        return validaPedidoExistente(pedidoId);
    }

    public List<Item> getItensByPedidoId(Long pedidoId) {
        return itemRepository.findByPedidoId(pedidoId);
    }

    public Item getItemByIdPedidoAndIdItem(Long pedidoId, Long itemId) {
        return itemRepository.findByIdAndPedidoId(itemId, pedidoId);
    }

    public Long createPedido(Pedido pedido) {
        List<Item> itens = pedido.getItens();

        Double valorTotal = 0D;
        for (Item item : itens) {
            valorTotal+= item.getPreco();
        }

        pedido.setTotalItens((long) itens.size());
        pedido.setPrecoTotal(valorTotal);
        pedido.setStatus("AGUARDANDO_PAGAMENTO");
        Pedido pedidoSaved = pedidoRepository.save(pedido);

        for (Item item : pedido.getItens()) {
            item.setPedido(pedido);
            itemRepository.save(item);
        }

        return pedidoSaved.getId();
    }

    public void updateStatusPedido(Long pedidoId, String status) {
        Pedido pedido = validaPedidoExistente(pedidoId);
        pedido.setStatus(status);
        pedidoRepository.save(pedido);
    }

    public void deleteItem(Long pedidoId, Long itemId) {
        Item item = validaItemPedidoExistente(itemId);
        Pedido pedido = validaPedidoExistente(pedidoId);

        Double precoTotalPedidoAtualizado = pedido.getPrecoTotal() - item.getPreco();
        pedido.setPrecoTotal(precoTotalPedidoAtualizado);

        itemRepository.deleteById(itemId);
        pedidoRepository.save(pedido);

    }

    private Pedido validaPedidoExistente(Long pedidoId) {
        Optional<Pedido> optionalPedido = pedidoRepository.findById(pedidoId);
        if (optionalPedido.isPresent()) {
            return optionalPedido.get();
        } else {
            throw new ObjetoNotFoundException("PEDIDO_NOT_FOUND", "Pedido não encontrado para o id " + pedidoId);
        }
    }

    private Item validaItemPedidoExistente(Long itemId) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            return itemOptional.get();
        } else {
            throw new ObjetoNotFoundException("ITEM_NOT_FOUND", "Item não encontrado para o id " + itemId);
        }
    }

}