package code.quarkus.modules.principal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Perfil extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "perfil_seq_id")
    @Column(name = "perf_id")
    private Long id;

    @Column(name = "perf_nome")
    private String nome;

    @Column(name = "perf_descricao")
    private String descricao;

    @Column(name = "perf_ativo")
    private Boolean ativo;

    @JsonIgnore
    @ManyToMany(mappedBy = "perfils", fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private List<Pessoa> pessoas = new ArrayList<>();

    @JsonIgnoreProperties({"perfils"})
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "PERFIL_REGRAS",
            joinColumns = @JoinColumn(name = "PERF_ID"),
            inverseJoinColumns = @JoinColumn(name = "REG_ID")
    )
    private List<Regra> regras = new ArrayList<>();
}
