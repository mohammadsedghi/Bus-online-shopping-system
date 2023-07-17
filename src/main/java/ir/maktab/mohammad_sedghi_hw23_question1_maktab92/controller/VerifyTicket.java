package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.controller;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.Impl.TicketRepositoryImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TicketRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl.TicketServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util.FilterCheck;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class VerifyTicket {
    public static List<Ticket> ticket;
    public static List<Ticket> boughtTicket;
    public static Ticket findTicket;
    TicketRepository ticketRepository;
    TicketServiceImpl ticketService;
    private SessionFactory sessionFactory;
public  List<Ticket> initializerBoughtTicket(){
    sessionFactory= HibernateUtil.getSessionFactory();
    Session sessionDb = sessionFactory.openSession();
    ticketRepository = new TicketRepositoryImpl(sessionDb);
    ticketService = new TicketServiceImpl(ticketRepository);
    Long id = FilterCheck.member.getId();
    List<Ticket> boughtTicketList =new ArrayList<>(ticketService.findTicketByMemberId(id));
   this.boughtTicket = boughtTicketList;
    return boughtTicketList;
}

}
