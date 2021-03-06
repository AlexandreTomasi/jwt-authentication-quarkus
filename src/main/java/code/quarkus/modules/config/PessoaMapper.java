package code.quarkus.modules.config;

import code.quarkus.modules.principal.model.Pessoa;
import code.quarkus.modules.principal.model.dto.PessoaDTO;
import org.mapstruct.Mapper;
@Mapper(config = QuarkusMappingConfig.class)
public interface PessoaMapper {
    //@Mapping(target = "surname", source = "lastname")
    PessoaDTO toResource(Pessoa pessoa);
    Pessoa toResource(PessoaDTO pessoaDTO);
}
