package com.pedilo.clic.pedilo.service;

import com.pedilo.clic.pedilo.modelo.Configuracion;
import com.pedilo.clic.pedilo.repository.ConfiguracionRepository;
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
public class ConfiguracionService implements ConfiguracionRepository {

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends Configuracion> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Configuracion> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Configuracion> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Configuracion getOne(Long aLong) {
        return null;
    }

    @Override
    public Configuracion getById(Long aLong) {
        return null;
    }

    @Override
    public Configuracion getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Configuracion> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Configuracion> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Configuracion> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Configuracion> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Configuracion> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Configuracion> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Configuracion, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Configuracion> S save(S entity) {
        return configuracionRepository.save(entity);
    }

    @Override
    public <S extends Configuracion> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Configuracion> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Configuracion> findAll() {
        return configuracionRepository.findAll();
    }

    @Override
    public List<Configuracion> findAllById(Iterable<Long> longs) {
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
    public void delete(Configuracion entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Configuracion> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Configuracion> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Configuracion> findAll(Pageable pageable) {
        return null;
    }
}
