package reservation.api.reservation.repository.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import reservation.api.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{
//    @Query("select new reservation.api.reservation.dto.ReservationDto(" +
//            "r.id, r.startDate, r.endDate) " +
//            "from Reservation r ")
//    ReservationDto findReservationDtoById(@Param("id") Long id);
}
