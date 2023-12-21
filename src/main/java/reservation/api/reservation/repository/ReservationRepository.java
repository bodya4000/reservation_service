package reservation.api.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.HotelDto;
import reservation.api.reservation.dto.ReservationDto;
import reservation.api.reservation.model.Client;
import reservation.api.reservation.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select new reservation.api.reservation.dto.ReservationDto(" +
            "r.id, r.startDate, r.endDate) " +
            "from Reservation r ")
    ReservationDto findReservationDtoById(@Param("id") Long id);
}
