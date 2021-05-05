package code.quarkus.modules.principal.service;

import code.quarkus.modules.config.PessoaMapper;
import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;
import code.quarkus.modules.principal.repository.PessoaRepository;
import code.quarkus.security.service.PBKDF2Encoder;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PessoaService implements IpessoaService {

    @Inject
    PessoaMapper pessoaMapper;

    @Inject
    PessoaRepository pessoaRepository;

    @Inject
    PBKDF2Encoder passwordEncoder;

    @Override
    @Transactional
    public void insert(PessoaDTO pessoaDTO) {

        Pessoa pessoa = pessoaMapper.toResource( pessoaDTO );
        pessoa.setPassword(passwordEncoder.encode(pessoaDTO.getPassword()));
        Pessoa.persist(pessoa);
    }

    @Override
    public Pessoa findByNomeAndSenha(String login, String senha) {
        return pessoaRepository.findByLoginSenha(login, senha);
    }

    @Override
    public List<PessoaDTO> listaPessoas() {
         List<Pessoa> pessoas = pessoaRepository.findAll().list();
         if(pessoas != null && !pessoas.isEmpty()) {
             List<PessoaDTO> resultado = new ArrayList<>();
             for (Pessoa pess : pessoas) {
                 PessoaDTO dto = pessoaMapper.toResource(pess);
                 resultado.add(dto);
             }
             return resultado;
         }else{
             return null;
         }
        //
    }
}
