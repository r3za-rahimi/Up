package com.example.up.converter;

import java.util.List;

public interface BaseConverter <E , D>{

    E convertDto(D dto);
    List<E> convertDtos(List<D> dto);
    D convertEntity(E dto);
    List<D> convertEntities(List<E> dto);
}
