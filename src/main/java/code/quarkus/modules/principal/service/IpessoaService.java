package code.quarkus.modules.principal.service;

import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;

import java.util.List;

public interface IpessoaService {
    void insert(PessoaDTO pessoaDTO);

    Pessoa findByNomeAndSenha(String login, String senha);

    List<PessoaDTO> listaPessoas();
}
