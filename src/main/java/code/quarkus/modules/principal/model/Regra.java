package code.quarkus.modules.principal.model;

import code.quarkus.modules.core.enums.TipoRegra;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "regras")
public class Regra extends PanacheEntityBase {
    @Id
    @GeneratedValue(generator = "regras_seq_id")
    @Column(name = "reg_id")
    private Long id;

    @Column(name = "reg_nome")
    private String nome;

    @Column(name = "reg_descricao")
    private String descricao;

    @Column(name = "reg_tipo")
    @Enumerated(EnumType.STRING)
    private TipoRegra tipoRegra;

    @JsonIgnore
    @ManyToMany(mappedBy = "regras", fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @ToString.Exclude
    private List<Perfil> perfils = new ArrayList<>();

    public String regraString(){
        if(nome != null && tipoRegra != null) {
            return nome + tipoRegra.getName();
        }
        return null;
    }

    public void setNome(String nome) {
        this.nome = nome.toLowerCase();
    }
}
