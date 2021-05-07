package code.quarkus.modules.core.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EstadoCivil {
    SOLTEIRO("Solteiro(a)"),
    CASADO("Casado(a)"),
    DIVORCIADO("Divorciado(a)"),
    VIUVO("Viúvo(a)"),
    SEPARADO("Separado(a)");

    @JsonSerialize(using = ToStringSerializer.class)
    private String descricao;

    private EstadoCivil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getName() {
        return name();
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static EstadoCivil findValue(Object name) {
        if (name instanceof String) {
            return EstadoCivil.valueOf(name.toString());
        }
        Map<String, String> example = (Map<String, String>) name;
        return EstadoCivil.valueOf(example.get("name"));
    }
}