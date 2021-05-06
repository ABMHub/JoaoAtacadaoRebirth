CREATE DATABASE JoaoAtacadao; 
USE JoaoAtacadao;

CREATE TABLE IF NOT EXISTS Produto
(
	codigo_de_barras 	VARCHAR(50) PRIMARY KEY NOT NULL,
    nome			 	VARCHAR(50) NOT NULL,
    valor			 	FLOAT NOT NULL,
    marca			 	VARCHAR(50) NOT NULL,
    categoria			VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Vestuario
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	tamanho				VARCHAR(50)	NOT NULL,
    cor			     	VARCHAR(50) NOT NULL,
    material			VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Eletroeletronico
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	consumo_de_energia	VARCHAR(50)	NOT NULL,
    potencia	     	VARCHAR(50) NOT NULL,
    smart				BOOLEAN NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Computador
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	processador			VARCHAR(50)	NOT NULL,
    gpu			     	VARCHAR(50) NOT NULL,
    rgb			     	BOOLEAN NOT NULL,
    memoria				VARCHAR(50) NOT NULL,
    fonte				VARCHAR(50) NOT NULL,
    
    cor					VARCHAR(50) NOT NULL,
    modelo				VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Celular
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	processador			VARCHAR(50)	NOT NULL,
    tamanho		     	VARCHAR(50) NOT NULL,
    memoria				VARCHAR(50) NOT NULL,
    camera				VARCHAR(50) NOT NULL,
    
    cor					VARCHAR(50) NOT NULL,
    modelo				VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Periferico
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	tipo				VARCHAR(50)	NOT NULL,
    padrao_de_entrada	VARCHAR(50) NOT NULL,
    
    cor					VARCHAR(50) NOT NULL,
    modelo				VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Filme
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	diretor				VARCHAR(50)	NOT NULL,
    duracao		     	INT NOT NULL,
    
    faixa_etaria		VARCHAR(50) NOT NULL,
    tema				VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);


CREATE TABLE IF NOT EXISTS livro
(
	codigo_de_barras 	VARCHAR(50) NOT NULL PRIMARY KEY,
	autor				VARCHAR(50)	NOT NULL,
    qtd_paginas	     	INT NOT NULL,
    editora				VARCHAR(50) NOT NULL,
    isbn				VARCHAR(50) NOT NULL,
    
	faixa_etaria		VARCHAR(50) NOT NULL,
    tema				VARCHAR(50) NOT NULL,
    
    FOREIGN KEY(codigo_de_barras) REFERENCES Produto(codigo_de_barras)
);

CREATE TABLE IF NOT EXISTS Cliente
(
	cpf				 	VARCHAR(50) PRIMARY KEY NOT NULL,
	nome			 	VARCHAR(30) NOT NULL,
    data_de_nascimento	DATE NOT NULL,
	saldo				FLOAT NOT NULL,
    senha				VARCHAR(50) NOT NULL
);



CREATE TABLE IF NOT EXISTS Funcionario
(
	cpf				 	VARCHAR(50) PRIMARY KEY NOT NULL,
	nome			 	VARCHAR(30) NOT NULL,
    data_de_nascimento	DATE NOT NULL,
	salario				FLOAT NOT NULL,
    gerente				BOOLEAN NOT NULL,
    senha				VARCHAR(30),
    imagem				BLOB
);

CREATE TABLE IF NOT EXISTS Carrinho
(
    numero_da_compra     INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    cpf_do_cliente         VARCHAR(30) NOT NULL,
    data_de_compra        DATE NOT NULL,
    cpf_do_funcionario  VARCHAR(50) NOT NULL, 
    
    FOREIGN KEY(cpf_do_cliente) REFERENCES Cliente(cpf),
    FOREIGN KEY(cpf_do_funcionario) REFERENCES Funcionario(cpf)
    
);

CREATE TABLE IF NOT EXISTS ItemPedido
(
    codigo_de_barras     VARCHAR(50) NOT NULL,
    numero_da_compra     INT NOT NULL,
    qtd_de_itens        INT NOT NULL,
    
    FOREIGN KEY(codigo_de_barras)   REFERENCES Produto(codigo_de_barras),
    FOREIGN KEY(numero_da_compra)   REFERENCES Carrinho(numero_da_compra),
    
    PRIMARY KEY(codigo_de_barras, numero_da_compra)
);

CREATE TABLE IF NOT EXISTS ImagensPadrao
(
	id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    imagem BLOB
);

CREATE VIEW view_historico AS
	SELECT ItemPedido.numero_da_compra, ItemPedido.codigo_de_barras, nome, valor as "valor da unidade", 
    qtd_de_itens, DATE_FORMAT (`data_de_compra`,'%d/%m/%Y') as data_da_compra, Carrinho.cpf_do_cliente 
    FROM ItemPedido
    INNER JOIN Produto ON ItemPedido.codigo_de_barras = Produto.codigo_de_barras
    INNER JOIN Carrinho ON ItemPedido.numero_da_compra = Carrinho.numero_da_compra
    ORDER BY ItemPedido.numero_da_compra, ItemPedido.codigo_de_barras;
        

CREATE VIEW view_livro AS
	SELECT produto.codigo_de_barras, nome, valor, marca, autor, qtd_paginas, editora, isbn, faixa_etaria, tema 
    FROM produto
    INNER JOIN livro ON livro.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;
    
CREATE VIEW view_vestuario AS
	SELECT produto.codigo_de_barras, nome, valor, marca, tamanho, cor, material
    FROM produto
    INNER JOIN vestuario ON vestuario.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;
    
CREATE VIEW view_eletroeletronico AS
	SELECT produto.codigo_de_barras, nome, valor, marca, consumo_de_energia, potencia, smart	
    FROM produto
    INNER JOIN eletroeletronico ON eletroeletronico.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;
    
CREATE VIEW view_computador AS
	SELECT produto.codigo_de_barras, nome, valor, marca, processador, gpu, rgb, memoria, fonte, cor, modelo
    FROM produto
    INNER JOIN computador ON computador.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;
    
CREATE VIEW view_celular AS
	SELECT produto.codigo_de_barras, nome, valor, marca, processador, tamanho, memoria, camera, cor, modelo
    FROM produto
    INNER JOIN celular ON celular.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;   

CREATE VIEW view_periferico AS
	SELECT produto.codigo_de_barras, nome, valor, marca, tipo, padrao_de_entrada, cor, modelo	
    FROM produto
    INNER JOIN periferico ON periferico.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;      

CREATE VIEW view_filme AS
	SELECT produto.codigo_de_barras, nome, valor, marca, diretor, duracao, faixa_etaria, tema
    FROM produto
    INNER JOIN filme ON filme.codigo_de_barras = produto.codigo_de_barras
    ORDER BY nome;			

DELIMITER $$
CREATE PROCEDURE cria_carrinho(IN cpf_cliente varchar(30), IN data_de_compra DATE, IN cpf_funcionario varchar(40))
BEGIN
INSERT INTO carrinho values (0, cpf_cliente, data_de_compra, cpf_funcionario);
select last_insert_id() as id from Carrinho group by id;
END $$

DELIMITER $$
CREATE PROCEDURE GerarImagem(IN cpf_func varchar(50))
BEGIN
    declare imge blob;
    DECLARE num1 INT;
    DECLARE num2 INT;
    DECLARE num3 INT;

    IF not exists(SELECT imagem FROM Funcionario WHERE Funcionario.cpf = cpf_func and funcionario.imagem is not null) THEN
		 SELECT COUNT(*) into num1 FROM ImagensPadrao;

		SELECT FLOOR(RAND()*(num1)) into num2;

		select imagem from ImagensPadrao limit num2, 1;
	else
		   select imagem from funcionario where funcionario.cpf = cpf_func;
    END IF;
END $$
DELIMITER ;