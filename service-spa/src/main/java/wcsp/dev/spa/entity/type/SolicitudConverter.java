package wcsp.dev.spa.entity.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SolicitudConverter implements AttributeConverter<Estado, String> {
    @Override
    public String convertToDatabaseColumn(Estado attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getEstado();
    }

    @Override
    public Estado convertToEntityAttribute(String string) {
        if (string == null) {
            return null;
        }

        return Stream.of(Estado.values())
                .filter(c -> c.getEstado().equals(string))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
