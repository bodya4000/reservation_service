package reservation.api.reservation.dto;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public record ReservationDto(
        Long id,
        LocalDate startDate,
        LocalDate endDate,
        ClientDto clientDto
) {}
