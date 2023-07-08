package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface BaseRepository <E extends BaseEntity<ID>,ID extends Serializable> {
    E save(E entity);
    E update(E entity);
    E remove(E entity);
    Collection<E> load();
    Optional<E> findById(ID id);
    Optional<E> findByEntity(E entity);
    Session getSession();
}
