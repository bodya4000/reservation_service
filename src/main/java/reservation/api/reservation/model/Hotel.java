package reservation.api.reservation.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private float rating;

    @Column
    private float popularity;

    @Column
    private String logoImg;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    public void addRoom(Room room){
        rooms.add(room);
        room.setHotel(this);
    }

    public void remove(Room room){
        rooms.add(room);
        room.setHotel(this);
    }
}
