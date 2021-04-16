package code.quarkus.modules.principal.repository;

import code.quarkus.modules.principal.model.Pessoa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {

    public Pessoa findByLoginSenha(String email, String senha){
        return find("UPPER(email) like UPPER(?1) AND UPPER(password) like UPPER(?2) AND ativo = true", email, senha).firstResult();
    }
}
