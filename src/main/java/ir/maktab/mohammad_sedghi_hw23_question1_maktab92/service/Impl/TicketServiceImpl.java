package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.PassengerRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.PassengerService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.TicketService;

public class TicketServiceImpl extends BaseServiceImpl<Ticket,Long, TicketRepository>
        implements TicketService {
private  TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        super(ticketRepository);
        this.ticketRepository = ticketRepository;
    }
}
