package reservation.api.reservation.repository.roomRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.room.RoomCreateDto;
import reservation.api.reservation.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
//    @Query("select new reservation.api.reservation.dto.RoomCreateDto(" +
//            "r.id, r.status) " +
//            "from Room r ")
//    RoomCreateDto findRoomDtoById(@Param("id") Long id);
}
