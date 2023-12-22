package reservation.api.reservation.dto.reservation;

import reservation.api.reservation.dto.client.ClientDto;
import reservation.api.reservation.dto.room.RoomReadDto;
import reservation.api.reservation.dto.room.RoomReadWithReservation;

import java.time.LocalDate;

public record ReservationReadDto(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        ClientDto clientDto,
        RoomReadDto roomReadDto
) {}
