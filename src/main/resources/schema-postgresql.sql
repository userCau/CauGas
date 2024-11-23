/* Serial = inteiro e autoincrement */
CREATE TABLE IF NOT EXISTS cliente (
    id serial PRIMARY KEY, 
    nome varchar(50),
    cpf varchar(14),
    celular varchar(15), 
    endereco text
);
        -- comando magico: ( drop schema public; )