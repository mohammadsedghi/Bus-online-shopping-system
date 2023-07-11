package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.PassengerRepository;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class PassengerRepositoryImpl extends BaseRepositoryImpl<Passenger,Long>
        implements PassengerRepository {
    private Session session;
    public PassengerRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Passenger> getEntityClass() {
        return Passenger.class;
    }

    @Override
    public Optional<Passenger> findByUsernameAndPassword(String username, String password) {
        try {
            String hql = "select p from Passenger p where p.username=:username AND p.password=:password";
            Query<Passenger> user = session.createQuery(hql, Passenger.class);
            user.setParameter("username", username);
            user.setParameter("password", password);
            return Optional.of(user.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }

    }
}
