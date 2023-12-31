package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.TicketService;

import java.time.LocalDate;
import java.util.Collection;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository>
        implements TicketService {
private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
    }
    @Override
    public Collection<Ticket> findPath(String beginning, String destination, LocalDate departureDate) {
        return ticketRepository.findPath(beginning,destination,departureDate);
    }

    @Override
    public Collection<Ticket> findTicketByMemberId(Long id) {
    return ticketRepository.findTicketByMemberId(id);
    }


}
