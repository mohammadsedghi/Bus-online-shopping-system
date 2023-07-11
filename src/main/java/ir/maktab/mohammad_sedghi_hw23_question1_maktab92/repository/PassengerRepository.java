package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.repositpry.BaseRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;

import java.util.Optional;

public interface PassengerRepository extends BaseRepository<Passenger,Long> {
    Optional<Passenger> findByUsernameAndPassword(String username, String password);
}
