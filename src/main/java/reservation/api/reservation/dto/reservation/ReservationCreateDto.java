package reservation.api.reservation.dto.reservation;

import java.time.LocalDate;

public record ReservationCreateDto(
        Long clientId,
        Long roomId,
        LocalDate startDate,
        LocalDate endDate
) {
}
