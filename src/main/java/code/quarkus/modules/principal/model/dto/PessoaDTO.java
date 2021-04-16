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

    @Column(name = "pes_nome")
    private final String nome;

    @Column(name = "pes_cpf")
    private final Long cpf;

    @Column(name = "pes_dt_nascimento")
    private final LocalDate dataNascimento;

    @Column(name = "pes_nome_mae")
    private final String nomeMae;

    @Column(name = "pes_nome_pai")
    private final String nomePai;

    @Column(name = "pes_estado_civil")
    @Enumerated(EnumType.STRING)
    private final EstadoCivil estadoCivil;

    @Column(name = "pes_email")
    private final String email;

    @Column(name = "pes_sexo")
    @Enumerated(EnumType.STRING)
    private final Sexo sexo;
}
