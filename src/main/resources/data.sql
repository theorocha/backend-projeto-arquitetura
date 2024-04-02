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
INSERT INTO empresa (nome, cnpj, endereco_id, setor_atuacao_id) VALUES
('ArqLine', '11414441/0001-98', 1, 1);

--Administradores da empresa
INSERT INTO administrador (nome, cpf, senha, empresa_id) VALUES
('Erick Camillo', '999.134.314-22', '123', 1),
('Ana Paula', '123.456.789-00', '123', 1);

--Serviços extras de uma empresa
INSERT INTO servico_extra (descricao, empresa_id) VALUES
('Serviço de Marketing Digital', 1),
('Serviço de Consultoria Financeira', 1),
('Serviço de Desenvolvimento Web', 1),
('Serviço de Design Gráfico', 1);

--Status
INSERT INTO status_servico (descricao) VALUES ('PENDENTE');
INSERT INTO status_servico (descricao) VALUES ('EM_ANDAMENTO');
INSERT INTO status_servico (descricao) VALUES ('CONCLUIDO');
INSERT INTO status_servico (descricao) VALUES ('CANCELADO');

--Serviços que uma empresa presta
INSERT INTO servico_prestado (descricao, status_id, empresa_id) VALUES
('Serviço de Consultoria Financeira', 1, 1),
('Serviço de Marketing Digital', 2, 1),
('Serviço de Desenvolvimento Web', 3, 1),
('Serviço de Design Gráfico', 4, 1);

