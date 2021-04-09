package code.quarkus.modules.principal.service;

import code.quarkus.modules.config.PessoaMapper;
import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PessoaService implements IpessoaService {

    @Inject
    PessoaMapper pessoaMapper;

    @Override
    @Transactional
    public void insert(PessoaDTO pessoaDTO) {

        Pessoa pessoa = pessoaMapper.toResource( pessoaDTO );
        Pessoa.persist(pessoa);
    }
}
