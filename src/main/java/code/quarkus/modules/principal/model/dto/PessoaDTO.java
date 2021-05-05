package code.quarkus.modules.principal.model.dto;

import code.quarkus.modules.core.enums.EstadoCivil;
import code.quarkus.modules.core.enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PessoaDTO  {

    private final String nome;

    private final Long cpf;

    private final LocalDate dataNascimento;

    private final String nomeMae;

    private final String nomePai;

    private final EstadoCivil estadoCivil;

    private final String email;

    private final Sexo sexo;

    private String password;
}
