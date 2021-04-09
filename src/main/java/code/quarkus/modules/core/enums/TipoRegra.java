package code.quarkus.modules.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoRegra {
    SELECT("Consulta"),
    UPDATE("Alteração"),
    DELETE("Remoção"),
    UPDATE_DELETE("Alteração e remoção");

    @JsonSerialize(using = ToStringSerializer.class)
    private String descricao;

    private TipoRegra(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getName() {
        return name();
    }

    @JsonCreator
    public static TipoRegra findValue(Object name) {
        if (name instanceof String) {
            return TipoRegra.valueOf(name.toString());
        }
        Map<String, String> example = (Map<String, String>) name;
        return TipoRegra.valueOf(example.get("name"));
    }
}