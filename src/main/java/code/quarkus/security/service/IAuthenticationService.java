package code.quarkus.security.service;

import code.quarkus.security.model.AuthRequest;

import javax.ws.rs.core.Response;

public interface IAuthenticationService {

    Response authentication(AuthRequest authRequest);
}
