package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Set;

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
      String hql="select t from Ticket t where t.beginning=:beginning and t.destination=:destination" +
              " and t.departureDate=:departureDate";
        Query<Ticket> ticket= session.createQuery(hql, Ticket.class);
        ticket.setParameter("beginning", beginning);
        ticket.setParameter("destination", destination);
        ticket.setParameter("departureDate",departureDate);
        return ticket.getResultList();
    }
}
