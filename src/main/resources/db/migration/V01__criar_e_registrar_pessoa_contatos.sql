CREATE TABLE `bravi`.`pessoa` (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `bravi`.`pessoa` ( nome) values ( 'Pessoa 1');
INSERT INTO `bravi`.`pessoa` ( nome) values ( 'Pessoa 2');

CREATE TABLE `bravi`.`contato` (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50) NOT NULL,
    watsapp VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `bravi`.`contato` ( email,watsapp ) values ( 'teste@bravi.com 1','watsapp 1 123456');
INSERT INTO `bravi`.`contato` ( email,watsapp ) values ( 'teste@bravi.com 2','watsapp 2 321654');

CREATE TABLE `bravi`.`pessoa_contato`(
	codigo_pessoa bigint(20) not null,
	codigo_contato bigint(20)not null,
	primary key(codigo_pessoa, codigo_contato),
	FOREIGN KEY (codigo_pessoa) references pessoa(codigo),
	FOREIGN KEY (codigo_contato) references contato(codigo)
	
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into pessoa_contato(codigo_pessoa, codigo_contato) values(1,1);
insert into pessoa_contato(codigo_pessoa, codigo_contato) values(1,2);
insert into pessoa_contato(codigo_pessoa, codigo_contato) values(2,1);

