package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Ticket;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface TicketRepository extends BaseRepository<Ticket,Long> {
    Collection<Ticket> findPath(String beginning, String destination, LocalDate departureDate);

    Collection<Ticket> findTicketByMemberId(Long id);
}
