package code.quarkus.modules.multipartsesp;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

public class MultipartBodySesp {

    @FormParam("anexo")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    public InputStream anexo;

    @FormParam("idPreOcorrencia")
    @PartType(MediaType.TEXT_PLAIN)
    public Integer idPreOcorrencia;
}