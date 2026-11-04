package com.university.university.controller;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

public abstract class CrudController<T, ID> {
    private final JpaRepository<T, ID> repository;
    private final Function<String, ID> idParser;
    private final BiConsumer<T, ID> idSetter;

    protected CrudController(JpaRepository<T, ID> repository, Function<String, ID> idParser, BiConsumer<T, ID> idSetter) {
        this.repository = repository;
        this.idParser = idParser;
        this.idSetter = idSetter;
    }

    @GetMapping
    public List<T> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public T getOne(@PathVariable String id) { return find(idParser.apply(id)); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T create(@RequestBody T entity) { return repository.save(entity); }

    @PutMapping("/{id}")
    public T update(@PathVariable String id, @RequestBody T entity) {
        ID parsedId = idParser.apply(id);
        find(parsedId);
        idSetter.accept(entity, parsedId);
        return repository.save(entity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) { repository.delete(find(idParser.apply(id))); }

    private T find(ID id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Record not found"));
    }
}
