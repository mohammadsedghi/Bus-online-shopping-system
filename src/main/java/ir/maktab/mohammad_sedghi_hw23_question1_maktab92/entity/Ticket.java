package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity<Long> {
    @ManyToOne
    Member member;
    String beginning;
    String destination;
    LocalDate departureDate;
    LocalTime departureTime;
    String travelId;
    String nameAndFamily;
    String gender;
    String nationalId;

    public Ticket(String beginning, String destination, LocalDate departureDate, LocalTime departureTime, String travelId) {
        this.beginning = beginning;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.travelId = travelId;
    }

}
