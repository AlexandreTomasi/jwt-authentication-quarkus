CREATE TABLE public.pessoa (
	pes_id int8 NOT NULL,
	pes_nome varchar(200) NOT NULL,
	pes_cpf int8 NULL,
	pes_dt_nascimento date NULL,
	pes_nome_mae varchar(200) NULL,
	pes_nome_pai varchar(200) NULL,
	pes_data_hora_cadastro timestamp NULL,
	pes_estado_civil varchar(50) NULL,
	pes_email varchar(200) NULL,
	pes_sexo varchar(15) NULL,
	pes_ativo bool NOT NULL,
	pes_password varchar(200) NULL,
	CONSTRAINT pessoa_pkey PRIMARY KEY (pes_id)
);

CREATE TABLE public.perfil (
	perf_id int8 NOT NULL,
	perf_nome varchar(100) NOT NULL,
	perf_descricao varchar(200) NULL,
	perf_ativo bool NOT NULL,
	CONSTRAINT perfil_pkey PRIMARY KEY (perf_id)
);

CREATE TABLE public.pessoa_perfil (
    pes_id int8 NOT NULL,
    perf_id int8 NOT NULL
);
ALTER TABLE public.pessoa_perfil ADD CONSTRAINT fk_pessoa_perfil_pes_id FOREIGN KEY (pes_id) REFERENCES pessoa(pes_id);
ALTER TABLE public.pessoa_perfil ADD CONSTRAINT fk_pessoa_perfil_perf_id FOREIGN KEY (perf_id) REFERENCES perfil(perf_id);


CREATE TABLE public.regras (
	reg_id int8 NOT NULL,
	reg_nome varchar(100) NULL,
	reg_descricao varchar(100) NULL,
	reg_tipo varchar(50) null,
	CONSTRAINT regras_pkey PRIMARY KEY (reg_id)
);

CREATE TABLE public.perfil_regras (
    perf_id int8 NOT NULL,
    reg_id int8 NOT NULL
);
ALTER TABLE public.perfil_regras ADD CONSTRAINT fk_perfil_regras_perf_id FOREIGN KEY (perf_id) REFERENCES perfil(perf_id);
ALTER TABLE public.perfil_regras ADD CONSTRAINT fk_perfil_regras_reg_id FOREIGN KEY (reg_id) REFERENCES regras(reg_id);

CREATE EXTENSION IF NOT EXISTS unaccent;