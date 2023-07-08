package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.BaseService;


import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public class BaseServiceImpl <E extends BaseEntity<ID>,ID extends Serializable,
        REPOSITORY extends BaseRepository<E,ID>>implements BaseService<E,ID> {

   private REPOSITORY repository;
    @Override
    public E save(E entity) {
repository.getSession().getTransaction().begin();
repository.save(entity);
repository.getSession().getTransaction().commit();

        return null;
    }

    @Override
    public E update(E entity) {
        repository.getSession().getTransaction().begin();
        repository.update(entity);
        repository.getSession().getTransaction().commit();
        return null;
    }

    @Override
    public E remove(E entity) {
        repository.getSession().getTransaction().begin();
        repository.remove(entity);
        repository.getSession().getTransaction().commit();
        return entity;
    }

    @Override
    public Collection<E> load() {

        return repository.load();
    }

    @Override
    public Optional<E> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<E> findByEntity(E entity) {
        return repository.findByEntity(entity);
    }
}
