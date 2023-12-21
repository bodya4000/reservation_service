package reservation.api.reservation.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import reservation.api.reservation.dto.Status;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

//    public void setRoom(Room room) {
//        if(room.getStatus().equals(Status.AVAILABLE)){
//            this.room = room;
//        }
//    }
}
