package reservation.api.reservation.dto.room;

import reservation.api.reservation.dto.reservation.ReservationReadDto;
import reservation.api.reservation.dto.reservation.ReservationReadHotelDto;

import java.util.List;

public record RoomReadWithReservation(
        Long id,
        Status status,
        List<ReservationReadHotelDto> reservationReadDtos
){}
