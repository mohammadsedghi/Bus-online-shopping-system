package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable>
        implements BaseRepository<E, ID> {
    private final Session session;

    protected BaseRepositoryImpl(Session session) {
        this.session = session;

    }

    @Override
    public E save(E entity) {
        session.persist(entity);
        return entity;
    }

    @Override
    public E update(E entity) {
        session.merge(entity);
        return entity;
    }

    @Override
    public E remove(E entity) {
        session.remove(entity);
        return entity;
    }

    @Override
    public Collection<E> load() {
        return session.createQuery("from" + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public Optional<E> findById(ID id) {
        return Optional.ofNullable(session.find(getEntityClass(), id));
    }

    @Override
    public Optional<E> findByEntity(E entity) {
        return Optional.ofNullable(session.find(getEntityClass(), entity));
    }

    public abstract Class<E> getEntityClass();
}
