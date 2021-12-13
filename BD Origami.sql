BEGIN;


CREATE TABLE public.carrinho
(
    id integer NOT NULL,
    valor double precision,
    item integer,
    emailcli character varying(50),
    PRIMARY KEY (id)
);

CREATE TABLE public.categoria
(
    id integer NOT NULL,
    descricao character varying(100),
    sigla character varying(4),
    PRIMARY KEY (id)
);

CREATE TABLE public.cliente
(
    id integer NOT NULL,
    telefone numeric(10, 0),
    endereco integer,
    carrinho integer,
    pedido integer,
    senha character varying(200),
    repetesenha character varying(200),
    nome character varying(50),
    email character varying(100),
    cpf character varying(15),
    PRIMARY KEY (id)
);

CREATE TABLE public.devolucao
(
    id integer NOT NULL,
    nome character varying(50),
    cpf character varying(14),
    email character varying(80),
    motivo character varying(200),
    numpedido integer,
    path character varying,
    filename character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.endereco
(
    id integer NOT NULL,
    uf character varying(3),
    cidade character varying(50),
    bairro character varying(50),
    logradouro character varying(50),
    numero numeric(10, 0),
    complemento character varying(50),
    cep character varying(10),
    PRIMARY KEY (id)
);

CREATE TABLE public.fabricante
(
    id integer NOT NULL,
    descricao character varying(100),
    sigla character varying(4),
    cnpj character varying,
    PRIMARY KEY (id)
);

CREATE TABLE public.funcionario
(
    id integer NOT NULL,
    sobrenome character varying(30),
    registro integer,
    senha character varying(200),
    repetesenha character varying(200),
    nome character varying(200),
    cpf character varying(14),
    PRIMARY KEY (id)
);

CREATE TABLE public.item
(
    id integer NOT NULL,
    qtdd integer,
    produto integer,
    valor double precision,
    carrinho integer,
    pedido integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.pedido
(
    id integer NOT NULL,
    data_compra date,
    data_entrega date,
    status boolean,
    carrinho integer,
    cliente integer,
    funcionario integer,
    valor double precision,
    PRIMARY KEY (id)
);

CREATE TABLE public.produto
(
    id integer NOT NULL,
    descricao character varying(100),
    dataentrada date,
    quantidade integer,
    preco double precision,
    categoria integer,
    fabricante integer,
    quantminima integer,
    path character varying,
    filename character varying,
    peso double precision,
    material character varying(50),
    uniembalagem integer,
    cor character varying(50),
    dimensao character varying(50),
    titulo character varying(50),
    PRIMARY KEY (id)
);

ALTER TABLE public.carrinho
    ADD FOREIGN KEY (item)
    REFERENCES public.item (id)
    NOT VALID;


ALTER TABLE public.cliente
    ADD FOREIGN KEY (carrinho)
    REFERENCES public.carrinho (id)
    NOT VALID;


ALTER TABLE public.cliente
    ADD FOREIGN KEY (endereco)
    REFERENCES public.endereco (id)
    NOT VALID;


ALTER TABLE public.cliente
    ADD FOREIGN KEY (pedido)
    REFERENCES public.pedido (id)
    NOT VALID;


ALTER TABLE public.item
    ADD FOREIGN KEY (carrinho)
    REFERENCES public.carrinho (id)
    NOT VALID;


ALTER TABLE public.item
    ADD FOREIGN KEY (pedido)
    REFERENCES public.pedido (id)
    NOT VALID;


ALTER TABLE public.item
    ADD FOREIGN KEY (produto)
    REFERENCES public.produto (id)
    NOT VALID;


ALTER TABLE public.pedido
    ADD FOREIGN KEY (carrinho)
    REFERENCES public.carrinho (id)
    NOT VALID;


ALTER TABLE public.produto
    ADD FOREIGN KEY (categoria)
    REFERENCES public.categoria (id)
    NOT VALID;


ALTER TABLE public.produto
    ADD FOREIGN KEY (fabricante)
    REFERENCES public.fabricante (id)
    NOT VALID;

END;
