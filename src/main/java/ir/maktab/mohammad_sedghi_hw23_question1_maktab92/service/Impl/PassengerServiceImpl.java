package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.Impl;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.Impl.BaseServiceImpl;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.repository.PassengerRepository;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service.PassengerService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.util.HelloServlet;

import java.util.Optional;

public class PassengerServiceImpl extends BaseServiceImpl<Passenger,Long, PassengerRepository>
        implements PassengerService {
    private PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        super(passengerRepository);
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger findByUsernameAndPassword(String username, String password) {
        Optional<Passenger> optionalPerson = passengerRepository.findByUsernameAndPassword(username, password);

        optionalPerson.ifPresentOrElse(
                person -> {
                    HelloServlet.member = person;
                },
                () -> {
                    System.out.println("Person not found. Start login again.");
                    HelloServlet.member=null;

                }
        );
        return null;
    }
}
