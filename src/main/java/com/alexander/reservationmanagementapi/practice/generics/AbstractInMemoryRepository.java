package com.alexander.reservationmanagementapi.practice.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractInMemoryRepository<T extends Identifiable<ID>, ID>
        implements InMemoryRepository<T, ID> {

    private final List<T> entities = new ArrayList<>();

    @Override
    public T save(T entity) {
        entities.add(entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void deleteById(ID id) {
        entities.removeIf(entity -> entity.getId().equals(id));
    }
}
