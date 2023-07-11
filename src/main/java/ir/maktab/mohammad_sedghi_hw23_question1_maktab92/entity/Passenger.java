package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import jakarta.persistence.Entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Passenger extends BaseEntity<Long> {
    String firstName;
    String lastName;
    String nationalId;
    String gender;
    String username;
    String password;

}
