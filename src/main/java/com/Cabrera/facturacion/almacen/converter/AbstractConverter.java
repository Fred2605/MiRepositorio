package com.Cabrera.facturacion.almacen.converter;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {
    public abstract D fromEntity(E entity);
    public abstract E fromDTO(D dto);

    public List<D> fromEntities(List<E> entities) {
        return entities.stream()
                .map(e -> fromEntity(e))
                .collect(Collectors.toList());
    }

    public List<E> fromDtos(List<D> dtos) {
        return dtos.stream()
                .map(d -> fromDTO(d))
                .collect(Collectors.toList());
    }
}