package reservation.api.reservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Reservation> reservations;

    public void addReservations(Reservation reservation) {
        reservations.add(reservation);
        reservation.setClient(this);
    }
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
        reservation.setClient(null);
    }
}
