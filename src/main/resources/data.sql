--Setor atuacao
INSERT INTO setor_atuacao (descricao) VALUES
('Arquitetura e interiores'),
('Engenharia civil'),
('Desenvolvimento de software'),
('Marketing digital');


--Endereco
INSERT INTO endereco (pais, estado, cep, logradouro, bairro, numero, complemento) VALUES
('Brasil', 'DF', '71680-376', 'Condomínio Jardins do Lago quadra 2', 'Jardim Botânico', 2, 'Cj 2 Casa 4'),
('Brasil', 'SP', '01000-000', 'Avenida Paulista', 'Bela Vista', 1001, 'Apto 1501'),
('Brasil', 'RJ', '20000-000', 'Rua da Carioca', 'Centro', 500, NULL),
('Brasil', 'RS', '90000-000', 'Rua dos Andradas', 'Centro Histórico', 120, NULL);


--Empresa
INSERT INTO empresa (nome, cnpj, telefone, endereco_id, setor_atuacao_id) VALUES
('Arqline', '11414441/0001-98','61999116902', 1, 1),
('Araújo Ferreira', '41341341/0001-48','61999816902', 2, 2);


--Status orçamento
INSERT INTO status_orcamento(descricao, empresa_id) VALUES
('A enviar', 1),
('Aguardando Resposta', 1),
('Em negociação', 1),
('Aceito', 1),
('Rejeitado', 1);


--Status Serviço
INSERT INTO status_servico(descricao, empresa_id) VALUES
('Pendente', 1),
('Em progresso', 1),
('Finalizado', 1),
('Cancelado', 1);



--Administradores da empresa
INSERT INTO administrador (nome, cpf, senha, empresa_id) VALUES
('Erick Camillo', 99913431422, '123', 1),
('Ana Paula', 12345678901, '123', 1),
('Victor Ribeiro', 12345678902, '123', 2),
('André Rabelo', 12345678903, '123', 2);


-- Serviços prestados
INSERT INTO servico_prestado (descricao, empresa_id) VALUES
('Planejamento', 1),
('Esquadrias', 1),
('Marcenaria', 1),
('Acabamento', 1),
('Pintura', 1);


--Status razão encerramento da obra
INSERT INTO razao_encerramento_obra(descricao, empresa_id) VALUES
('Obra finalizada', 1),
('Desistência da empresa', 1),
('Desistência do contratante', 1);


--Serviços extras de uma empresa
INSERT INTO servico_extra (descricao, empresa_id) VALUES
('Serviço de Marketing Digital', 1),
('Serviço de Consultoria Financeira', 1),
('Serviço de Desenvolvimento Web', 1),
('Serviço de Design Gráfico', 1);


-- Inserir clientes
INSERT INTO cliente (cpf, nome, email, celular, senha, endereco_id) VALUES
(12345634567, 'João Silva', 'joaosilva@gmail.com', '61999116901', 'senha123', 1),
(23456745678, 'Maria Santos', 'mariasantos@gmail.com', '61999116902', 'senha123', 2),
(34567856789, 'Pedro Oliveira', 'pedrooliveira@gmail.com', '61999116903', 'senha123', 3);


-- Inserir relacionamentos entre clientes e empresas
INSERT INTO cliente_empresa (cliente_id, empresa_id)
VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(1, 2);


-- Inserir orçamentos
INSERT INTO orcamento (descricao, valor_contrato, data_envio, data_validade, observacao, endereco_id, cliente_id, empresa_id, status_id) VALUES
('Projeto de design de interiores para uma residência de luxo.', 5000, '2023-02-11', '2023-02-19', 'Observação do contrato 1', 1, 1, 1, 4),
('Contrato de construção civil para uma nova sede corporativa.', 6000, '2023-04-20', '2023-04-30', 'Esse já foi finalizado', 3, 3, 1, 4),
('Serviços de consultoria em arquitetura para um projeto comercial.', 7000, '2023-03-15', '2023-03-25', 'Observação do contrato 2', 2, 2, 2, 2);


-- Inserir obras
INSERT INTO obra (ativa, orcamento_id, razao_encerramento) VALUES
(1, 1, NULL),
(0, 2, 1);


-- Inserir serviços de um orçamento
INSERT INTO servico_contrato (obra_id, status_id, servico_prestado_id, orcamento_id) VALUES
(1, 3, 1, 1),
(1, 3, 2, 1),
(2, 4, 2, 2),
(NULL, 1, 3, 3);


--Insert imagens ao serviço relacionado
INSERT INTO imagens (nome_do_arquivo, tipo_do_arquivo, conteudo, servico_id) VALUES
('euemomis.png', 'image/jpeg', 'my-content', 1),
('euemomis.png', 'image/jpeg', 'mycontent', 2),
('euemomis.png', 'image/jpeg', 'mycontent', 2);








