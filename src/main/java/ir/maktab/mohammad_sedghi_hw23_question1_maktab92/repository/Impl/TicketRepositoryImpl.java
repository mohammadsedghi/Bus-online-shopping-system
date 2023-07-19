package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;


public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket,Long>
        implements TicketRepository {
  private  Session session;

    public TicketRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    @Override
    public Collection<Ticket> findPath(String beginning, String destination, LocalDate departureDate) {
//      CriteriaBuilder cb = session.getCriteriaBuilder();
//      CriteriaQuery<Ticket> cr = cb.createQuery(Ticket.class);
//      Root<Ticket> root = cr.from(Ticket.class);
//      Predicate[] predicates = new Predicate[3];
//      predicates[0] = cb.equal(root.get("beginning"),beginning);
//      predicates[1] = cb.equal(root.get("destination"), destination);
//      predicates[2] = cb.greaterThanOrEqualTo(root.get("departureDate"),departureDate );
//      cr.select(root).where(predicates);
//      cr.orderBy(cb.desc(root.get("departureTime")));
//      TypedQuery<Ticket> query = session.createQuery(cr);
//      return query.getResultList();

      String hql="select t from Ticket t  where t.beginning=:beginning and t.destination=:destination" +
              " and t.departureDate=:departureDate and t.nationalId is null order by t.departureTime asc ";
        Query<Ticket> ticket= session.createQuery(hql, Ticket.class);
        ticket.setParameter("beginning", beginning);
        ticket.setParameter("destination", destination);
        ticket.setParameter("departureDate",departureDate);
        return ticket.getResultList();
    }

  @Override
  public Collection<Ticket> findTicketByMemberId(Long id) {
      String hql="select t from Ticket t where t.member.id=:id";
    Query<Ticket> ticket= session.createQuery(hql, Ticket.class);
    ticket.setParameter("id", id);
      return ticket.getResultList();
  }


}
