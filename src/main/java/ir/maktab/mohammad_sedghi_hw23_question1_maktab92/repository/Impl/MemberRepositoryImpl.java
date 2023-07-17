package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Member;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.MemberRepository;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Optional;

public class MemberRepositoryImpl extends BaseRepositoryImpl<Member,Long>
        implements MemberRepository {
    private Session session;
    public MemberRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Member> getEntityClass() {
        return Member.class;
    }

    @Override
    public Optional<Member> findByUsernameAndPassword(String username, String password) {
        try {
            String hql = "select p from Member p where p.username=:username AND p.password=:password";
            Query<Member> user = session.createQuery(hql, Member.class);
            user.setParameter("username", username);
            user.setParameter("password", password);
            return Optional.of(user.getSingleResult());
        }catch (NoResultException e){
            return Optional.empty();
        }

    }
}
