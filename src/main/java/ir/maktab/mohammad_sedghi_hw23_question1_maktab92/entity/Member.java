package ir.maktab.mohammad_sedghi_hw23_question1_maktab92.entity;

import ir.maktab.mohammad_sedghi_hw23_question1_maktab92.base.entity.BaseEntity;
import jakarta.persistence.Entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.UniqueElements;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Member extends BaseEntity<Long> {
    @NotNull(message = "age must be have value")
    String firstName;
    @NotNull(message = "age must be have value")
    String lastName;
    @Size(min = 10)
    @Size(max = 10)
    @Pattern(regexp = "\\d+", message = "only digits are allowed")
    String nationalId;
    String gender;
    @NotNull(message = "age must be have value")
    String username;
    @NotNull(message = "age must be have value")
    String password;

}
