package reservation.api.reservation.repository;

import org.springframework.data.repository.query.Param;
import reservation.api.reservation.dto.HotelDto;

public interface CustomHotelRepository {
    HotelDto findHotelDtoById(Long id);
}
