package code.quarkus.modules.principal.model;

import code.quarkus.modules.core.enums.EstadoCivil;
import code.quarkus.modules.core.enums.Sexo;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Pessoa extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "pessoa_seq_id")
    @Column(name = "pes_id")
    private Long id;

    @Column(name = "pes_nome")
    private String nome;

    @Column(name = "pes_cpf")
    private Long cpf;

    @Column(name = "pes_dt_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "pes_nome_mae")
    private String nomeMae;

    @Column(name = "pes_nome_pai")
    private String nomePai;

    @CreationTimestamp
    @Column(name = "pes_data_hora_cadastro")
    private LocalDateTime dataInsercao = LocalDateTime.now();

    @Column(name = "pes_estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name = "pes_email")
    private String email;

    @Column(name = "pes_sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "pes_ativo")
    private Boolean ativo = true;
}
