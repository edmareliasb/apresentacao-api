INSERT INTO pedido (cliente_nome, total_itens, status, preco_total) VALUES ('Pedro', 2, 'SEPARACAO_EM_ESTOQUE', 3550.00);
INSERT INTO pedido (cliente_nome, total_itens, status, preco_total) VALUES ('Joao', 2, 'FINALIZADO', 4349.00);

INSERT INTO item (pedido_id, item, marca, categoria, preco) VALUES (1, 'iPhone 9', 'Apple', 'Smartphone', 3500.00);
INSERT INTO item (pedido_id, item, marca, categoria, preco) VALUES (1, 'Pelicula protetora', 'Apple', 'Smartphone - acessarios', 50.00);
INSERT INTO item (pedido_id, item, marca, categoria, preco) VALUES (2, 'Geladeira Frost Free Duplex', 'Bratemp', 'Eletrodomestico', 3690.00);
INSERT INTO item (pedido_id, item, marca, categoria, preco) VALUES (2, 'Micro-ondas 32 Litros', 'Consul', 'Eletrodomestico', 659.00);


