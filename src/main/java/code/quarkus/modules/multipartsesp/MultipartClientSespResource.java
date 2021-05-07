package code.quarkus.modules.multipartsesp;

import code.quarkus.modules.multipart.MultipartBody;
import code.quarkus.modules.multipart.MultipartService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Path("/client")
public class MultipartClientSespResource {

    @Inject
    @RestClient
    MultipartServiceSesp service;

    @PermitAll
    @POST
    @Path("/multipartsesp")
    @Produces(MediaType.TEXT_PLAIN)
    public String sendFileSesp() throws Exception {
        MultipartBodySesp body = new MultipartBodySesp();
        body.idPreOcorrencia = 312;
        body.anexo = new ByteArrayInputStream("HELLO WORLD".getBytes(StandardCharsets.UTF_8));
        return service.sendMultipartData(body);
    }
}