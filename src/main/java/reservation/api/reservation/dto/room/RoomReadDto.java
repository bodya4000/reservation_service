package reservation.api.reservation.dto.room;

import reservation.api.reservation.dto.reservation.ReservationReadDto;

import java.util.List;

public record RoomReadDto(
        Long id,
        Status status
){}
