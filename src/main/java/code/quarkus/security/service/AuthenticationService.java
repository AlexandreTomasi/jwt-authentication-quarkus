package code.quarkus.security.service;

import code.quarkus.modules.principal.model.Perfil;
import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.Regra;
import code.quarkus.modules.principal.service.IpessoaService;
import code.quarkus.security.model.AuthRequest;
import code.quarkus.security.model.AuthResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.HashSet;
import java.util.Set;

@ApplicationScoped
public class AuthenticationService implements IAuthenticationService {

    @Inject
    PBKDF2Encoder passwordEncoder;

    @Inject
    IpessoaService ipessoaService;

    @Inject
    TokenUtils tokenUtils;

    @Override
    public Response authentication(AuthRequest authRequest) {
        Pessoa pessoa = ipessoaService.findByNomeAndSenha(authRequest.getUsername(), passwordEncoder.encode(authRequest.getPassword()));

        if (pessoa != null) {
            try {
                Set<Regra> roles = new HashSet<>();
                if(pessoa.getPerfils() != null && !pessoa.getPerfils().isEmpty()) {
                    for (Perfil perfil : pessoa.getPerfils()) {
                        if(perfil.getRegras() != null && !perfil.getRegras().isEmpty()) {
                            for (Regra regra : perfil.getRegras()) {
                                roles.add(regra);
                            }
                        }
                    }
                }
                return Response.ok(new AuthResponse(tokenUtils.generateToken(pessoa.getNome(), roles))).build();
            } catch (Exception e) {
                return Response.status(Status.UNAUTHORIZED).build();
            }
        } else {
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }
}
