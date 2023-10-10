CREATE TABLE TAREFA (

        id SERIAL PRIMARY KEY,
        titulo TEXT not null ,
        descricao TEXT,
        responsavel TEXT not null,
        prioridade TEXT not null,
        deadline TEXT not null ,
        situacao BOOLEAN not null

)