package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Trip;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.TripRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.TripService;

import java.time.LocalDate;
import java.util.Collection;

public class TripServiceImpl extends BaseServiceImpl<Trip,Long, TripRepository>
        implements TripService {
private TripRepository tripRepository;

    public TripServiceImpl(TripRepository tripRepository) {
        super(tripRepository);
        this.tripRepository = tripRepository;
    }
    @Override
    public Collection<Trip> findPath(String beginning, String destination, LocalDate departureDate) {
        return tripRepository.findPath(beginning,destination,departureDate);
    }

    @Override
    public Collection<Trip> findBoughtTicket(String nationalIdMember) {
        return tripRepository.findBoughtTicket(nationalIdMember);
    }
}
