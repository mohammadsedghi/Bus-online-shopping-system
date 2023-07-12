package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.impl.BaseRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import org.hibernate.Session;

import java.time.LocalDate;
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
    public Set<Ticket> findPath(String beginning, String destination, LocalDate departureDate) {
        return null;
    }
}
