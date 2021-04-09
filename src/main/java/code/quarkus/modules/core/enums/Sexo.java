package code.quarkus.modules.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sexo {
    MASCULINO("Masculino"),
    FEMININO("Feminino");

    @JsonSerialize(using = ToStringSerializer.class)
    private String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getName() {
        return name();
    }

    @JsonCreator
    public static Sexo findValue(Object name) {
        if (name instanceof String) {
            return Sexo.valueOf(name.toString());
        }
        Map<String, String> example = (Map<String, String>) name;
        return Sexo.valueOf(example.get("name"));
    }
}