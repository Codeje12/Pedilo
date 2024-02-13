package com.pedilo.clic.pedilo.service;

import com.pedilo.clic.pedilo.modelo.TipoUnidad;
import com.pedilo.clic.pedilo.repository.TipoUnidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class TipoUnidadService implements TipoUnidadRepository {
    @Autowired
    private TipoUnidadRepository tipoUnidadRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends TipoUnidad> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<TipoUnidad> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TipoUnidad getOne(Long aLong) {
        return tipoUnidadRepository.getOne(aLong);
    }

    @Override
    public TipoUnidad getById(Long id) {
        return tipoUnidadRepository.findById(id).get();
    }

    @Override
    public TipoUnidad getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TipoUnidad> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TipoUnidad> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends TipoUnidad, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends TipoUnidad> S save(S entity) {
        return tipoUnidadRepository.save(entity);
    }

    @Override
    public <S extends TipoUnidad> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<TipoUnidad> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<TipoUnidad> findAll() {
        return tipoUnidadRepository.findAll();
    }

    @Override
    public List<TipoUnidad> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(TipoUnidad entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends TipoUnidad> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<TipoUnidad> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TipoUnidad> findAll(Pageable pageable) {
        return null;
    }
}
