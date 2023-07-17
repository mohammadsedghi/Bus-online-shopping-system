package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TripRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;


public class TripRepositoryImpl extends BaseRepositoryImpl<Trip,Long>
        implements TripRepository {
  private  Session session;

    public TripRepositoryImpl(Session session) {
        super(session);
        this.session=session;
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public Class<Trip> getEntityClass() {
        return Trip.class;
    }

    @Override
    public Collection<Trip> findPath(String beginning, String destination, LocalDate departureDate) {
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



      String hql="select t from Trip t  where t.beginning=:beginning and t.destination=:destination" +
              " and t.departureDate=:departureDate  order by t.departureTime asc ";
        Query<Trip> ticket= session.createQuery(hql, Trip.class);
        ticket.setParameter("beginning", beginning);
        ticket.setParameter("destination", destination);
        ticket.setParameter("departureDate",departureDate);
        return ticket.getResultList();
    }

  @Override
  public Collection<Trip> findBoughtTicket(String nationalIdMember) {
      //TODO SOMETHING
//    String hql="select t from Trip t  where t.passenger.nationalId=:nationalId";
//    Query<Trip> ticket= session.createQuery(hql, Trip.class);
//    ticket.setParameter("nationalId", nationalIdMember);
//    return ticket.getResultList();
    return null;
  }
}
