package reservation.api.reservation.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.*;
import reservation.api.reservation.dto.Status;

import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private float rating;

    @Column
    private float popularity;

    @Column
    private String img;


    @ManyToOne
    @JoinColumn(name = "hotel_id", foreignKey = @ForeignKey(name = "hotel_fk"))
    private Hotel hotel;


    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "room")
    private List<Reservation> reservations;

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setRoom(this);
    }

    public void removeReservation(Reservation reservation){
        reservations.remove(reservation);
        reservation.setRoom(null);
    }
}
