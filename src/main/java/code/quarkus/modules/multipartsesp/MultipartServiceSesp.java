package code.quarkus.modules.multipartsesp;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//@Path("/echo")
@Path("https://homolog2.sesp.mt.gov.br/ws-sesp-smtc/api/preocorrencia/upload")
@RegisterRestClient
public interface MultipartServiceSesp {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    String sendMultipartData(@MultipartForm MultipartBodySesp data);
}
