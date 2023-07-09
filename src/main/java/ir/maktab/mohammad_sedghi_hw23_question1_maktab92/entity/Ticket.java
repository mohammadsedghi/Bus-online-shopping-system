package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket extends BaseEntity<Long> {
    @ManyToOne
    Passenger passenger;
    String from;
    String destination;
    LocalDate departureDate;
    String departureTime;
    String travelId;

}
