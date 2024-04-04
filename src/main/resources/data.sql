--Setor atuacao
INSERT INTO setor_atuacao (descricao) VALUES
('Arquitetura e interiores'),
('Engenharia civil'),
('Desenvolvimento de software'),
('Marketing digital');

--Status orçamento
INSERT INTO status_orcamento(descricao) VALUES
('A enviar'),
('Aguardando Resposta'),
('Em negociação'),
('Aceito'),
('Rejeitado');

--Status Serviço
INSERT INTO status_servico(descricao) VALUES
('Pendente'),
('Em progresso'),
('Finalizado'),
('Cancelado');

--Endereco
INSERT INTO endereco (pais, estado, cep, logradouro, bairro, numero, complemento) VALUES
('Brasil', 'DF', '71680-376', 'Condomínio Jardins do Lago quadra 2', 'Jardim Botânico', 2, 'Cj 2 Casa 4'),
('Brasil', 'SP', '01000-000', 'Avenida Paulista', 'Bela Vista', 1001, 'Apto 1501'),
('Brasil', 'RJ', '20000-000', 'Rua da Carioca', 'Centro', 500, NULL),
('Brasil', 'RS', '90000-000', 'Rua dos Andradas', 'Centro Histórico', 120, NULL);

--Empresa
INSERT INTO empresa (nome, cnpj, endereco_id, setor_atuacao_id) VALUES
('Arqline', '11414441/0001-98', 1, 1);

--Administradores da empresa
INSERT INTO administrador (nome, cpf, senha, empresa_id) VALUES
('Erick Camillo', '999.134.314-22', '123', 1),
('Ana Paula', '123.456.789-00', '123', 1);

-- Serviços prestados
INSERT INTO servico_prestado (descricao, status_id, empresa_id) VALUES
('Planejamento', 1, 1),
('Esquadrias', 2, 1),
('Marcenaria', 3, 1),
('Acabamento', 4, 1),
('Pintura', 1, 1);

--Serviços extras de uma empresa
INSERT INTO servico_extra (descricao, empresa_id) VALUES
('Serviço de Marketing Digital', 1),
('Serviço de Consultoria Financeira', 1),
('Serviço de Desenvolvimento Web', 1),
('Serviço de Design Gráfico', 1);





