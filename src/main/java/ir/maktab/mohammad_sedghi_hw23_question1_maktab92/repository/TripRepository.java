package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;

import java.time.LocalDate;
import java.util.Collection;

public interface TripRepository extends BaseRepository<Trip,Long> {
    Collection<Trip> findPath(String beginning, String destination, LocalDate departureDate);
    Collection<Trip> findBoughtTicket(String nationalIdMember);

}
