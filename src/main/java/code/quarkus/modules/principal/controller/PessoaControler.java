package code.quarkus.modules.principal.controller;

import code.quarkus.modules.principal.model.dto.PessoaDTO;
import code.quarkus.modules.principal.service.IpessoaService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaControler {

    @Inject
    IpessoaService ipessoaService;

    @GET @RolesAllowed("pessoaSELECT")
    public List<PessoaDTO> buscarTodasPessoas(){
        return ipessoaService.listaPessoas();
    }

    @POST @RolesAllowed("pessoaUPDATE")
    public void inserir(PessoaDTO pessoaDTO){
        ipessoaService.insert(pessoaDTO);
    }
}
