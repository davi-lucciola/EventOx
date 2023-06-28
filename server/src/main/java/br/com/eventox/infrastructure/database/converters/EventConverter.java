package br.com.eventox.infrastructure.database.converters;

import br.com.eventox.domain.models.EventDO;
import br.com.eventox.infrastructure.database.entities.EventEntity;

public class EventConverter {
    public static EventDO converter(EventEntity entity) {
        if (entity == null) return null;

        return new EventDO(
                entity.getId(),
                entity.getName(),
                entity.getDate(),
                entity.getPrice(),
                entity.getDescription(),
                entity.getCapacity(),
                entity.getSold()
        );
    }

    public static EventEntity converter(EventDO domain) {
        if (domain == null) return null;

        return new EventEntity(
                domain.getId(),
                domain.getName(),
                domain.getDate(),
                domain.getPrice(),
                domain.getDescription(),
                domain.getCapacity(),
                domain.getSold()
        );
    }
}
