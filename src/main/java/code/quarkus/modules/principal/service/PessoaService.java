package code.quarkus.modules.principal.service;

import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;

public class PessoaService implements IpessoaService {

    @Override
    public void insert(PessoaDTO pessoaDTO) {
        //Pessoa.persist();
    }
}
