package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.BaseService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;

import java.time.LocalDate;
import java.util.Collection;

public interface TicketService extends BaseService<Ticket,Long> {
    Collection<Ticket> findPath(String beginning, String destination, LocalDate departureDate);
    Collection<Ticket> findTicketByMemberId(Long id);

}
