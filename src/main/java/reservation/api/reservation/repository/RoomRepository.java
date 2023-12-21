package reservation.api.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.ReservationDto;
import reservation.api.reservation.dto.RoomDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query("select new reservation.api.reservation.dto.RoomDto(" +
            "r.id, r.status) " +
            "from Room r ")
    RoomDto findRoomDtoById(@Param("id") Long id);
}
