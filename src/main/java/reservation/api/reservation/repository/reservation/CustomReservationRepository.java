package reservation.api.reservation.repository.reservation;

import reservation.api.reservation.dto.reservation.ReservationCreateDto;

public interface CustomReservationRepository {

    void saveFrontReservationDto(ReservationCreateDto reservationCreateDto);
}
