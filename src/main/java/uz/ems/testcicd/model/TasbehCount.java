package uz.ems.testcicd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tasbeh_count")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasbehCount {

    @Id
    private Long id;

    @OneToOne
    private User user;

    private Long count;
}
