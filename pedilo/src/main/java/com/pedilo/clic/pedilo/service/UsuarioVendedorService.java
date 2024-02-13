package com.pedilo.clic.pedilo.service;

import com.pedilo.clic.pedilo.modelo.UsuarioVendedor;
import com.pedilo.clic.pedilo.repository.UsuarioVendedorRepository;
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
public class UsuarioVendedorService implements UsuarioVendedorRepository {
    @Autowired
    private UsuarioVendedorRepository usuarioVendedorRepository;

    @Override
    public void flush() {

    }

    @Override
    public <S extends UsuarioVendedor> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<UsuarioVendedor> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public UsuarioVendedor getOne(Long aLong) {
        return null;
    }

    @Override
    public UsuarioVendedor getById(Long aLong) {
        return null;
    }

    @Override
    public UsuarioVendedor getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends UsuarioVendedor> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends UsuarioVendedor> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends UsuarioVendedor, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends UsuarioVendedor> S save(S entity) {
        return usuarioVendedorRepository.save(entity);
    }

    @Override
    public <S extends UsuarioVendedor> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<UsuarioVendedor> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<UsuarioVendedor> findAll() {
        return null;
    }

    @Override
    public List<UsuarioVendedor> findAllById(Iterable<Long> longs) {
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
    public void delete(UsuarioVendedor entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends UsuarioVendedor> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<UsuarioVendedor> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<UsuarioVendedor> findAll(Pageable pageable) {
        return null;
    }
}
