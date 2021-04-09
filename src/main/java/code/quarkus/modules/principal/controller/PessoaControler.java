package code.quarkus.modules.principal.controller;

import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;
import java.util.List;

@Path("pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaControler {

    @GET
    public List<Pessoa> buscarTodasPessoas(){
        return Pessoa.listAll();
    }

    @POST
    public void inserir(PessoaDTO pessoaDTO){
        System.out.println("nada");
    }
}
