-- USUARIOS

-- Criando uma tabela de usuarios
CREATE TABLE usuarios (
	id SERIAL PRIMARY KEY,
	usuario VARCHAR(50) NOT NULL UNIQUE,
	senha VARCHAR(100) NOT NULL,
	perfil VARCHAR(20) NOT NULL CHECK (perfil IN ('PARCIAL', 'COMPLETO'))
);

INSERT INTO usuarios (usuario, senha, perfil)
VALUES ('Administrador', md5('bombom'), 'COMPLETO');

SELECT * FROM usuarios;


UPDATE usuarios SET senha = 'bombom' WHERE id = 1;
UPDATE usuarios SET senha = '0139937a6bc9a6adf1a8384f44cad902' WHERE id = 1;
