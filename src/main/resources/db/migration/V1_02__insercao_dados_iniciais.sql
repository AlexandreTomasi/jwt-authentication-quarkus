INSERT INTO public.regras
(reg_id, reg_nome, reg_descricao, reg_tipo)
VALUES(1, 'pessoa', 'put', 'UPDATE');
INSERT INTO public.regras
(reg_id, reg_nome, reg_descricao, reg_tipo)
VALUES(2, 'pessoa', 'get', 'SELECT');


INSERT INTO public.perfil (perf_id,perf_nome,perf_descricao,perf_ativo)
	VALUES (1,'ADMINISTRADOR','Controle total',true);
INSERT INTO public.perfil (perf_id,perf_nome,perf_descricao,perf_ativo)
	VALUES (2,'CLIENTE','Limitado',true);


INSERT INTO public.pessoa
(pes_id, pes_nome, pes_cpf, pes_dt_nascimento, pes_nome_mae, pes_nome_pai, pes_data_hora_cadastro, pes_estado_civil, pes_email, pes_sexo, pes_ativo, pes_password)
VALUES (1, 'Alexandre', 99999999999, '2000-01-01', 'Maria', 'José', '2021-04-08 00:00:00.000', 'SOLTEIRO', 'ale@gmail.com', 'MASCULINO', true, 'dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w='),
(2, 'Samara', 99999999998, '2000-01-01', 'Maria', 'José', '2021-04-08 00:00:00.000', 'SOLTEIRO', 'sam@gmail.com', 'FEMININO', true, 'dQNjUIMorJb8Ubj2+wVGYp6eAeYkdekqAcnYp+aRq5w=');


INSERT INTO public.perfil_regras (perf_id,reg_id) VALUES
(1,1),
(1,2),
(2,2);

INSERT INTO public.pessoa_perfil
(pes_id, perf_id)
VALUES(1, 1), (2, 2);

