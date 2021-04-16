package code.quarkus.modules.principal.model;

import code.quarkus.modules.core.enums.EstadoCivil;
import code.quarkus.modules.core.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @Email
    private String email;

    @Column(name = "pes_sexo")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Column(name = "pes_ativo")
    private Boolean ativo = true;

    @Column(name = "pes_password")
    private String password;


    @JsonIgnoreProperties({"pessoas"})
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PESSOA_PERFIL",
            joinColumns = @JoinColumn(name = "PES_ID"),
            inverseJoinColumns = @JoinColumn(name = "PERF_ID")
    )
    private List<Perfil> perfils = new ArrayList<Perfil>();
}
