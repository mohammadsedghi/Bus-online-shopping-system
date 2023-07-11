package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.service;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.service.BaseService;
import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity.Passenger;

public interface PassengerService extends BaseService<Passenger,Long> {
    Passenger findByUsernameAndPassword(String username, String password);
}
